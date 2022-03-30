/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.adapters;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import net.catenax.semantics.framework.auth.TokenOutgoingInterceptor;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * adapts a remote twin registry (secured via Oauth2) to the IDS connector.
 */
@Service
public class TwinRegistryAdapter<Cmd extends Command, O extends Offer, Ct extends Catalog, Co extends Contract, T extends Transformation> extends BaseAdapter<Cmd,O,Ct,Co,T> {

    /**
     * creates a logger
     */
    protected final Logger logger= LoggerFactory.getLogger(getClass());

    /**
     * we need an interceptor that pushes tokens into the request
     */
    private final TokenOutgoingInterceptor interceptor;

    /**
     * creates a new adapter
     * @param configurationData external config
     * @param connector attached connector
     * @param interceptor token interceptor that pushes tokens to the requests
     */
    public TwinRegistryAdapter(Config<Cmd, O, Ct, Co, T> configurationData, IdsConnector connector, TokenOutgoingInterceptor interceptor) {
        super(configurationData);
        setIdsConnector(connector);
        this.interceptor = interceptor;
    }

    /**
     * when the service start it may read its config
     * and automatically publish stuff
     */
    @PostConstruct
    public void setup() {
        if (configurationData.isRegisterOnStart()) {
            for (TwinSource twin : configurationData.getTwinSources()) {
                try {
                    log.debug(registerTwins(twin.getProtocol(), twin.getCommand(), twin.getParameters()));
                } catch (Exception e) {
                    log.error("Could not register twins from command " + twin.getCommand() + " and protocol " + twin.getProtocol() + " in connector. Maybe it is not active?", e);
                }
            }
        }
    }

    /**
     * create a new http client for interfacing the registry
     * @return
     */
    public HttpClient getHttpClient() {
        String proxyHost=System.getProperty("http.proxyHost");
        HttpClient httpclient = null;
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
                httpclient = clientBuilder.build();
            }
        }
        if (httpclient == null) {
            HttpClientBuilder clientBuilder = HttpClients.custom();
            clientBuilder.addInterceptorFirst(interceptor);
            httpclient = clientBuilder.build();
        }
        return httpclient;
    }

    /**
     * registers new twins. This is a two-step process.
     * First, the given command is issues for the given protocol in the associated connector.
     * Secondly, the result is interpreted as a set of asset descriptors which
     * will be posted to the twin registry.
     * @param protocol   use the backend protocol
     * @param command    use the backend command
     * @param parameters a map of parameters
     * @return the registration response from the registry copied
     */
    public String registerTwins(String protocol, String command, Map<String, String> parameters) throws StatusException {
        // Step 1
        // create the connector request
        IdsRequest request = new IdsRequest();
        request.setProtocol(protocol);
        request.setCommand(command);
        request.setParameters(parameters);
        request.setModel("https://admin-shell.io/aas/API/AssetAdministrationShellDescriptor/1/0/RC02");
        request.setAccepts("application/json");
        // perform the connector request
        IdsResponse response = idsConnector.perform(request);
        try {
            IdsMessage responseMessage = response.getMessage().get();
            // here we are
            // TODO check for error status codes
            // Step 2 make outgoing calls to the registry

            // parse the twin recipe as asset descriptors
            ObjectMapper om = new ObjectMapper();
            JsonNode[] nodes = new JsonNode[]{om.readTree(responseMessage.getPayload())};
            if (nodes[0].isArray()) {
                ArrayNode arrayNode = (ArrayNode) nodes[0];
                nodes = new JsonNode[arrayNode.size()];
                for (int i = 0; i < arrayNode.size(); i++) {
                    nodes[i] = arrayNode.get(i);
                }
            }
            // TODO use the batch API once it is available
            StringBuilder finalResult = new StringBuilder();
            finalResult.append("[");
            for (int count = 0; count < nodes.length; count++) {
                HttpPost httppost = new HttpPost(configurationData.getServiceUrl() + "/registry/shell-descriptors");
                httppost.addHeader("accept", responseMessage.getMediaType());
                httppost.setHeader("Content-type", responseMessage.getMediaType());
                String thatPayLoad=om.writeValueAsString(nodes[count]);
                httppost.setEntity(new StringEntity(thatPayLoad));
                log.info("Accessing Twin Registry via " + httppost.getRequestLine());
                HttpResponse twinResponse = getHttpClient().execute(httppost);
                log.info("Received Twin Registry response " + twinResponse.getStatusLine());
                int statusCode = twinResponse.getStatusLine().getStatusCode();
                if (statusCode < 200 || statusCode >= 300) {
                    if (count > 0) {
                        finalResult.append(",");
                    }
                    finalResult.append("{ \"error\":\"Most likely the twin did already exist.\",\"status\":"+statusCode+"}");
                } else {
                    if (count > 0) {
                        finalResult.append(",");
                    }
                    finalResult.append(IOUtils.toString(twinResponse.getEntity().getContent()));
                }
            }
            finalResult.append("]");
            return finalResult.toString();
        } catch (InterruptedException | ExecutionException e) {
            throw new StatusException("Could not synchronize on twin backend request", e, 501);
        } catch (IOException e) {
            throw new StatusException("Could not perform twin registration request", e, 501);
        }
    }
}
