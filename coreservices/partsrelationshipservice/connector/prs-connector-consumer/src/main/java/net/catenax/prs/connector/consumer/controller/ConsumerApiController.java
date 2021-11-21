//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.connector.consumer.controller;


import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import net.catenax.prs.connector.consumer.middleware.RequestMiddleware;
import net.catenax.prs.connector.consumer.service.ConsumerService;
import net.catenax.prs.connector.parameters.GetStatusParameters;
import net.catenax.prs.connector.requests.FileRequest;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;
import org.eclipse.dataspaceconnector.spi.transfer.TransferInitiateResponse;

import java.util.Optional;

/**
 * Consumer API Controller.
 * Provides consumer extra endpoints.
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path(ConsumerApiController.API_VERSION)
@RequiredArgsConstructor
public class ConsumerApiController {

    /**
     * The API version, part of the URL.
     */
    public static final String API_VERSION = "v0.1";

    /**
     * Logger.
     */
    private final Monitor monitor;

    /**
     * Service implementation.
     */
    private final ConsumerService service;

    /**
     * Middleware to process request exceptions.
     */
    private final RequestMiddleware middleware;

    /**
     * Health endpoint.
     *
     * @return Consumer status
     */
    @GET
    @Path("health")
    public String checkHealth() {
        monitor.info("Received a health request");
        return "I'm alive!";
    }

    /**
     * Endpoint to trigger a request, so that parts tree get written into a file.
     * Consumer will forward the PartsTreeByObjectIdRequest to a provider.
     *
     * @param request FileRequest.
     *                Contains a PartsTreeByObjectIdRequest corresponding to prs-request and other
     *                information such that the destination file where the result of the PRS
     *                request should be written.
     * @return TransferInitiateResponse with process id.
     */
    @POST
    @Path("file")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response initiateTransfer(final FileRequest request) {
        return middleware.chain()
                .validate(request)
                .invoke(() -> {
                    final Optional<TransferInitiateResponse> transferInfo;
                    transferInfo = service.initiateTransfer(request);
                    return transferInfo.isPresent()
                            ? Response.ok(transferInfo.get().getId()).build()
                            : Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                });
    }

    /**
     * Provides status of a process
     *
     * @param parameters request parameters
     * @return Process state
     */
    @GET
    @Path("datarequest/{id}/state")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatus(final @BeanParam GetStatusParameters parameters) {
        return middleware.chain()
                .validate(parameters)
                .invoke(() -> {
                    final var status = service.getStatus(parameters.getRequestId());
                    return status.isPresent()
                            ? Response.ok(status.get().name()).build()
                            : Response.status(Response.Status.NOT_FOUND).build();
                });
    }
}
