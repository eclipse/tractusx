//
// Copyright (c) 2021 Copyright Holder (Catena-X Consortium)
//
// See the AUTHORS file(s) distributed with this work for additional
// information regarding authorship.
//
// See the LICENSE file(s) distributed with this work for
// additional information regarding license terms.
//
package net.catenax.prs.controllers;

import com.catenax.partsrelationshipservice.dtos.ErrorResponse;
import com.catenax.partsrelationshipservice.dtos.PartRelationshipsWithInfos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catenax.prs.PrsApplication;
import net.catenax.prs.annotations.ExcludeFromCodeCoverageGeneratedReport;
import net.catenax.prs.requests.PartsTreeRequest;
import net.catenax.prs.requests.VinPartsTreeRequest;
import net.catenax.prs.services.PartsTreeQueryService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Application REST controller.
 */
@Tag(name = "Parts Relationship Service API")
@Slf4j
@RestController
@RequestMapping(PrsApplication.API_PREFIX)
@RequiredArgsConstructor
@ExcludeFromCodeCoverageGeneratedReport
public class PrsController {
    /**
     * Service for retrieving parts tree.
     */
    private final PartsTreeQueryService queryService;

    /**
     * Get a PartsTree for a VIN
     *
     * @param request Request.
     * @return PartsTree with parts info.
     */
    @Operation(operationId = "getPartsTreeByVin", summary = "Get a PartsTree for a VIN")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the PartsTree",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = PartRelationshipsWithInfos.class))}),
        @ApiResponse(responseCode = "404", description = "PartsTree not found",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping("/vins/{vin}/partsTree")
    public PartRelationshipsWithInfos getPartsTree(@Valid @ParameterObject VinPartsTreeRequest request) {
        return queryService.getPartsTree(request);
    }

    /**
     * Get a PartsTree for a part identified by a [oneId,objectId] tuple
     *
     * @param request Request.
     * @return PartsTree with parts info.
     */
    @Operation(operationId = "getPartsTreeByOneIdAndObjectId", summary = "Get a PartsTree for a part")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the PartsTree",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = PartRelationshipsWithInfos.class))}),
        @ApiResponse(responseCode = "404", description = "PartsTree not found",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    @GetMapping("/parts/{oneIDManufacturer}/{objectIDManufacturer}/partsTree")
    public PartRelationshipsWithInfos getPartsTree(@Valid @ParameterObject PartsTreeRequest request) {
        return queryService.getPartsTree(request);
    }
}
