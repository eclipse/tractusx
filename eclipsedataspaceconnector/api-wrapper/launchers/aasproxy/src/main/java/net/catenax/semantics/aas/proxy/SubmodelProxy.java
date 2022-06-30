/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.proxy;

import feign.Feign;
import lombok.RequiredArgsConstructor;
import net.catenax.semantics.aas.api.shell.SubmodelInterfaceApi;
import net.catenax.semantics.framework.StatusException;
import net.catenax.semantics.framework.aas.api.proxy.AssetIdentifierApiDelegate;
import net.catenax.semantics.framework.aas.model.OperationRequest;
import net.catenax.semantics.framework.aas.model.OperationResult;
import net.catenax.semantics.framework.aas.model.Submodel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Submodel Repository Proxy implements the service layer behind the web protocol layer.
 */
@Service
@RequiredArgsConstructor
public class SubmodelProxy implements AssetIdentifierApiDelegate {
    /**
     * we got a rewrite storage for endpoints
     */
    protected final RewriteStorage storage;
    protected final ConfigurationData config;

    /**
     * we need to build delegates on the fly
     */
    protected final Feign.Builder builder;

    protected final static Pattern URL_WITH_PARAMS=Pattern.compile("(?<url>[^\\?]*)(\\?(?<params>[^\\?]*))?");
    protected final static Pattern URL_EDC=Pattern.compile("(?<protocol>http|edc)(?<secure>s)?://(?<provider>[^\\?/]+)/(?<bpn>[^\\?/]+)/(?<idsresource>[^\\?/]+)(?<suburl>[^\\?]*)");
    protected final static Pattern URL_PARAM=Pattern.compile("(\\&amp;)?(?<key>[^\\=\\&]*)\\=(?<value>[^\\=\\&]*)");

    /**
     * create a client based on the
     * actual endpoint
     * @param assetIdentifier identifier of the twin
     * @param submodelIdentifier identifier of the representation/aspect
     * @return client pointing to the correct original url
     */
    public Map.Entry<SubmodelInterfaceApi,Map<String,Object>> getSubmodelInterfaceApi(String assetIdentifier, String submodelIdentifier) throws StatusException {
        String endpoint = storage.getEndpoint(assetIdentifier, submodelIdentifier);

        if (endpoint == null) {
            throw new StatusException("No endpoint found", 501);
        }
        return getSubmodelInterfaceApi(endpoint);
    }

    /**
     * create a client based on the
     * actual endpoint
     * @param endpoint ready made endpoint
     * @return client pointing to the correct original url
     */
    public Map.Entry<SubmodelInterfaceApi,Map<String,Object>> getSubmodelInterfaceApi(String endpoint) throws StatusException {
        Matcher urlMatcher=URL_WITH_PARAMS.matcher(endpoint);
        if(!urlMatcher.matches()) {
            throw new StatusException("Endpoint url is not well-formed",501);
        }
        endpoint=urlMatcher.group("url");
        Map<String,Object> params=new HashMap<>();
        String uparams=urlMatcher.group("params");
        if(uparams!=null && !uparams.isEmpty()) {
            Matcher urlParam=URL_PARAM.matcher(uparams);
            while(urlParam.find()) {
                String key=urlParam.group("key");
                String value=urlParam.group("value");
                params.put(key,value);
            }
        }
        Matcher edcMatcher=URL_EDC.matcher(endpoint);
        if(edcMatcher.matches()) {
            endpoint=config.getWrapperUrl()+"/";
            endpoint=endpoint+RewriteStorage.encodeIfUndecoded(edcMatcher.group("idsresource"));
            endpoint=endpoint+edcMatcher.group("suburl");
            String protocol="http";
            if("s".equals(edcMatcher.group("secure"))) {
                protocol="https";
            }
            String bpn=edcMatcher.group("bpn");
            String targetConnector=protocol+"://"+edcMatcher.group("provider")+"/"+bpn;
            params.put("provider-connector-url",targetConnector);
        }
        SubmodelInterfaceApi api=builder.target(SubmodelInterfaceApi.class,endpoint);
        return new AbstractMap.SimpleImmutableEntry<SubmodelInterfaceApi,Map<String,Object>>(api,params);
    }

    /**
     * dynamically generate a delegate
     * @param idsOffer is ignored
     * @param assetIdentifier
     * @param submodelIdentifier
     * @return final submodel result
     */
    @Override
    public ResponseEntity<Submodel> getSubmodelById(String idsOffer, String assetIdentifier, String submodelIdentifier, Map<String,String> otherParams) {
        try {
            var api = getSubmodelInterfaceApi(assetIdentifier, submodelIdentifier);
            otherParams.entrySet().stream().forEach(x-> api.getValue().put(x.getKey(),x.getValue()));
            return ResponseEntity.ok(api.getKey().getSubmodel(api.getValue()));
        } catch(StatusException se) {
            return ResponseEntity.status(se.getStatus()).build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }


    /**
     * dynamically generate a delegate
     * @oaram idsOffer is ignored
     * @param assetIdentifier identifier of the twin
     * @param submodelIdentifier identifier of the aspect
     * @return final submodel result
     */
    @Override
    public ResponseEntity<Submodel> getSubmodel(String idsOffer,String assetIdentifier, String submodelIdentifier, String level, String content, String extent, Map<String,String> otherParams) {
        try {
            var api = getSubmodelInterfaceApi(assetIdentifier, submodelIdentifier);
            otherParams.entrySet().stream().forEach(x -> api.getValue().put(x.getKey(), x.getValue()));
            api.getValue().put("level", level);
            api.getValue().put("content", content);
            api.getValue().put("extent", extent);
            return ResponseEntity.ok(api.getKey().getSubmodel(api.getValue()));
        } catch(StatusException se) {
            return ResponseEntity.status(se.getStatus()).build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * dynamically generate a delegate
     * @param idsOffer is ignored
     * @param assetIdentifier identifier of the twin
     * @param submodelIdentifier identifier of the aspect
     * @param idShortPath name of the operation
     * @param handleId handle of the call
     * @param content how the result should be presented
     * @return operation result
     */
    @Override
    public ResponseEntity<OperationResult> getOperationAsyncResult(String idsOffer,String assetIdentifier, String submodelIdentifier, String idShortPath, String handleId, String content, Map<String,String> otherParams) {
        try {
            var api = getSubmodelInterfaceApi(assetIdentifier, submodelIdentifier);
            otherParams.entrySet().stream().forEach(x-> api.getValue().put(x.getKey(),x.getValue()));
            api.getValue().put("content",content);
            return ResponseEntity.ok(api.getKey().getOperationAsyncResult(idShortPath,handleId,api.getValue()));
        } catch(StatusException se) {
            return ResponseEntity.status(se.getStatus()).build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * dynamically generate a delegate
     * @param idsOffer is ignored
     * @param assetIdentifier identifier of the twin
     * @param submodelIdentifier identifier of the aspect
     * @param idShortPath name of the operation
     * @param body request body for the operation
     * @param async whether it should be executed asynchronously
     * @param content how the result should be presented
     * @return operation result
     */
    @Override
    public ResponseEntity<OperationResult> invokeOperation(String idsOffer, String assetIdentifier, String submodelIdentifier, String idShortPath, OperationRequest body, Boolean async, String content, Map<String,String> otherParams) {
        try {
            var api = getSubmodelInterfaceApi(assetIdentifier, submodelIdentifier);
            otherParams.entrySet().stream().forEach(x-> api.getValue().put(x.getKey(),x.getValue()));
            api.getValue().put("content",content);
            api.getValue().put("async",async);
            return ResponseEntity.ok(api.getKey().invokeOperation(body,idShortPath, api.getValue()));
        } catch(StatusException se) {
            return ResponseEntity.status(se.getStatus()).build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }
}
