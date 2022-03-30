package org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.model.NegotiationStatusResponse;
import org.eclipse.dataspaceconnector.apiwrapper.connector.sdk.Utility;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.types.TypeManager;
import org.eclipse.dataspaceconnector.spi.types.domain.contract.negotiation.ContractOfferRequest;

import java.util.Map;

import static java.lang.String.format;

public class ContractNegotiationService {
    private final Monitor monitor;
    private final TypeManager typeManager;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    private static final String NEGOTIATION_PATH = "/control/negotiation";
    private static final String NEGOTIATION_STATE_PATH_PATTERN = NEGOTIATION_PATH + "/%s/state";

    public ContractNegotiationService(Monitor monitor, TypeManager typeManager, OkHttpClient httpClient) {
        this.monitor = monitor;
        this.typeManager = typeManager;
        this.objectMapper = typeManager.getMapper();
        this.httpClient = httpClient;
    }

    public String initiateNegotiation(ContractOfferRequest contractOfferRequest, String connectorControlPlaneBaseUrl, Map<String, String> headers) {
        var url = connectorControlPlaneBaseUrl + NEGOTIATION_PATH;
        var requestBody = RequestBody.create(
                typeManager.writeValueAsString(contractOfferRequest),
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

            var uuid = body.string();
            monitor.info("Started negotiation with ID: " + uuid);

            return uuid;
        } catch (Exception e) {
            monitor.severe(format("Error in calling the Control plane at %s", url), e);
        }

        return null;
    }

    public NegotiationStatusResponse getNegotiationState(String negotiationId, String connectorControlPlaneBaseUrl, Map<String, String> headers) {
        var negotiationStateUrlPattern = connectorControlPlaneBaseUrl + NEGOTIATION_STATE_PATH_PATTERN;
        var url = format(negotiationStateUrlPattern, negotiationId);
        var request = new Request.Builder()
                .url(url);
        headers.forEach(request::addHeader);

        try (var response = httpClient.newCall(request.build()).execute()) {
            var body = response.body();

            if (!response.isSuccessful() || body == null) {
                monitor.warning(format("Control plane responded with error: %s %s", response.code(), body != null ? body.string() : ""));
                return null;
            }

            var negotiationStatus = objectMapper.readValue(body.string(), NegotiationStatusResponse.class);
            monitor.info(format("Negotiation %s is in state '%s' (agreementId: %s)", negotiationId, negotiationStatus.getStatus(), negotiationStatus.getContractAgreementId()));

            return negotiationStatus;
        } catch (Exception e) {
            monitor.severe(format("Error in calling the Control plane at %s", url), e);
        }

        return null;
    }
}
