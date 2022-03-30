package org.eclipse.dataspaceconnector.apiwrapper.store;

import java.util.HashMap;
import java.util.Map;

public class InMemoryContractAgreementStore {
    private final Map<String, String> store = new HashMap<>();

    public void put(String assetId, String contractAgreementId) {
        store.put(assetId, contractAgreementId);
    }

    public String get(String assetId) {
        return store.get(assetId);
    }
}
