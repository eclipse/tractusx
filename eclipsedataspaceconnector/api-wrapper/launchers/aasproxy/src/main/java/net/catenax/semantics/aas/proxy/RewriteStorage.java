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
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

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

    // Method to encode a string value using `UTF-8` encoding scheme
    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    // Decodes a URL encoded string using `UTF-8`
    public static String decodeValue(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static boolean isEncoded(String value) {
        return !decodeValue(value).equals(value);
    }

    public static String encodeIfUndecoded(String value) {
        if(!isEncoded(value)) {
            return encodeValue(value);
        }
        return value;
    }

    public synchronized String getEndpoint(String assetId, String submodelId) {
        return urnMap.get(new ModelKey(assetId,submodelId));
    }

    public synchronized void setEndpoint(String assetId, String submodelId, String endpoint) {
        urnMap.put(new ModelKey(assetId,submodelId),endpoint);
    }
}
