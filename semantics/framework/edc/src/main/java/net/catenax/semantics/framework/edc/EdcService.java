/*
Copyright (c) 2021-2022 T-Systems International GmbH
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.edc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.auth.TokenWrapper;
import net.catenax.semantics.framework.config.*;
import net.catenax.semantics.framework.ids.BaseConnector;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Conditional(EdcConfigurationCondition.class)
public class EdcService<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> extends BaseConnector<Cmd,O,Ct,Co,T> {


    public EdcService(Config<Cmd,O,Ct,Co, T> configurationData,
                      List<BackendAdapter> adapters,
                      List<Transformer> transformers) {
        super(configurationData,adapters,transformers);
    }

    public HttpClient getEdcClient() {
        HttpClient edcClient=null;
        String proxyHost=System.getProperty("http.proxyHost");

        boolean useApiKey = "X-Api-Key".equals(configurationData.getConnectorUser());

        String header;
        String token;

        if(!useApiKey) {
            header=TokenWrapper.AUTHORIZATION_HEADER;
            token = "Basic " + new String(Base64.encodeBase64((configurationData.getConnectorUser() + ":" + configurationData.getConnectorPassword()).getBytes()));
        } else {
            header=configurationData.getConnectorUser();
            token= configurationData.getConnectorPassword();
        }

        var interceptor=new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                httpRequest.addHeader(header, token);
            }
        };

        if (proxyHost != null && !proxyHost.isEmpty()) {
            boolean noProxy = false;
            for (String noProxyHost : System.getProperty("http.nonProxyHosts","localhost").split("\\|")) {
                noProxy = noProxy || configurationData.getServiceUrl().contains(noProxyHost.replace("*",""));
            }
            if (!noProxy) {
                HttpHost httpProxyHost = new HttpHost(proxyHost, Integer.parseInt(System.getProperty("http.proxyPort","80")));
                DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(httpProxyHost);
                HttpClientBuilder clientBuilder = HttpClients.custom();
                clientBuilder = clientBuilder.setRoutePlanner(routePlanner);
                clientBuilder = clientBuilder.addInterceptorFirst(interceptor);
                edcClient = clientBuilder.build();
            }
        }
        if (edcClient == null) {
            HttpClientBuilder clientBuilder = HttpClients.custom();
            clientBuilder.addInterceptorFirst(interceptor);
            edcClient = clientBuilder.build();
        }
        return edcClient;
    }

    public Offer getOrCreateOffer(String title) throws StatusException {
        O result=configurationData.getOffers().get(title);
        String assetUri=configurationData.getConnectorUrl() + "/data/assets";
        HttpGet httpget=new HttpGet(assetUri+"/"+title);
        try {
            HttpResponse lookup=getEdcClient().execute(httpget);
            if(lookup.getStatusLine().getStatusCode()>=200 && lookup.getStatusLine().getStatusCode()<300) {
                result.setPayload(EntityUtils.toString(lookup.getEntity(), "UTF-8"));
                return result;
            }
        } catch(IOException e) {
            throw new StatusException("Could not test whether offer is already present in EDC control plane",e,501);
        }
        HttpPost httppost = new HttpPost(assetUri);
        httppost.addHeader("accept", "*/*");
        httppost.setHeader("Content-type", "application/json");
        String userName=result.getUser();
        User user=configurationData.getSecurity().getUsers().get(userName);
        String token=userName+":"+user.getPassword();
        String authCode="Basic "+new String(java.util.Base64.getEncoder().encode(token.getBytes()));
        String thatPayLoad="{\n" +
                "  \"asset\": {\n" +
                "    \"properties\":{\n" +
                "      \"asset:prop:id\": \""+title+"\",\n" +
                "      \"asset:prop:name\": \""+ result.getDescription()+"\",\n" +
                "      \"asset:prop:contenttype\": \"application/json\",\n" +
                "      \"asset:prop:policy-id\": \"use-eu\"\n" +
                "    }\n" + 
                "  },\n" +
                "  \"dataAddress\": {\n" +
                "    \"properties\":{\n" +
                "      \"endpoint\": \""+configurationData.getAdapterUrl()+"/"+title+"\",\n" +
                "      \"authKey\": \"Authorization\",\n" +
                "      \"authCode\": \""+authCode+"\",\n" +
                "      \"proxyPath\": \"true\",\n" +
                "      \"proxyMethod\": \"true\",\n" +
                "      \"proxyQueryParams\": \"true\",\n" +
                "      \"proxyBody\": \"true\",\n" +
                "      \"type\": \"HttpData\"\n" +
                "    }\n" + 
                "  }\n" +
                "}";
        try {
            httppost.setEntity(new StringEntity(thatPayLoad));
            HttpResponse offerResponse = getEdcClient().execute(httppost);
            if(offerResponse.getStatusLine().getStatusCode()<200 || offerResponse.getStatusLine().getStatusCode()>299) {
                throw new StatusException("Could not create offer",offerResponse.getStatusLine().getStatusCode());
            }
            result.setPayload(thatPayLoad);
        } catch (IOException e) {
            throw new StatusException("Could not create offer",e,501);
        }
        return result;
    }

    public Contract getOrCreateContract(String title) throws StatusException {
        Co result=configurationData.getContracts().get(title);

        var relevantOffers= configurationData.getOffers().entrySet().stream().filter(offerEntry -> {
           if(title.equals(offerEntry.getValue().getContract())) {
                try {
                    HttpGet httpget = new HttpGet(configurationData.getConnectorUrl() + "/data/assets/" + offerEntry.getKey());
                    httpget.addHeader("accept", "*/*");
                    HttpResponse offerResponse = getEdcClient().execute(httpget);
                    if (offerResponse.getStatusLine().getStatusCode() >= 200 && offerResponse.getStatusLine().getStatusCode()<300) {
                        String responseString = EntityUtils.toString(offerResponse.getEntity(), "UTF-8");
                        if (responseString.contains(offerEntry.getKey())) {
                            return true;
                        }
                    }
                } catch(IOException e) {
                    // should rather except.
                }
           }
           return false;
        });

        HttpGet httpget = new HttpGet(configurationData.getConnectorUrl() + "/data/policies/"+title);
        try {
            HttpResponse policyResponse=getEdcClient().execute(httpget);
            if(policyResponse.getStatusLine().getStatusCode() == 200) {
                // policy already registered. may be should delete contract and policy?
                HttpDelete delete = new HttpDelete(configurationData.getConnectorUrl() + "/data/contractdefinitions/"+title);
                try {
                    getEdcClient().execute(delete);
                } catch(IOException e) {
                    throw new StatusException("Could not delete contractdefinition for update",e,501);
                }
                delete = new HttpDelete(configurationData.getConnectorUrl() + "/data/policies/"+title);
                try {
                    HttpResponse policyDelete=getEdcClient().execute(delete);
                    if(policyDelete.getStatusLine().getStatusCode()<200 ||  policyDelete.getStatusLine().getStatusCode()>=300) {
                        throw new StatusException("Could not delete policy for update",501);
                    }
                } catch(IOException e) {
                    throw new StatusException("Could not delete policy for update",e,501);
                }
            }
        } catch (IOException e) {
            throw new StatusException("Could not check policy "+title,e,501);
        }

        String permissions = relevantOffers.map( offerEntry ->
                   "      {\n" +
                   "        \"edctype\": \"dataspaceconnector:permission\",\n" +
                   "        \"target\": \""+offerEntry.getKey()+"\",\n" +
                   "        \"action\": {\n" +
                   "          \"type\": \"USE\"\n" +
                   "        }\n"+
                   "      }\n"
        ).collect(Collectors.joining(","));

        String policy="{\n" +
                "  \"uid\": \""+title+"\",\n" +
                "  \"permissions\": [\n" + permissions +
                "  ],\n" +
                "  \"@type\": {\n" +
                "    \"@policytype\": \"set\"\n" +
                "  }\n" +
                "}";

        HttpPost httppost = new HttpPost(configurationData.getConnectorUrl() + "/data/policies");
        httppost.addHeader("accept", "*/*");
        httppost.setHeader("Content-type", "application/json");
        try {
            httppost.setEntity(new StringEntity(policy));
            HttpResponse policyResponse=getEdcClient().execute(httppost);
            if(policyResponse.getStatusLine().getStatusCode() < 200 || policyResponse.getStatusLine().getStatusCode() >= 299) {
                throw new StatusException("Could not create policy",policyResponse.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            throw new StatusException("Could not create policy "+title,e,501);
        }

        String contract = "{\n" +
                "  \"id\": \""+title+"\",\n" +
                "  \"accessPolicyId\": \""+title+"\",\n" +
                "  \"contractPolicyId\": \""+title+"\",\n" +
                "  \"criteria\": []\n" +
                "}";

        httppost = new HttpPost(configurationData.getConnectorUrl() + "/data/contractdefinitions");
        httppost.addHeader("accept", "*/*");
        httppost.setHeader("Content-type", "application/json");
        try {
            httppost.setEntity(new StringEntity(contract));
            HttpResponse contractResponse = getEdcClient().execute(httppost);
            if(contractResponse.getStatusLine().getStatusCode()<200 || contractResponse.getStatusLine().getStatusCode()>299) {
                throw new StatusException("Could not create contract",contractResponse.getStatusLine().getStatusCode());
            }
            result.setPayload(contract);
        } catch (IOException e) {
            throw new StatusException("Could not create contract "+title,e,501);
        }

        return result;
    }

    @Override
    public Object getSelfDescription() {
        return new Object();
    }

}
