package org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.types.TypeManager;
import org.eclipse.dataspaceconnector.spi.types.domain.catalog.Catalog;
import org.eclipse.dataspaceconnector.spi.types.domain.contract.offer.ContractOffer;

import java.util.Map;

import static java.lang.String.format;

public class ContractOfferService {
    private final Monitor monitor;
    private final ObjectMapper objectMapper;
    private final OkHttpClient httpClient;

    private static final String CATALOG_PATH = "/control/catalog?provider=";

    public ContractOfferService(Monitor monitor, TypeManager typeManager, OkHttpClient httpClient) {
        this.monitor = monitor;
        this.objectMapper = typeManager.getMapper();
        this.httpClient = httpClient;
    }

    public ContractOffer findContractOffer4AssetId(String assetId, String consumerConnectorControlPlaneBaseUrl, String providerConnectorControlPlaneIDSUrl, Map<String, String> header) {
        var catalog = getCatalogFromProvider(consumerConnectorControlPlaneBaseUrl, providerConnectorControlPlaneIDSUrl, header);
        var contract = catalog != null ? catalog.getContractOffers()
                .stream()
                .filter(it -> it.getAsset().getId().equals(assetId))
                .findFirst() : java.util.Optional.<ContractOffer>empty();

        if (contract.isEmpty()) {
            monitor.severe("Could not find asset.");
            return null;
        }

        return contract.get();
    }

    private Catalog getCatalogFromProvider(String consumerControlPlane, String providerConnectorControlPlaneIDSUrl, Map<String, String> headers) {
        var url = consumerControlPlane + CATALOG_PATH + providerConnectorControlPlaneIDSUrl;
        var request = new Request.Builder()
                .url(url);
        headers.forEach(request::addHeader);

        try (var response = httpClient.newCall(request.build()).execute()) {
            var body = response.body();

            if (!response.isSuccessful() || body == null) {
                monitor.warning(format("Control plane responded with error: %s %s", response.code(), body != null ? body.string() : ""));
                return null;
            }

            return objectMapper.readValue(body.string(), Catalog.class);
        } catch (Exception e) {
            monitor.severe(format("Error in calling the Control plane at %s", url), e);
        }

        return null;
    }
}
