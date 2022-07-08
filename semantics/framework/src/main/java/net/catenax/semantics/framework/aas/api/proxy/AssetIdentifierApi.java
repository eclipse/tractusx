/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.aas.api.proxy;

import net.catenax.semantics.framework.aas.model.OperationRequest;
import net.catenax.semantics.framework.aas.model.OperationResult;
import net.catenax.semantics.framework.aas.model.Submodel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

/**
 * Interface to the AAS Server Profile of Catena-X (Companion to the AAS Registry Profile) in Both Proxy and Server Mode (they only distinguish by leaving the idResourceId Path variable empty or not)
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-04T18:11:14.812382100+01:00[Europe/Berlin]")
@Validated
@OpenAPIDefinition(tags = @Tag(name="AAS"), info=@Info( title="aas", description = "Catena-X AAS Server Profile"))
public interface AssetIdentifierApi {

    AssetIdentifierApiDelegate getDelegate();

    @Operation(summary = "Returns the Operation result of an asynchronous invoked Operation", description = "", tags={ "Submodel Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operation result object", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OperationResult.class))) })
    @RequestMapping(value = "/{assetIdentifier}/aas/{submodelIdentifier}/submodel/submodel-elements/{idShortPath}/operation-results/{handleId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<OperationResult> getOperationAsyncResult(@PathVariable(name = "idsResourceId",value="", required = false) String idsResourceId, @Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shells’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("assetIdentifier") String assetIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier, @Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated), in this case an operation", required=true, schema=@Schema()) @PathVariable("idShortPath") String idShortPath, @Parameter(in = ParameterIn.PATH, description = "The returned handle id of an operation’s asynchronous invocation used to request the current state of the operation’s execution (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("handleId") String handleId, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema(allowableValues={ "normal", "value" }
, defaultValue="normal")) @Valid @RequestParam(value = "content", required = false, defaultValue="normal") String content, @RequestParam Map<String,String> otherParams) {
        return getDelegate().getOperationAsyncResult(idsResourceId,assetIdentifier, submodelIdentifier, idShortPath, handleId, content, otherParams);
    }

    @Operation(summary = "Returns the Submodel", description = "", tags={ "Submodel Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Submodel", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Submodel.class))) })
    @RequestMapping(value = "/{assetIdentifier}/aas/{submodelIdentifier}/submodel",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Submodel> getSubmodel(@PathVariable(name = "idsResourceId",value="", required = false) String idsResourceId, @Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shells’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("assetIdentifier") String assetIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier, @Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content" ,schema=@Schema(allowableValues={ "deep", "core" }
, defaultValue="deep")) @Valid @RequestParam(value = "level", required = false, defaultValue="deep") String level, @Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource" ,schema=@Schema(allowableValues={ "normal", "trimmed", "value", "reference", "path" }
, defaultValue="normal")) @Valid @RequestParam(value = "content", required = false, defaultValue="normal") String content, @Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized" ,schema=@Schema(allowableValues={ "withBlobValue", "withoutBlobValue" }
)) @Valid @RequestParam(value = "extent", required = false) String extent, @RequestParam Map<String,String> otherParams) {
        return getDelegate().getSubmodel(idsResourceId,assetIdentifier, submodelIdentifier, level, content, extent, otherParams);
    }


    @Operation(summary = "Returns a specific Submodel", description = "", tags={ "Submodel Repository Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Submodel", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Submodel.class))) })
    @RequestMapping(value = "/{assetIdentifier}/aas/submodels/{submodelIdentifier}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Submodel> getSubmodelById(@PathVariable(name = "idsResourceId",value="", required = false) String idsResourceId, @Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shells’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("assetIdentifier") String assetIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier, @RequestParam Map<String,String> otherParams) {
        return getDelegate().getSubmodelById(idsResourceId,assetIdentifier, submodelIdentifier, otherParams);
    }

    @Operation(summary = "Synchronously or asynchronously invokes an Operation at a specified path", description = "", tags={ "Submodel Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operation result object", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OperationResult.class))) })
    @RequestMapping(value = "/{assetIdentifier}/aas/{submodelIdentifier}/submodel/submodel-elements/{idShortPath}/invoke",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<OperationResult> invokeOperation(@PathVariable(name = "idsResourceId",value="", required = false) String idsResourceId, @Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shells’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("assetIdentifier") String assetIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier, @Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated), in this case an operation", required=true, schema=@Schema()) @PathVariable("idShortPath") String idShortPath, @Parameter(in = ParameterIn.DEFAULT, description = "Operation request object", required=true, schema=@Schema()) @Valid @RequestBody OperationRequest body, @Parameter(in = ParameterIn.QUERY, description = "Determines whether an operation invocation is performed asynchronously or synchronously" ,schema=@Schema( defaultValue="false")) @Valid @RequestParam(value = "async", required = false, defaultValue="false") Boolean async, @Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource" ,schema=@Schema(allowableValues={ "normal", "trimmed", "value", "reference", "path" }
, defaultValue="normal")) @Valid @RequestParam(value = "content", required = false, defaultValue="normal") String content, @RequestParam Map<String,String> otherParams) {
        return getDelegate().invokeOperation(idsResourceId,assetIdentifier, submodelIdentifier, idShortPath, body, async, content, otherParams);
    }


}

