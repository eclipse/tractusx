/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/

package net.catenax.semantics.adapter;

import java.util.Map;

import net.catenax.semantics.framework.IdsConnector;
import net.catenax.semantics.framework.StatusException;
import net.catenax.semantics.framework.adapters.DownloadAdapter;
import net.catenax.semantics.framework.adapters.TwinRegistryAdapter;
import net.catenax.semantics.framework.config.Contract;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catenax.semantics.framework.config.Offer;

import io.swagger.annotations.*;

/**
 * REST Controller to implement the Adapters API
 * It uses the adapter layer to implement the actual logic.
 * It uses the IDS connector directly for exposing some debugging endpoints.
 */
@Controller
@RequestMapping("${openapi.semantics.base-path:/adapter}")
@AllArgsConstructor
@Slf4j
@Api(tags="Adapter", value = "adapter", description = "Simple Semantic Adapter API")
public class AdapterController {
    /** the adapters */
    private final DownloadAdapter downloadService;
    private final TwinRegistryAdapter twinService;
    /** the connector itself just for debugging endpoints */
    private final IdsConnector idsConnector;

    /**
     * Simple hello debugging endpoint
     * @return hello response
     */
    @GetMapping(value = "/hello", produces = "text/plain")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    /**
     * Download an offered, possibly aspect-json transformed source
     *
     * @param parameters map of the parameters
     * @return response including the transformed source
     */
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> download(@RequestParam Map<String, String> parameters, @RequestHeader Map<String,String> headers) {
        StreamingResponseBody streamingResponseBody = response -> {
            try {
                downloadService.download("get",response, headers.getOrDefault("Accept","*/*"), parameters);
            } catch (StatusException e) {
                e.printStackTrace(System.err);
            }
        };
        return ResponseEntity.ok(streamingResponseBody);
    }

    /**
     * publish twins on demand/trigger
     * @param protocol  source specification
     * @param command Source
     * @param parameters set of headers
     * @return register response
     */
    @PostMapping(value = "/register/{protocol}/{command}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerTwins(@PathVariable("protocol") String protocol, @PathVariable("command") String command, @RequestParam Map<String, String> parameters) {
        try {
            return ResponseEntity.ok(twinService.registerTwins(protocol,command,parameters));
        } catch(Exception e) {
            e.printStackTrace(System.err);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    /**
     * obtain debugging info of the associated ids connector
     * @return self-description response
     */
    @GetMapping(value = "/idsinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> idsInfo() {
        try {
            return ResponseEntity.ok(idsConnector.getSelfDescription());
        } catch(StatusException e) {
            return ResponseEntity.status(e.getStatus()).build();
        }
    }

    /**
     * publish a preconfigured source for debugging purposes
     * @param name  source specification
     * @return register response
     */
    @PostMapping(value = "/offer/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Offer> offerResource(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(idsConnector.getOrCreateOffer(name));
        } catch(StatusException e) {
            return ResponseEntity.status(e.getStatus()).build();
        }
    }

    /**
     * publish a preconfigured contract for debugging purposes
     * @param name  source specification
     * @return register response
     */
    @PostMapping(value = "/contract/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contract> offerContract(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(idsConnector.getOrCreateContract(name));
        } catch(StatusException e) {
            return ResponseEntity.status(e.getStatus()).build();
        }
    }

}
