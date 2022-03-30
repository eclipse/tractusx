package org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.Utility;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.types.TypeManager;
import org.eclipse.dataspaceconnector.spi.types.domain.DataAddress;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataRequest;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.TransferType;

import java.util.Map;
import java.util.UUID;

import static java.lang.String.format;

public class TransferProcessService {
    private final Monitor monitor;
    private final TypeManager typeManager;
    private final OkHttpClient httpClient;

    private static final String TRANSFER_PATH = "/control/transfer";

    public TransferProcessService(Monitor monitor, TypeManager typeManager, OkHttpClient httpClient) {
        this.monitor = monitor;
        this.typeManager = typeManager;
        this.httpClient = httpClient;
    }

    public String initiateHttpProxyTransferProcess(String agreementId, String assetId, String consumerControlPlane, String providerConnectorControlPlaneIDSUrl, Map<String, String> headers) {
        var url = consumerControlPlane + TRANSFER_PATH;

        DataAddress dataDestination = DataAddress.Builder.newInstance()
                .type("HttpProxy")
                .build();

        TransferType transferType = TransferType.Builder.transferType()
                .contentType("application/octet-stream")
                .isFinite(true)
                .build();

        DataRequest dataRequest = DataRequest.Builder.newInstance()
                .id(UUID.randomUUID().toString())
                .contractId(agreementId)
                .connectorId("provider")
                .connectorAddress(providerConnectorControlPlaneIDSUrl)
                .protocol("ids-multipart")
                .assetId(assetId)
                .dataDestination(dataDestination)
                .managedResources(false)
                .transferType(transferType)
                .build();

        var requestBody = RequestBody.create(
                typeManager.writeValueAsString(dataRequest),
                Utility.JSON
        );

        var request = new Request.Builder()
                .url(url)
                .post(requestBody);
        headers.forEach(request::addHeader);

        try (var response = httpClient.newCall(request.build()).execute()) {
            var body = response.body();

            if (!response.isSuccessful() || body == null) {
                monitor.warning(format("Control plane responded with error: %s %s", response.code(), body != null ? body.string() : ""));
                return null;
            }

            var transferResponseId = body.string();
            monitor.info(format("Transfer process (%s) initiated", transferResponseId));

            return transferResponseId;
        } catch (Exception e) {
            monitor.severe(format("Error in calling the Control plane at %s", url), e);
        }

        return null;
    }
}
