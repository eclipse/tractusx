package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDate;

import com.catenax.tdm.api.CatenaXApiControllerDelegate;
import com.catenax.tdm.api.Config;
import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.PartAspectUpdate;
import com.catenax.tdm.model.v1.PartRelationshipUpdateList;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;
import com.catenax.tdm.model.v1.PartTypeNameUpdate;
import com.catenax.tdm.model.v1.Traceability;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-13T14:11:36.281Z[GMT]")
@RestController
public class CatenaXApiController implements CatenaXApi {

	private static final Logger log = LoggerFactory.getLogger(CatenaXApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private CatenaXApiControllerDelegate delegate;

	@org.springframework.beans.factory.annotation.Autowired
	public CatenaXApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<String> createBusinessPartnerNumber() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.createBusinessPartnerOneID();
		}

		return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<BusinessPartner>> getBusinessPartner(
			@Parameter(in = ParameterIn.QUERY, description = "ID of Business Partner", schema = @Schema()) @Valid @RequestParam(value = "BusinessPartnerNumber", required = false) String businessPartnerNumber) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getBusinessPartner(businessPartnerNumber);
		}

		return new ResponseEntity<List<BusinessPartner>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(
			@Parameter(in = ParameterIn.PATH, description = "OneID of manufacturer", required = true, schema = @Schema()) @PathVariable("oneid") String oneid,
			@Parameter(in = ParameterIn.QUERY, description = "number of vehicles to create", schema = @Schema()) @Valid @RequestParam(value = "count", required = false) Integer count,
			@Parameter(in = ParameterIn.QUERY, description = "Vehicle Type", schema = @Schema()) @Valid @RequestParam(value = "vehicleType", required = false) String vehicleType) {

		String baseUrl = (System.getenv("TDM_HOST_SECURE")=="false" ? "http://" : "https://") + System.getenv("TDM_HOST_NAME") + ":" + System.getenv("TDM_HOST_PORT");
		Config.BASE_URL = baseUrl;

		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.createVehicle(oneid, count, vehicleType);
		}

		return new ResponseEntity<List<PartRelationshipWithInfos>>(HttpStatus.NOT_IMPLEMENTED);
	}
	/*
	public ResponseEntity<List<PartRelationshipWithInfos>> getBOM(
			@Parameter(in = ParameterIn.PATH, description = "Readable ID of manufacturer including plant", required = true, schema = @Schema()) @PathVariable("oneIDManufacturer") String oneIDManufacturer,
			@Parameter(in = ParameterIn.PATH, description = "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer", required = true, schema = @Schema()) @PathVariable("objectIDManufacturer") String objectIDManufacturer,
			@Parameter(in = ParameterIn.QUERY, description = "Aspect information to add to the returned bom", schema = @Schema()) @Valid @RequestParam(value = "aspect", required = false) String aspect,
			@Parameter(in = ParameterIn.QUERY, description = "Max depth of the returned bom, if empty max depth is returned", schema = @Schema()) @Valid @RequestParam(value = "depth", required = false) Integer depth) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getBOM(oneIDManufacturer, objectIDManufacturer, aspect, depth);
		}

		return new ResponseEntity<List<PartRelationshipWithInfos>>(HttpStatus.NOT_IMPLEMENTED);
	}
	*/
	@Override
	public ResponseEntity<List<PartAspectUpdate>> getPartAspectUpdate(
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<PartAspectUpdate>>(
						delegate.getPartAspectUpdate(bpn, effectiveDateTimeStart, effectiveDateTimeEnd), HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<PartAspectUpdate>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<PartAspectUpdate>>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<PartRelationshipUpdateList>> getPartRelationshipUpdateList(
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<PartRelationshipUpdateList>>(
						delegate.getPartRelationshipUpdateList(bpn, effectiveDateTimeStart, effectiveDateTimeEnd),
						HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<PartRelationshipUpdateList>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<PartRelationshipUpdateList>>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<PartTypeNameUpdate>> getPartTypeNameUpdate(
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<PartTypeNameUpdate>>(
						delegate.getPartTypeNameUpdate(bpn, effectiveDateTimeStart, effectiveDateTimeEnd),
						HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<PartTypeNameUpdate>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<PartTypeNameUpdate>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<MemberCompany>> getMemberCompany(
			@Parameter(in = ParameterIn.QUERY, description = "OneID of Business Partner", schema = @Schema()) @Valid @RequestParam(value = "BusinessPartnerOneID", required = false) String businessPartnerOneID) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getMemberCompany(businessPartnerOneID);
		}
		return new ResponseEntity<List<MemberCompany>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getMemberCompanyRolesAll();
		}

		return new ResponseEntity<List<MemberCompanyRole>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Traceability>> getTraceability(
			@Parameter(in = ParameterIn.PATH, description = "The member company owning the requested Twin.", required = true, schema = @Schema()) @PathVariable("oneid") String oneid) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getTraceability(oneid);
		}

		return new ResponseEntity<List<Traceability>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<String> purgeTestData(
			@NotNull @Parameter(in = ParameterIn.QUERY, description = "API KEY", required = true, schema = @Schema()) @Valid @RequestParam(value = "API_KEY", required = true) String API_KEY) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.purgeTestData(API_KEY);
		}

		return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Object>> getAspect(
			@Parameter(in = ParameterIn.PATH, description = "Aspect Name", required = true, schema = @Schema()) @PathVariable("aspect") String aspect,
			@Parameter(in = ParameterIn.PATH, description = "Business Partner OneID", required = true, schema = @Schema()) @PathVariable("oneID") String oneID,
			@Parameter(in = ParameterIn.PATH, description = "UniqueID of part", required = true, schema = @Schema()) @PathVariable("partUniqueID") String partUniqueID) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getAspect(aspect, oneID, partUniqueID);
		}

		return new ResponseEntity<List<Object>>(HttpStatus.NOT_IMPLEMENTED);
	}

}
