/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.registry;

import net.catenax.semantics.framework.aas.model.AssetAdministrationShellDescriptor;
import net.catenax.semantics.framework.aas.model.AssetAdministrationShellDescriptorCollection;
import net.catenax.semantics.framework.aas.model.SubmodelDescriptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link RegistryApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-07T08:24:07.248914900+01:00[Europe/Berlin]")
public interface RegistryApiDelegate {

    Logger log = LoggerFactory.getLogger(RegistryApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see RegistryApi#deleteAssetAdministrationShellDescriptorById
     */
    default ResponseEntity<Void> deleteAssetAdministrationShellDescriptorById( String  aasIdentifier) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#deleteSubmodelDescriptorById
     */
    default ResponseEntity<Void> deleteSubmodelDescriptorById( String  aasIdentifier,
         String  submodelIdentifier) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#getAllAssetAdministrationShellDescriptors
     */
    default ResponseEntity<AssetAdministrationShellDescriptorCollection> getAllAssetAdministrationShellDescriptors( Integer  page,
         Integer  pageSize) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"totalItems\" : 0,\r\n  \"totalPages\" : 1,\r\n  \"currentPage\" : 6,\r\n  \"items\" : [ {\r\n    \"identification\" : \"identification\",\r\n    \"idShort\" : \"idShort\",\r\n    \"specificAssetIds\" : [ \"\", \"\" ],\r\n    \"administration\" : {\r\n      \"version\" : \"version\",\r\n      \"revision\" : \"revision\"\r\n    },\r\n    \"description\" : [ {\r\n      \"language\" : \"language\",\r\n      \"text\" : \"text\"\r\n    }, {\r\n      \"language\" : \"language\",\r\n      \"text\" : \"text\"\r\n    } ],\r\n    \"submodelDescriptors\" : [ {\r\n      \"idShort\" : \"idShort\",\r\n      \"description\" : [ null, null ]\r\n    }, {\r\n      \"idShort\" : \"idShort\",\r\n      \"description\" : [ null, null ]\r\n    } ],\r\n    \"globalAssetId\" : \"\"\r\n  }, {\r\n    \"identification\" : \"identification\",\r\n    \"idShort\" : \"idShort\",\r\n    \"specificAssetIds\" : [ \"\", \"\" ],\r\n    \"administration\" : {\r\n      \"version\" : \"version\",\r\n      \"revision\" : \"revision\"\r\n    },\r\n    \"description\" : [ {\r\n      \"language\" : \"language\",\r\n      \"text\" : \"text\"\r\n    }, {\r\n      \"language\" : \"language\",\r\n      \"text\" : \"text\"\r\n    } ],\r\n    \"submodelDescriptors\" : [ {\r\n      \"idShort\" : \"idShort\",\r\n      \"description\" : [ null, null ]\r\n    }, {\r\n      \"idShort\" : \"idShort\",\r\n      \"description\" : [ null, null ]\r\n    } ],\r\n    \"globalAssetId\" : \"\"\r\n  } ],\r\n  \"itemCount\" : 5\r\n}", AssetAdministrationShellDescriptorCollection.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#getAllSubmodelDescriptors
     */
    default ResponseEntity<List<SubmodelDescriptor>> getAllSubmodelDescriptors( String  aasIdentifier) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\r\n  \"idShort\" : \"idShort\",\r\n  \"description\" : [ null, null ]\r\n}, {\r\n  \"idShort\" : \"idShort\",\r\n  \"description\" : [ null, null ]\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#getAssetAdministrationShellDescriptorById
     */
    default ResponseEntity<AssetAdministrationShellDescriptor> getAssetAdministrationShellDescriptorById( String  aasIdentifier) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"identification\" : \"identification\",\r\n  \"idShort\" : \"idShort\",\r\n  \"specificAssetIds\" : [ \"\", \"\" ],\r\n  \"administration\" : {\r\n    \"version\" : \"version\",\r\n    \"revision\" : \"revision\"\r\n  },\r\n  \"description\" : [ {\r\n    \"language\" : \"language\",\r\n    \"text\" : \"text\"\r\n  }, {\r\n    \"language\" : \"language\",\r\n    \"text\" : \"text\"\r\n  } ],\r\n  \"submodelDescriptors\" : [ {\r\n    \"idShort\" : \"idShort\",\r\n    \"description\" : [ null, null ]\r\n  }, {\r\n    \"idShort\" : \"idShort\",\r\n    \"description\" : [ null, null ]\r\n  } ],\r\n  \"globalAssetId\" : \"\"\r\n}", AssetAdministrationShellDescriptor.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#getSubmodelDescriptorById
     */
    default ResponseEntity<SubmodelDescriptor> getSubmodelDescriptorById( String  aasIdentifier,
         String  submodelIdentifier) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"idShort\" : \"idShort\",\r\n  \"description\" : [ null, null ]\r\n}", SubmodelDescriptor.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#postAssetAdministrationShellDescriptor
     */
    default ResponseEntity<AssetAdministrationShellDescriptor> postAssetAdministrationShellDescriptor( AssetAdministrationShellDescriptor  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"identification\" : \"identification\",\r\n  \"idShort\" : \"idShort\",\r\n  \"specificAssetIds\" : [ \"\", \"\" ],\r\n  \"administration\" : {\r\n    \"version\" : \"version\",\r\n    \"revision\" : \"revision\"\r\n  },\r\n  \"description\" : [ {\r\n    \"language\" : \"language\",\r\n    \"text\" : \"text\"\r\n  }, {\r\n    \"language\" : \"language\",\r\n    \"text\" : \"text\"\r\n  } ],\r\n  \"submodelDescriptors\" : [ {\r\n    \"idShort\" : \"idShort\",\r\n    \"description\" : [ null, null ]\r\n  }, {\r\n    \"idShort\" : \"idShort\",\r\n    \"description\" : [ null, null ]\r\n  } ],\r\n  \"globalAssetId\" : \"\"\r\n}", AssetAdministrationShellDescriptor.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#postSubmodelDescriptor
     */
    default ResponseEntity<SubmodelDescriptor> postSubmodelDescriptor( String  aasIdentifier,
         SubmodelDescriptor  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"idShort\" : \"idShort\",\r\n  \"description\" : [ null, null ]\r\n}", SubmodelDescriptor.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#putAssetAdministrationShellDescriptorById
     */
    default ResponseEntity<Void> putAssetAdministrationShellDescriptorById( String  aasIdentifier,
         AssetAdministrationShellDescriptor  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see RegistryApi#putSubmodelDescriptorById
     */
    default ResponseEntity<Void> putSubmodelDescriptorById( String  aasIdentifier,
         String  submodelIdentifier,
         SubmodelDescriptor  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default RegistryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
