/*
 *
 */
package com.catenax.tdm.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.threeten.bp.LocalDate;

import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.PartAspectUpdate;
import com.catenax.tdm.model.v1.PartRelationshipUpdateList;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;
import com.catenax.tdm.model.v1.PartTypeNameUpdate;
import com.catenax.tdm.model.v1.Traceability;

// TODO: Auto-generated Javadoc
/**
 * The Interface CatenaXApiControllerDelegate.
 */
public interface CatenaXApiControllerDelegate {

	/**
	 * Creates the business partner one ID.
	 *
	 * @return the response entity
	 */
	public ResponseEntity<String> createBusinessPartnerOneID();

	/**
	 * Creates the vehicle.
	 *
	 * @param oneid       the oneid
	 * @param count       the count
	 * @param vehicleType the vehicle type
	 * @return the response entity
	 */
	/*
	 * public ResponseEntity<List<PartRelationshipWithInfos>> getBOM(String
	 * oneIDManufacturer, String objectIDManufacturer, String aspect, Integer
	 * depth);
	 */
	public ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(String oneid, Integer count,
			String vehicleType);

	/**
	 * Gets the aspect.
	 *
	 * @param aspect       the aspect
	 * @param oneID        the one ID
	 * @param partUniqueID the part unique ID
	 * @return the aspect
	 */
	public ResponseEntity<List<Object>> getAspect(String aspect, String oneID, String partUniqueID);

	/**
	 * Gets the business partner.
	 *
	 * @param businessPartnerNumber the business partner number
	 * @return the business partner
	 */
	public ResponseEntity<List<BusinessPartner>> getBusinessPartner(String businessPartnerNumber);

	/**
	 * Gets the member company.
	 *
	 * @param businessPartnerOneID the business partner one ID
	 * @return the member company
	 */
	public ResponseEntity<List<MemberCompany>> getMemberCompany(String businessPartnerOneID);

	/**
	 * Gets the member company roles all.
	 *
	 * @return the member company roles all
	 */
	public ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll();

	/**
	 * Gets the part aspect update.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part aspect update
	 */
	public List<PartAspectUpdate> getPartAspectUpdate(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd);

	/**
	 * Gets the part relationship update list.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part relationship update list
	 */
	public List<PartRelationshipUpdateList> getPartRelationshipUpdateList(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd);

	/**
	 * Gets the part type name update.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part type name update
	 */
	public List<PartTypeNameUpdate> getPartTypeNameUpdate(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd);

	/**
	 * Gets the traceability.
	 *
	 * @param oneid the oneid
	 * @return the traceability
	 */
	public ResponseEntity<List<Traceability>> getTraceability(String oneid);

	/**
	 * Purge test data.
	 *
	 * @param API_KEY the api key
	 * @return the response entity
	 */
	public ResponseEntity<String> purgeTestData(String API_KEY);

}
