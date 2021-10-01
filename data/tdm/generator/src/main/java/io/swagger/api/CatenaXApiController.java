/*
 *
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class CatenaXApiController.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-09-13T14:11:36.281Z[GMT]")
@RestController
public class CatenaXApiController implements CatenaXApi {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(CatenaXApiController.class);

	/** The object mapper. */
	private final ObjectMapper objectMapper;

	/** The request. */
	private final HttpServletRequest request;

	/** The delegate. */
	@Autowired
	private CatenaXApiControllerDelegate delegate;

	/**
	 * Instantiates a new catena X api controller.
	 *
	 * @param objectMapper the object mapper
	 * @param request      the request
	 */
	@org.springframework.beans.factory.annotation.Autowired
	public CatenaXApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	/**
	 * Creates the business partner number.
	 *
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<String> createBusinessPartnerNumber() {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.createBusinessPartnerOneID();
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Creates the vehicle.
	 *
	 * @param oneid       the oneid
	 * @param count       the count
	 * @param vehicleType the vehicle type
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(
			@Parameter(in = ParameterIn.PATH, description = "OneID of manufacturer", required = true, schema = @Schema()) @PathVariable("oneid") String oneid,
			@Parameter(in = ParameterIn.QUERY, description = "number of vehicles to create", schema = @Schema()) @Valid @RequestParam(value = "count", required = false) Integer count,
			@Parameter(in = ParameterIn.QUERY, description = "Vehicle Type", schema = @Schema()) @Valid @RequestParam(value = "vehicleType", required = false) String vehicleType) {

		final String baseUrl = (System.getenv("TDM_HOST_SECURE") == "false" ? "http://" : "https://")
				+ System.getenv("TDM_HOST_NAME") + ":" + System.getenv("TDM_HOST_PORT");
		Config.BASE_URL = baseUrl;

		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.createVehicle(oneid, count, vehicleType);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the aspect.
	 *
	 * @param aspect       the aspect
	 * @param oneID        the one ID
	 * @param partUniqueID the part unique ID
	 * @return the aspect
	 */
	@Override
	public ResponseEntity<List<Object>> getAspect(
			@Parameter(in = ParameterIn.PATH, description = "Aspect Name", required = true, schema = @Schema()) @PathVariable("aspect") String aspect,
			@Parameter(in = ParameterIn.PATH, description = "Business Partner OneID", required = true, schema = @Schema()) @PathVariable("oneID") String oneID,
			@Parameter(in = ParameterIn.PATH, description = "UniqueID of part", required = true, schema = @Schema()) @PathVariable("partUniqueID") String partUniqueID) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getAspect(aspect, oneID, partUniqueID);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the business partner.
	 *
	 * @param businessPartnerNumber the business partner number
	 * @return the business partner
	 */
	@Override
	public ResponseEntity<List<BusinessPartner>> getBusinessPartner(
			@Parameter(in = ParameterIn.QUERY, description = "ID of Business Partner", schema = @Schema()) @Valid @RequestParam(value = "BusinessPartnerNumber", required = false) String businessPartnerNumber) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getBusinessPartner(businessPartnerNumber);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the member company.
	 *
	 * @param businessPartnerOneID the business partner one ID
	 * @return the member company
	 */
	@Override
	public ResponseEntity<List<MemberCompany>> getMemberCompany(
			@Parameter(in = ParameterIn.QUERY, description = "OneID of Business Partner", schema = @Schema()) @Valid @RequestParam(value = "BusinessPartnerOneID", required = false) String businessPartnerOneID) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getMemberCompany(businessPartnerOneID);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the member company roles all.
	 *
	 * @return the member company roles all
	 */
	@Override
	public ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll() {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getMemberCompanyRolesAll();
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the part aspect update.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part aspect update
	 */
	/*
	 * public ResponseEntity<List<PartRelationshipWithInfos>> getBOM(
	 *
	 * @Parameter(in = ParameterIn.PATH, description =
	 * "Readable ID of manufacturer including plant", required = true, schema
	 * = @Schema()) @PathVariable("oneIDManufacturer") String oneIDManufacturer,
	 *
	 * @Parameter(in = ParameterIn.PATH, description =
	 * "Unique identifier of a single, unique physical (sub)component/part/batch, given by its manufacturer"
	 * , required = true, schema = @Schema()) @PathVariable("objectIDManufacturer")
	 * String objectIDManufacturer,
	 *
	 * @Parameter(in = ParameterIn.QUERY, description =
	 * "Aspect information to add to the returned bom", schema
	 * = @Schema()) @Valid @RequestParam(value = "aspect", required = false) String
	 * aspect,
	 *
	 * @Parameter(in = ParameterIn.QUERY, description =
	 * "Max depth of the returned bom, if empty max depth is returned", schema
	 * = @Schema()) @Valid @RequestParam(value = "depth", required = false) Integer
	 * depth) { String accept = request.getHeader("Accept"); if (accept != null &&
	 * accept.contains("application/json")) { return
	 * delegate.getBOM(oneIDManufacturer, objectIDManufacturer, aspect, depth); }
	 *
	 * return new
	 * ResponseEntity<List<PartRelationshipWithInfos>>(HttpStatus.NOT_IMPLEMENTED);
	 * }
	 */
	@Override
	public ResponseEntity<List<PartAspectUpdate>> getPartAspectUpdate(
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<>(
						delegate.getPartAspectUpdate(bpn, effectiveDateTimeStart, effectiveDateTimeEnd), HttpStatus.OK);
			} catch (final Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the part relationship update list.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part relationship update list
	 */
	@Override
	public ResponseEntity<List<PartRelationshipUpdateList>> getPartRelationshipUpdateList(
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<>(
						delegate.getPartRelationshipUpdateList(bpn, effectiveDateTimeStart, effectiveDateTimeEnd),
						HttpStatus.OK);
			} catch (final Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the part type name update.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part type name update
	 */
	@Override
	public ResponseEntity<List<PartTypeNameUpdate>> getPartTypeNameUpdate(
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "bpn", required = false) String bpn,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeStart", required = false) LocalDate effectiveDateTimeStart,
			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema()) @Valid @RequestParam(value = "effectiveDateTimeEnd", required = false) LocalDate effectiveDateTimeEnd) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<>(
						delegate.getPartTypeNameUpdate(bpn, effectiveDateTimeStart, effectiveDateTimeEnd),
						HttpStatus.OK);
			} catch (final Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Gets the traceability.
	 *
	 * @param oneid the oneid
	 * @return the traceability
	 */
	@Override
	public ResponseEntity<List<Traceability>> getTraceability(
			@Parameter(in = ParameterIn.PATH, description = "The member company owning the requested Twin.", required = true, schema = @Schema()) @PathVariable("oneid") String oneid) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.getTraceability(oneid);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Purge test data.
	 *
	 * @param API_KEY the api key
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<String> purgeTestData(
			@NotNull @Parameter(in = ParameterIn.QUERY, description = "API KEY", required = true, schema = @Schema()) @Valid @RequestParam(value = "API_KEY", required = true) String API_KEY) {
		final String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return delegate.purgeTestData(API_KEY);
		}

		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
