/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import org.threeten.bp.LocalDate;

import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.Error;
import com.catenax.tdm.model.v1.ErrorResponse;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.PartAspectUpdate;
import com.catenax.tdm.model.v1.PartRelationshipUpdateList;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;
import com.catenax.tdm.model.v1.PartTypeNameUpdate;
import com.catenax.tdm.model.v1.Traceability;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-20T08:40:06.877Z[GMT]")
@Validated
public interface CatenaXApi {

    @Operation(summary = "Create Business Partner BPN", description = "Create Business Partner BPN", tags={ "Business Partner Service" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Business Partner BPN", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/businesspartner/bpn",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> createBusinessPartnerNumber();


    @Operation(summary = "Create new vehicle BOM", description = "", tags={ "Parts Relationship Service" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Created BOM", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PartRelationshipWithInfos.class)))),
        
        @ApiResponse(responseCode = "404", description = "BOM not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/vehicle/create/{oneid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(@Parameter(in = ParameterIn.PATH, description = "OneID of manufacturer", required=true, schema=@Schema()) @PathVariable("oneid") String oneid, @Parameter(in = ParameterIn.QUERY, description = "number of vehicles to create" ,schema=@Schema()) @Valid @RequestParam(value = "count", required = false) Integer count, @Parameter(in = ParameterIn.QUERY, description = "Vehicle Type" ,schema=@Schema()) @Valid @RequestParam(value = "vehicleType", required = false) String vehicleType);


    @Operation(summary = "Retrieve Aspect", description = "", tags={ "Aspect Model" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Created BOM", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Object.class)))),
        
        @ApiResponse(responseCode = "404", description = "Aspect not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/aspect/{aspect}/{oneID}/{partUniqueID}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Object>> getAspect(@Parameter(in = ParameterIn.PATH, description = "Aspect Name", required=true, schema=@Schema()) @PathVariable("aspect") String aspect, @Parameter(in = ParameterIn.PATH, description = "Business Partner OneID", required=true, schema=@Schema()) @PathVariable("oneID") String oneID, @Parameter(in = ParameterIn.PATH, description = "UniqueID of part", required=true, schema=@Schema()) @PathVariable("partUniqueID") String partUniqueID);


    @Operation(summary = "Get a BOM by its id", description = "", tags={ "Parts Relationship Service" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found the BOM", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PartRelationshipWithInfos.class)))),
        
        @ApiResponse(responseCode = "404", description = "BOM not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/prs/bom/{oneIDManufacturer}/{objectIDManufacturer}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PartRelationshipWithInfos>> getBOM(@Parameter(in = ParameterIn.PATH, description = "Readable ID of manufacturer including plant", required=true, schema=@Schema()) @PathVariable("oneIDManufacturer") String oneIDManufacturer, @Parameter(in = ParameterIn.PATH, description = "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer", required=true, schema=@Schema()) @PathVariable("objectIDManufacturer") String objectIDManufacturer, @Parameter(in = ParameterIn.QUERY, description = "Aspect information to add to the returned bom" ,schema=@Schema()) @Valid @RequestParam(value = "aspect", required = false) String aspect, @Parameter(in = ParameterIn.QUERY, description = "Max depth of the returned bom, if empty max depth is returned" ,schema=@Schema()) @Valid @RequestParam(value = "depth", required = false) Integer depth);


    @Operation(summary = "Get Business Partner", description = "Get Business Partner", tags={ "Business Partner Service" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Business Partner BPN", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BusinessPartner.class)))),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/businesspartner",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<BusinessPartner>> getBusinessPartner(@Parameter(in = ParameterIn.QUERY, description = "ID of Business Partner" ,schema=@Schema()) @Valid @RequestParam(value = "BusinessPartnerNumber", required = false) String businessPartnerNumber);


    @Operation(summary = "Retrieve Member Company", description = "Retrieve Member Company", tags={ "Member Company Service" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Business Partner", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MemberCompany.class)))),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/member/company",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<MemberCompany>> getMemberCompany(@Parameter(in = ParameterIn.QUERY, description = "ID of Business Partner" ,schema=@Schema()) @Valid @RequestParam(value = "BusinessPartnerNumber", required = false) String businessPartnerNumber);


    @Operation(summary = "Retrieve all possible Roles for a Business Partner", description = "Retrieve all possible Roles for a Business Partner", tags={ "Member Company Service" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "TBD", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MemberCompanyRole.class)))),
        
        @ApiResponse(responseCode = "200", description = "Unexpected error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/member/company/role/all",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll();


    @Operation(summary = "Get a PartAspectUpdate. Describes an update of a PartAspectUpdate.", description = "", tags={ "Parts Relationship Service - Broker HTTP Proxy API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found the BOM", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PartAspectUpdate.class)))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/prs/broker/PartAspectUpdate",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PartAspectUpdate>> getPartAspectUpdate(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd);


    @Operation(summary = "Get a PartAspectUpdate. Describes an update of a PartAspectUpdate.", description = "", tags={ "Parts Relationship Service - Broker HTTP Proxy API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found the BOM", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PartRelationshipUpdateList.class)))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/prs/broker/PartRelationshipUpdateList",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PartRelationshipUpdateList>> getPartRelationshipUpdateList(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd);


    @Operation(summary = "Get a PartTypeNameUpdate. Describes an update of a part type name.", description = "", tags={ "Parts Relationship Service - Broker HTTP Proxy API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found the BOM", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PartTypeNameUpdate.class)))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/prs/broker/PartTypeNameUpdate",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PartTypeNameUpdate>> getPartTypeNameUpdate(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd);


    @Operation(summary = "get all Traceability information for OneID", description = "", tags={ "Traceability" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "The request was successful.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Traceability.class)))),
        
        @ApiResponse(responseCode = "401", description = "Payload or user input is invalid. See error details in the payload for more.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "402", description = "The requesting user or client is not authenticated."),
        
        @ApiResponse(responseCode = "403", description = "The requesting user or client is not authorized to access resources for the given tenant."),
        
        @ApiResponse(responseCode = "404", description = "The requested Twin has not been found.") })
    @RequestMapping(value = "/catena-x/tdm/1.0/traceability/{oneid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Traceability>> getTraceability(@Parameter(in = ParameterIn.PATH, description = "The member company owning the requested Twin.", required=true, schema=@Schema()) @PathVariable("oneid") String oneid);


    @Operation(summary = "Purge all current test data", description = "", tags={ "TDM Admin" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "purged", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
    @RequestMapping(value = "/catena-x/tdm/1.0/admin/purge",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<String> purgeTestData(@NotNull @Parameter(in = ParameterIn.QUERY, description = "API KEY" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "API_KEY", required = true) String API_KEY);

}
