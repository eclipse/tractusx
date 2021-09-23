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

public interface CatenaXApiControllerDelegate {

	public ResponseEntity<String> createBusinessPartnerOneID();

	public ResponseEntity<List<BusinessPartner>> getBusinessPartner(String businessPartnerNumber);

	public ResponseEntity<List<MemberCompany>> getMemberCompany(String businessPartnerOneID);

	public ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll();

	public ResponseEntity<List<Traceability>> getTraceability(String oneid);

	public ResponseEntity<String> purgeTestData(String API_KEY);

	public ResponseEntity<List<PartRelationshipWithInfos>> getBOM(String oneIDManufacturer, String objectIDManufacturer,
			String aspect, Integer depth);

	public ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(String oneid, Integer count,
			String vehicleType);

	public ResponseEntity<List<Object>> getAspect(String aspect, String oneID, String partUniqueID);
	
	

    public List<PartAspectUpdate> getPartAspectUpdate(String bpn, LocalDate effectiveDateTimeStart, LocalDate effectiveDateTimeEnd);

    public List<PartRelationshipUpdateList> getPartRelationshipUpdateList(String bpn, LocalDate effectiveDateTimeStart, LocalDate effectiveDateTimeEnd);

    public List<PartTypeNameUpdate> getPartTypeNameUpdate(String bpn, LocalDate effectiveDateTimeStart, LocalDate effectiveDateTimeEnd);


}
