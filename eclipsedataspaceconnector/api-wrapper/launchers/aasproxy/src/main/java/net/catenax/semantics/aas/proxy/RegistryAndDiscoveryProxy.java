/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.aas.proxy;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.RequiredArgsConstructor;
import net.catenax.semantics.aas.api.registry.LookupApiDelegate;
import net.catenax.semantics.aas.api.registry.RegistryApiDelegate;
import net.catenax.semantics.aas.api.shell.SubmodelInterfaceApi;
import net.catenax.semantics.framework.StatusException;
import net.catenax.semantics.framework.aas.api.RegistryAndDiscoveryInterfaceApi;
import net.catenax.semantics.framework.aas.model.*;
import net.catenax.semantics.framework.idconversion.QualifiedConversionInput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The AAS Proxy implements the service layer behind the web protocol layer.
 */
@Service
@RequiredArgsConstructor
public class RegistryAndDiscoveryProxy implements LookupApiDelegate, RegistryApiDelegate {

    /**
     * the central registry that we delegate to or that redirects us
     */
    protected final RegistryAndDiscoveryInterfaceApi delegate;
    /**
     * we got a rewrite storage for endpoints
     */
    protected final RewriteStorage storage;

    /**
     * config data
     */
    protected final ConfigurationData config;

    /**
     * link to the submodel proxy for id conversion
     */
    protected final SubmodelProxy proxy;


    /**
     * regex to conversion spec
     */
    private Map<Pattern,ConversionSubmodel> idConversions=new HashMap<>();

    /**
     * is created after construction
     */
    @PostConstruct
    public void init() {
        config.idConversions.entrySet().forEach( idSpec -> {
          Pattern matchPattern=Pattern.compile(idSpec.getKey());
          idConversions.put(matchPattern,idSpec.getValue());
        });
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return LookupApiDelegate.super.getObjectMapper();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return LookupApiDelegate.super.getRequest();
    }

    @Override
    public Optional<String> getAcceptHeader() {
        return LookupApiDelegate.super.getAcceptHeader();
    }

    @Override
    public ResponseEntity<Void> deleteAssetAdministrationShellDescriptorById(String aasIdentifier) {
        try {
            delegate.deleteAssetAdministrationShellDescriptorById(aasIdentifier);
            return ResponseEntity.ok().build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteSubmodelDescriptorById(String aasIdentifier, String submodelIdentifier) {
        try {
            delegate.deleteSubmodelDescriptorById(aasIdentifier, submodelIdentifier);
            return ResponseEntity.ok().build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * rewrites a set of shell descriptors
     * @param collection
     * @return
     */
    protected AssetAdministrationShellDescriptorCollection rewrite(AssetAdministrationShellDescriptorCollection collection) {
        collection.setItems(collection.getItems().stream().map( descriptor -> rewrite(descriptor)).collect(Collectors.toList()));
        return collection;
    }

    /**
     * rewrites a shell descriptor
     * @param descriptor
     * @return
     */
    protected AssetAdministrationShellDescriptor rewrite(AssetAdministrationShellDescriptor descriptor) {
        descriptor.setSubmodelDescriptors(descriptor.getSubmodelDescriptors().stream().map(submodel->rewrite(descriptor.getIdentification(),submodel)).collect(Collectors.toList()));
        return descriptor;
    }

    /**
     * rewrites a submodel descriptor
     * @param assetId
     * @param descriptor
     * @return
     */
    protected SubmodelDescriptor rewrite(String assetId,SubmodelDescriptor descriptor) {
        descriptor.setEndpoints(descriptor.getEndpoints().stream().map(endpoint -> rewrite(assetId,descriptor.getIdentification(),endpoint)).collect(Collectors.toList()));
        return descriptor;
    }

    /**
     * rewrites an endpoint
     * @param assetId
     * @param submodelId
     * @param endpoint
     * @return
     */
    protected Endpoint rewrite(String assetId, String submodelId, Endpoint endpoint) {
        ProtocolInformation pi=endpoint.getProtocolInformation();
        String endpointAddress=pi.getEndpointAddress();
        String query="";
        int params=endpointAddress.indexOf(submodelId);
        if(params>=0) {
            query=endpointAddress.substring(params+submodelId.length());
            endpointAddress=endpointAddress.substring(0,params+submodelId.length());
        }
        storage.setEndpoint(assetId,submodelId,endpointAddress);
        assetId=RewriteStorage.encodeIfUndecoded(assetId);
        submodelId=RewriteStorage.encodeIfUndecoded(submodelId);
        pi.setEndpointAddress(config.getProxyUrl()+"/shells/"+assetId+"/aas/"+submodelId+query);
        if(config.getProxyUrl().startsWith("https")) {
            pi.setEndpointProtocol("HTTP/S");
        } else {
            pi.setEndpointProtocol("HTTP");
        }
        pi.setEndpointProtocolVersion("1.1");
        return endpoint;
    }

    /**
     * invoke delegate and rewrite the endpoints
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public ResponseEntity<AssetAdministrationShellDescriptorCollection> getAllAssetAdministrationShellDescriptors(Integer page, Integer pageSize) {
        try {
            return ResponseEntity.ok(rewrite(delegate.getAllAssetAdministrationShellDescriptors(page, pageSize)));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * invoke delegate and rewrite the endpoints
     * @param aasIdentifier
     * @return
     */
    @Override
    public ResponseEntity<List<SubmodelDescriptor>> getAllSubmodelDescriptors(String aasIdentifier) {
        try {
            return ResponseEntity.ok(delegate.getAllSubmodelDescriptors(aasIdentifier).stream().map(subModel->rewrite(aasIdentifier,subModel)).collect(Collectors.toList()));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * invoke and rewrite the endpoints
     * @param aasIdentifier
     * @return
     */
    @Override
    public ResponseEntity<AssetAdministrationShellDescriptor> getAssetAdministrationShellDescriptorById(String aasIdentifier) {
        try {
            return ResponseEntity.ok(rewrite(delegate.getAssetAdministrationShellDescriptorById(aasIdentifier)));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * invoke and rewrite the endpoints
     * @param aasIdentifier
     * @param submodelIdentifier
     * @return
     */
    @Override
    public ResponseEntity<SubmodelDescriptor> getSubmodelDescriptorById(String aasIdentifier, String submodelIdentifier) {
        try {
            return ResponseEntity.ok(rewrite(aasIdentifier,delegate.getSubmodelDescriptorById(aasIdentifier, submodelIdentifier)));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * invoke and rewrite
     * @param assetAdministrationShellDescriptor
     * @return
     */
    @Override
    public ResponseEntity<AssetAdministrationShellDescriptor> postAssetAdministrationShellDescriptor(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) {
        try {
            return ResponseEntity.ok(rewrite(delegate.postAssetAdministrationShellDescriptor(assetAdministrationShellDescriptor)));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    /**
     * invoke and rewrite
     * @param aasIdentifier
     * @param submodelDescriptor
     * @return
     */
    @Override
    public ResponseEntity<SubmodelDescriptor> postSubmodelDescriptor(String aasIdentifier, SubmodelDescriptor submodelDescriptor) {
        try {
            return ResponseEntity.ok(rewrite(aasIdentifier,delegate.postSubmodelDescriptor(submodelDescriptor,aasIdentifier)));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    @Override
    public ResponseEntity<Void> putAssetAdministrationShellDescriptorById(String aasIdentifier, AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) {
        try {
            delegate.putAssetAdministrationShellDescriptorById(assetAdministrationShellDescriptor, aasIdentifier);
            return ResponseEntity.ok().build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    @Override
    public ResponseEntity<Void> putSubmodelDescriptorById(String aasIdentifier, String submodelIdentifier, SubmodelDescriptor submodelDescriptor) {
        try {
            delegate.putSubmodelDescriptorById(submodelDescriptor,aasIdentifier, submodelIdentifier);
            return ResponseEntity.ok().build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteAllAssetLinksById(String aasIdentifier) {
        try {
            delegate.deleteAllAssetLinksById(aasIdentifier);
            return ResponseEntity.ok().build();
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    List<IdentifierKeyValuePair> orgaTwinAddress=List.of(new IdentifierKeyValuePair().key("urn:twin:com.catenax#").value("")) ;
    String conversionAspect="idconversion-aspect";

    protected List<IdentifierKeyValuePair> convertIds(List<IdentifierKeyValuePair> assetIds) {
        if(assetIds==null) return null;
        return assetIds.stream().flatMap(assetId -> {
            String fullName=assetId.getKey()+assetId.getValue();
            Optional<Map.Entry<Pattern,ConversionSubmodel>> foundConversion=idConversions.entrySet().stream().filter( idConversion -> {
                return idConversion.getKey().matcher(fullName).matches();
            }).findFirst();
            if(foundConversion.isPresent()) {
                ConversionSubmodel submodelSpec=foundConversion.get().getValue();
                Optional<String> orgaTwin=delegate.getAllAssetAdministrationShellIdsByAssetLink(submodelSpec.getOrgaIdentifiers()).stream().findFirst();
                Optional<SubmodelDescriptor> submodel=orgaTwin.map( orgaAssetId -> delegate.getSubmodelDescriptorById(orgaAssetId, submodelSpec.getConversionSubmodel()));
                List<Endpoint> endpoints=submodel.map(conversion -> conversion.getEndpoints()).orElse(List.of());
                Optional<String> address = endpoints.stream().flatMap( myEndpoint -> {
                    String fullAddress=myEndpoint.getProtocolInformation().getEndpointAddress();
                    int params=fullAddress.indexOf(submodelSpec.getConversionSubmodel());
                    if(params>=0) {
                        fullAddress=fullAddress.substring(0,params+submodelSpec.getConversionSubmodel().length());
                        return List.of(fullAddress).stream();
                    } else {
                        return List.<String>of().stream();
                    }
                }).findFirst();
                return address.flatMap( myAddress -> {
                    try {
                        Map.Entry<SubmodelInterfaceApi,Map<String,Object>> api = proxy.getSubmodelInterfaceApi(myAddress);
                        api.getValue().put("content","value");
                        api.getValue().put("async","false");
                        OperationRequest request=new OperationRequest();
                        request.setData("targetDomain",submodelSpec.getTargetDomain());
                        request.setData("identifiers",List.of(assetId));
                        OperationResult response=api.getKey().invokeOperation(request,submodelSpec.getConversionSubmodelEntry(), api.getValue());
                        List<Map<String,String>> ids=(List<Map<String,String>>) response.data().get("identifiers");
                        return ids.stream().map( id -> new IdentifierKeyValuePair().key(id.get("key")).value(id.get("value"))).findFirst();
                    } catch(StatusException e) {
                        return Optional.<IdentifierKeyValuePair>empty();
                    }
                }).stream();
            } else {
                return Optional.of(assetId).stream();
            }
        }).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<List<String>> getAllAssetAdministrationShellIdsByAssetLink(List<IdentifierKeyValuePair> assetIds) {
        try {
            return ResponseEntity.ok(delegate.getAllAssetAdministrationShellIdsByAssetLink(convertIds(assetIds)));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    @Override
    public ResponseEntity<List<IdentifierKeyValuePair>> getAllAssetLinksById(String aasIdentifier) {
        try {
            return ResponseEntity.ok(delegate.getAllAssetLinksById(aasIdentifier));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }

    @Override
    public ResponseEntity<List<IdentifierKeyValuePair>> postAllAssetLinksById(String aasIdentifier, List<IdentifierKeyValuePair> identifierKeyValuePair) {
        try {
            return ResponseEntity.ok(delegate.postAllAssetLinksById(convertIds(identifierKeyValuePair),aasIdentifier));
        } catch(feign.FeignException e) {
            var response=ResponseEntity.status(e.status());
            if(e.responseBody().isPresent()) {
                response.body(e.responseBody().get().toString());
            }
            return response.build();
        }
    }
}
