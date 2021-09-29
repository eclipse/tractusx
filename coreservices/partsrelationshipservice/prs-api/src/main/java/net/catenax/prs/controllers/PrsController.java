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
import net.catenax.prs.requests.PartsTreeByObjectIdRequest;
import net.catenax.prs.requests.PartsTreeByVinRequest;
import net.catenax.prs.services.PartsTreeQueryByVinService;
import net.catenax.prs.services.PartsTreeQueryService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Application REST controller.
 */
@Tag(name = "Parts Relationship Service API")
@Slf4j
@RestController
@RequestMapping(PrsApplication.API_PREFIX)
@RequiredArgsConstructor
@ExcludeFromCodeCoverageGeneratedReport
@SuppressWarnings({"checkstyle:MissingJavadocMethod", "PMD.CommentRequired"})
public class PrsController {

    private final PartsTreeQueryService queryService;
    private final PartsTreeQueryByVinService queryByVinService;

    @Operation(operationId = "getPartsTreeByVin", summary = "Get a PartsTree for a VIN")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Parts tree for a vehicle",
                content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = PartRelationshipsWithInfos.class))}),
        @ApiResponse(responseCode = "404", description = "A vehicle was not found with the given VIN",
                content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Bad request",
                content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/vins/{vin}/partsTree")
    public PartRelationshipsWithInfos getPartsTree(final @Valid @ParameterObject PartsTreeByVinRequest request) {
        return queryByVinService.getPartsTree(request);
    }

    @Operation(operationId = "getPartsTreeByOneIdAndObjectId", summary = "Get a PartsTree for a part")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Parts tree for a part",
            content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PartRelationshipsWithInfos.class))}),
        @ApiResponse(responseCode = "400", description = "Bad request",
                content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @GetMapping("/parts/{oneIDManufacturer}/{objectIDManufacturer}/partsTree")
    public PartRelationshipsWithInfos getPartsTree(final @Valid @ParameterObject PartsTreeByObjectIdRequest request) {
        return queryService.getPartsTree(request);
    }
}
