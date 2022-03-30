/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.registry;

import net.catenax.semantics.framework.aas.model.IdentifierKeyValuePair;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-07T08:24:07.248914900+01:00[Europe/Berlin]")
@Validated
public interface LookupApi {

    LookupApiDelegate getDelegate();

    @Operation(summary = "Deletes all Asset identifier key-value-pair linked to an Asset Administration Shell to edit discoverable content", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Asset identifier key-value-pairs deleted successfully") })
    @RequestMapping(value = "/lookup/shells/{aasIdentifier}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteAllAssetLinksById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
        return getDelegate().deleteAllAssetLinksById(aasIdentifier);
    }


    @Operation(summary = "Returns a list of Asset Administration Shell ids based on Asset identifier key-value-pairs", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Asset Administration Shell ids", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))) })
    @RequestMapping(value = "/lookup/shells",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<String>> getAllAssetAdministrationShellIdsByAssetLink(@Parameter(in = ParameterIn.QUERY, description = "The key-value-pair of an Asset identifier" ,schema=@Schema()) @Valid @RequestParam(value = "assetIds", required = false) List<IdentifierKeyValuePair> assetIds) {
        return getDelegate().getAllAssetAdministrationShellIdsByAssetLink(assetIds);
    }


    @Operation(summary = "Returns a list of Asset identifier key-value-pairs based on an Asset Administration Shell id to edit discoverable content", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Asset identifier key-value-pairs", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = IdentifierKeyValuePair.class)))) })
    @RequestMapping(value = "/lookup/shells/{aasIdentifier}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<IdentifierKeyValuePair>> getAllAssetLinksById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
        return getDelegate().getAllAssetLinksById(aasIdentifier);
    }


    @Operation(summary = "Creates all Asset identifier key-value-pair linked to an Asset Administration Shell to edit discoverable content", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Asset identifier key-value-pairs created successfully", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = IdentifierKeyValuePair.class)))) })
    @RequestMapping(value = "/lookup/shells/{aasIdentifier}",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<List<IdentifierKeyValuePair>> postAllAssetLinksById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier, @Parameter(in = ParameterIn.DEFAULT, description = "Asset identifier key-value-pairs", required=true, schema=@Schema()) @Valid @RequestBody List<IdentifierKeyValuePair> body) {
        return getDelegate().postAllAssetLinksById(aasIdentifier, body);
    }

}

