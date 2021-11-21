//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.connector.consumer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.catenax.prs.connector.requests.FileRequest;
import org.eclipse.dataspaceconnector.schema.azure.AzureBlobStoreSchema;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.transfer.TransferInitiateResponse;
import org.eclipse.dataspaceconnector.spi.transfer.TransferProcessManager;
import org.eclipse.dataspaceconnector.spi.transfer.response.ResponseStatus;
import org.eclipse.dataspaceconnector.spi.transfer.store.TransferProcessStore;
import org.eclipse.dataspaceconnector.spi.types.domain.metadata.DataEntry;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataAddress;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.DataRequest;
import org.eclipse.dataspaceconnector.spi.types.domain.transfer.TransferProcessStates;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Consumer Service.
 * Provides job management.
 */
@RequiredArgsConstructor
@SuppressWarnings("PMD.GuardLogStatement") // Monitor doesn't offer guard statements
public class ConsumerService {

    /**
     * Logger.
     */
    private final Monitor monitor;
    /**
     * Sends messages to provider.
     */
    private final TransferProcessManager processManager;
    /**
     * Manages storage of TransferProcess state.
     */
    private final TransferProcessStore processStore;
    /**
     * Storage account name
     */
    private final String storageAccountName;
    /**
     * JSON object mapper.
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Endpoint to trigger a request, so that a file get copied into a specific destination.
     *
     * @param request Request parameters.
     * @return TransferInitiateResponse with process id.
     */
    public Optional<TransferInitiateResponse> initiateTransfer(final FileRequest request) {
        monitor.info(format("Received request against provider %s", request.getConnectorAddress()));

        final String serializedRequest;
        try {
            serializedRequest = MAPPER.writeValueAsString(request.getPartsTreeRequest());
        } catch (JsonProcessingException e) {
            // should not happen
            monitor.severe("Error serializing request", e);
            return Optional.empty();
        }

        final var dataRequest = DataRequest.Builder.newInstance()
                .id(UUID.randomUUID().toString()) //this is not relevant, thus can be random
                .connectorAddress(request.getConnectorAddress()) //the address of the provider connector
                .protocol("ids-rest") //must be ids-rest
                .connectorId("consumer")
                .dataEntry(DataEntry.Builder.newInstance() //the data entry is the source asset
                        .id("prs-request")
                        .policyId("use-eu")
                        .build())
                .dataDestination(DataAddress.Builder.newInstance()
                        .type(AzureBlobStoreSchema.TYPE) //the provider uses this to select the correct DataFlowController
                        .property("account", storageAccountName)
                        .build())
                .properties(Map.of(
                        "prs-request-parameters", serializedRequest,
                        "prs-destination-path", request.getDestinationPath()
                ))
                .managedResources(true)
                .build();

        final var response = processManager.initiateConsumerRequest(dataRequest);
        return response.getStatus() == ResponseStatus.OK ? Optional.of(response) : Optional.empty();
    }

    /**
     * Provides status of a process
     *
     * @param requestId If of the process
     * @return Process state
     */
    public Optional<TransferProcessStates> getStatus(final String requestId) {
        monitor.info("Getting status of data request " + requestId);

        return Optional
                .ofNullable(processStore.find(requestId))
                .map(p -> TransferProcessStates.from(p.getState()));
    }
}
