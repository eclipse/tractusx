/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.aas.api.registry;

import net.catenax.semantics.framework.aas.model.AssetAdministrationShellDescriptor;
import net.catenax.semantics.framework.aas.model.AssetAdministrationShellDescriptorCollection;
import net.catenax.semantics.framework.aas.model.SubmodelDescriptor;
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
public interface RegistryApi {

    RegistryApiDelegate getDelegate();

    @Operation(summary = "Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Asset Administration Shell Descriptor deleted successfully") })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteAssetAdministrationShellDescriptorById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
        return getDelegate().deleteAssetAdministrationShellDescriptorById(aasIdentifier);
    }


    @Operation(summary = "Deletes a Submodel Descriptor, i.e. de-registers a submodel", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Submodel Descriptor deleted successfully") })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteSubmodelDescriptorById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier) {
        return getDelegate().deleteSubmodelDescriptorById(aasIdentifier, submodelIdentifier);
    }


    @Operation(summary = "Returns all Asset Administration Shell Descriptors", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Asset Administration Shell Descriptors", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AssetAdministrationShellDescriptorCollection.class))) })
    @RequestMapping(value = "/registry/shell-descriptors",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<AssetAdministrationShellDescriptorCollection> getAllAssetAdministrationShellDescriptors(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema( defaultValue="0")) @Valid @RequestParam(value = "page", required = false, defaultValue="0") Integer page, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema(allowableValues={ "10", "50", "100" }
, defaultValue="10")) @Valid @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize) {
        return getDelegate().getAllAssetAdministrationShellDescriptors(page, pageSize);
    }


    @Operation(summary = "Returns all Submodel Descriptors", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Submodel Descriptors", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubmodelDescriptor.class)))) })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}/submodel-descriptors",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<SubmodelDescriptor>> getAllSubmodelDescriptors(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
        return getDelegate().getAllSubmodelDescriptors(aasIdentifier);
    }


    @Operation(summary = "Returns a specific Asset Administration Shell Descriptor", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Asset Administration Shell Descriptor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AssetAdministrationShellDescriptor.class))) })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<AssetAdministrationShellDescriptor> getAssetAdministrationShellDescriptorById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
        return getDelegate().getAssetAdministrationShellDescriptorById(aasIdentifier);
    }


    @Operation(summary = "Returns a specific Submodel Descriptor", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested Submodel Descriptor", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubmodelDescriptor.class))) })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<SubmodelDescriptor> getSubmodelDescriptorById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier) {
        return getDelegate().getSubmodelDescriptorById(aasIdentifier, submodelIdentifier);
    }


    @Operation(summary = "Creates a new Asset Administration Shell Descriptor, i.e. registers an AAS", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Asset Administration Shell Descriptor created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AssetAdministrationShellDescriptor.class))) })
    @RequestMapping(value = "/registry/shell-descriptors",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<AssetAdministrationShellDescriptor> postAssetAdministrationShellDescriptor(@Parameter(in = ParameterIn.DEFAULT, description = "Asset Administration Shell Descriptor object", required=true, schema=@Schema()) @Valid @RequestBody AssetAdministrationShellDescriptor body) {
        return getDelegate().postAssetAdministrationShellDescriptor(body);
    }


    @Operation(summary = "Creates a new Submodel Descriptor, i.e. registers a submodel", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Submodel Descriptor created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SubmodelDescriptor.class))) })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}/submodel-descriptors",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<SubmodelDescriptor> postSubmodelDescriptor(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier, @Parameter(in = ParameterIn.DEFAULT, description = "Submodel Descriptor object", required=true, schema=@Schema()) @Valid @RequestBody SubmodelDescriptor body) {
        return getDelegate().postSubmodelDescriptor(aasIdentifier, body);
    }


    @Operation(summary = "Updates an existing Asset Administration Shell Descriptor", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Asset Administration Shell Descriptor updated successfully") })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<Void> putAssetAdministrationShellDescriptorById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier, @Parameter(in = ParameterIn.DEFAULT, description = "Asset Administration Shell Descriptor object", required=true, schema=@Schema()) @Valid @RequestBody AssetAdministrationShellDescriptor body) {
        return getDelegate().putAssetAdministrationShellDescriptorById(aasIdentifier, body);
    }


    @Operation(summary = "Updates an existing Submodel Descriptor", description = "", security = {
        @SecurityRequirement(name = "CatenaXOpenId")    }, tags={ "Registry and Discovery Interface" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Submodel Descriptor updated successfully") })
    @RequestMapping(value = "/registry/shell-descriptors/{aasIdentifier}/submodel-descriptors/{submodelIdentifier}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    default ResponseEntity<Void> putSubmodelDescriptorById(@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("aasIdentifier") String aasIdentifier, @Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier, @Parameter(in = ParameterIn.DEFAULT, description = "Submodel Descriptor object", required=true, schema=@Schema()) @Valid @RequestBody SubmodelDescriptor body) {
        return getDelegate().putSubmodelDescriptorById(aasIdentifier, submodelIdentifier, body);
    }

}

