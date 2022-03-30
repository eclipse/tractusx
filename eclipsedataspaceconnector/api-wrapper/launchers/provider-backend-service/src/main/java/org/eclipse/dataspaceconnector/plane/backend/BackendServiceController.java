package org.eclipse.dataspaceconnector.plane.backend;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Collections;
import org.eclipse.dataspaceconnector.spi.monitor.Monitor;

import java.util.Map;
import java.util.Objects;

@Consumes
@Produces({MediaType.APPLICATION_JSON})
@Path("/service")
public class BackendServiceController {

    private final Monitor monitor;

    public BackendServiceController(Monitor monitor) {
        this.monitor = monitor;
    }

    @GET
    @Path("/data/{assetId}/submodel")
    public Map<String, String> getData(@PathParam("assetId") String assetId) {
        if (Objects.equals(assetId, "asset-1")) {
            monitor.debug("Returning data for asset-1!");
            return Map.of("message", "Returning data for asset-1");
        }

        if (Objects.equals(assetId, "asset-2")) {
            monitor.debug("Returning data for asset-2!");
            return Map.of("message", "Data for asset-2");
        }

        monitor.debug("NO DATA!");
        return Collections.emptyMap();
    }

    @POST
    @Path("/data/{assetId}/submodel")
    public String getPostData(@PathParam("assetId") String assetId,String body) {
        monitor.debug("Got POST call with body: " + body);
        return body;
    }
}
