/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.proxy;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * A little memory storage to
 * help mapping ids to remote endpoints
 */
@Component
public class RewriteStorage {

    @RequiredArgsConstructor
    static class ModelKey {
        final private String assetId;
        final private String submodelId;

        @Override
        public int hashCode() {
            return assetId.hashCode()*submodelId.hashCode();
        }

        @Override
        public boolean equals(Object other) {
            if(other instanceof ModelKey) {
                ModelKey otherKey=(ModelKey) other;
                return assetId.equals(otherKey.assetId) && submodelId.equals(otherKey.submodelId);
            }
            return false;
        }
    }

    Map<ModelKey,String> urnMap=new HashMap<>();

    public synchronized String getEndpoint(String assetId, String submodelId) {
        assetId=assetId.replace("#","%23");
        submodelId=submodelId.replace("#","%23");
        return urnMap.get(new ModelKey(assetId,submodelId));
    }

    public synchronized void setEndpoint(String assetId, String submodelId, String endpoint) {
        assetId=assetId.replace("#","%23");
        submodelId=submodelId.replace("#","%23");
        endpoint=endpoint.replace("#","%23");
        urnMap.put(new ModelKey(assetId,submodelId),endpoint);
    }
}
