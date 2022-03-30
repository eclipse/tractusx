package org.eclipse.dataspaceconnector.apiwrapper.store;

import org.eclipse.dataspaceconnector.spi.types.domain.edr.EndpointDataReference;

import java.util.HashMap;
import java.util.Map;

public class InMemoryEndpointDataReferenceStore {
    private final Map<String, EndpointDataReference> store = new HashMap<>();

    public void put(String agreementId, EndpointDataReference endpointDataReference) {
        store.put(agreementId, endpointDataReference);
    }

    public EndpointDataReference get(String agreementId) {
        return store.get(agreementId);
    }
}
