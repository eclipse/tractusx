package com.catenax.tdm.api;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import com.catenax.tdm.BOM;
import com.catenax.tdm.TestDataGenerator;
import com.catenax.tdm.aspect.AspectFactory;
import com.catenax.tdm.dao.AspectDao;
import com.catenax.tdm.dao.AspectUpdateDao;
import com.catenax.tdm.dao.BusinessPartnerDao;
import com.catenax.tdm.dao.MemberCompanyDao;
import com.catenax.tdm.dao.PartIdDao;
import com.catenax.tdm.dao.PartInfoDao;
import com.catenax.tdm.dao.PartMappingDao;
import com.catenax.tdm.dao.PartRelationshipDao;
import com.catenax.tdm.dao.PartRelationshipUpdateDao;
import com.catenax.tdm.dao.PartTypeNameUpdateDao;
import com.catenax.tdm.dao.TraceabilityDao;
import com.catenax.tdm.model.v1.Aspect;
import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.PartAspectUpdate;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.PartMapping;
import com.catenax.tdm.model.v1.PartRelationship;
import com.catenax.tdm.model.v1.PartRelationshipUpdate;
import com.catenax.tdm.model.v1.PartRelationshipUpdate.StageEnum;
import com.catenax.tdm.model.v1.PartRelationshipUpdateList;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;
import com.catenax.tdm.model.v1.PartTypeNameUpdate;
import com.catenax.tdm.model.v1.Traceability;
import com.catenax.tdm.sampledata.BusinessPartnerSampleData;
import com.catenax.tdm.sampledata.InitialSampleData;
import com.catenax.tdm.sampledata.TraceabilitySampleData;
import com.catenax.tdm.sampledata.VehicleSampleData;

public class CatenaXApiControllerDelegateImpl implements CatenaXApiControllerDelegate {

	private static final Logger log = LoggerFactory.getLogger(CatenaXApiControllerDelegateImpl.class);

	@Autowired
	TraceabilityDao traceabilityDao;

	@Autowired
	MemberCompanyDao memberCompanyDao;

	@Autowired
	BusinessPartnerDao businessPartnerDao;

	@Autowired
	PartIdDao partIdDao;

	@Autowired
	PartInfoDao partInfoDao;

	@Autowired
	PartRelationshipDao partRelationshipDao;

	@Autowired
	AspectDao aspectDao;

	@Autowired
	PartRelationshipUpdateDao partRelationshipUpdateDao;

	@Autowired
	PartTypeNameUpdateDao partTypeNameUpdateDao;

	@Autowired
	AspectUpdateDao aspectUpdateDao;
	
	@Autowired
	PartMappingDao partMappingDao;

	// GPDM

	public ResponseEntity<String> createBusinessPartnerOneID() {
		try {
			String oneID = BusinessPartnerSampleData.generateBPN('L');
			return new ResponseEntity<String>(oneID, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<BusinessPartner>> getBusinessPartner(String businessPartnerNumber) {
		try {
			List<BusinessPartner> result = new ArrayList<BusinessPartner>();
			if (businessPartnerNumber != null && businessPartnerNumber.trim().length() > 0) {
				for (BusinessPartner bp : this.businessPartnerDao.findAll()) {
					if (businessPartnerNumber.equals(bp.getBpn())) {
						result.add(bp);
					}
				}
			} else {
				result = this.businessPartnerDao.findAll();
			}
			log.info("Found Business Partners: " + result.size());
			return new ResponseEntity<List<BusinessPartner>>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<BusinessPartner>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Member Company

	public ResponseEntity<List<MemberCompany>> getMemberCompany(String businessPartnerOneID) {
		try {

			List<MemberCompany> result = new ArrayList<MemberCompany>();
			if (businessPartnerOneID != null && businessPartnerOneID.trim().length() > 0) {
				for (MemberCompany m : this.memberCompanyDao.findAll()) {
					if (businessPartnerOneID.equals(m.getBPN())) {
						result.add(m);
					}
				}
			} else {
				result = this.memberCompanyDao.findAll();
			}
			log.info("Found Member Companies: " + result.size());
			return new ResponseEntity<List<MemberCompany>>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<MemberCompany>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll() {
		try {
			return new ResponseEntity<List<MemberCompanyRole>>(TestDataGenerator.getAllCompanyRoles(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<MemberCompanyRole>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Traceability

	@Transactional
	private List<Traceability> genTraceabilityVehicle(BOM bom, String vehicleType, String vin) {
		List<Traceability> ts = TraceabilitySampleData.resolvePartRelation(bom.getTopLevelRelation());
		
		ts.get(0).getStaticData().setPartNumberCustomer(VehicleSampleData.getPartNumberCustomerFromPartNumber(vehicleType));
		ts.get(0).getStaticData().setPartNameCustomer(VehicleSampleData.getPartNameCustomerFromPartNumber(vehicleType));
		
		ts.get(0).getStaticData().setPartNumberManufacturer(vehicleType);
		ts.get(0).getStaticData().setPartNameManufacturer(VehicleSampleData.getPartNameManufacturerFromPartNumber(vehicleType));
		
		ts.get(0).getUniqueData().setCustomerUniqueID(vin);
		ts.get(0).getUniqueData().setManufacturerUniqueID(vin);
		ts.get(0).getUniqueData().setUniqueID(vin);

		for (Traceability t : ts) {
			this.traceabilityDao.create(t);
		}

		return ts;
	}

	public ResponseEntity<List<Traceability>> getTraceability(String oneid) {
		try {
			List<Traceability> ts = new ArrayList<Traceability>(); // genTraceability(oneid);

			// ts.clear();

			boolean isEmpty = oneid == null || oneid.trim().length() == 0;

			for (Traceability t : this.traceabilityDao.findAll()) {
				if (isEmpty || oneid.toLowerCase().equals(t.getStaticData().getManufactureContractOneID().toLowerCase())
						|| oneid.toLowerCase().equals(t.getStaticData().getManufacturerOneID().toLowerCase())) {
					t.setQualityAlertData(null);
					ts.add(t);
				}
			}

			log.info("Found Persistent Traceability DataSets: " + ts.size());

			ResponseEntity<List<Traceability>> result = new ResponseEntity<List<Traceability>>(ts, HttpStatus.OK);

			return result;
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Traceability>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Admin

	@Transactional
	public ResponseEntity<String> purgeTestData(String API_KEY) {
		String apiKey = System.getenv("TDM_API_KEY");
		log.info("API KEY: " + apiKey);

		try {
			if (API_KEY == null || !API_KEY.toLowerCase().equals(apiKey.toLowerCase())) {
				throw new RuntimeException("Wrong API Key");
			}
		} catch (Exception e1) {
			throw new RuntimeException("Wrong API Key");
		}

		try {
			for (PartRelationshipUpdate pru : this.partRelationshipUpdateDao.findAll()) {
				this.partRelationshipUpdateDao.delete(pru);
			}
			for (PartRelationship pr : this.partRelationshipDao.findAll()) {
				this.partRelationshipDao.delete(pr);
			}
			
			for(PartAspectUpdate pau : this.aspectUpdateDao.findAll()) {
				this.aspectUpdateDao.delete(pau);
			}
			for(Aspect aspect : this.aspectDao.findAll()) {
				this.aspectDao.delete(aspect);
			}
			
			for (PartTypeNameUpdate ptynu : this.partTypeNameUpdateDao.findAll()) {
				this.partTypeNameUpdateDao.delete(ptynu);
			}
			for (PartInfo pi : this.partInfoDao.findAll()) {
				this.partInfoDao.delete(pi);
			}
			for (PartId pid : this.partIdDao.findAll()) {
				this.partIdDao.delete(pid);
			}
			
			for (Traceability t : this.traceabilityDao.findAll()) {
				this.traceabilityDao.delete(t);
			}
			
			for(MemberCompany mc : this.memberCompanyDao.findAll()) {
				this.memberCompanyDao.delete(mc);
			}
			for(BusinessPartner bp : this.businessPartnerDao.findAll()) {
				this.businessPartnerDao.delete(bp);
			}
			for(PartMapping pm : this.partMappingDao.findAll()) {
				this.partMappingDao.delete(pm);
			}
			this.initializeTestData();
			return new ResponseEntity<String>("All Testdata purged", HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	private void initializeTestData() {
		log.info("Initialize Test Data ...");
		InitialSampleData sd = new InitialSampleData();

		List<InitialSampleData.BPMC> businessPartners = sd.createInitialBusinessPartners();
		for (InitialSampleData.BPMC bpmc : businessPartners) {
			log.info("Create Business Partner: " + bpmc.getBusinessPartner().getBpn());
			this.businessPartnerDao.create(bpmc.getBusinessPartner());
			if (bpmc.getMemberCompany() != null) {
				log.info("Create Member Company: " + bpmc.getMemberCompany().getName());
				this.memberCompanyDao.create(bpmc.getMemberCompany());
			}
		}
		
		this.partMappingDao.create(new PartMapping("I01", "i3s 120", null, "i3"));
		this.partMappingDao.create(new PartMapping("G30", "520i", null, "5-series sedan"));
		
		this.partMappingDao.create(new PartMapping("8HP51XB47O1", "8HP51X B47O1", "9487330", "LU GETRIEBE GA8X51CZ B47D2001  CODE SW92"));
		this.partMappingDao.create(new PartMapping("2412117", "VM ZB SE09 HVS MH D-MUSTER EXV", null, null));
		this.partMappingDao.create(new PartMapping("6127713", "<HVB Module>", null, null));
		this.partMappingDao.create(new PartMapping("6127714", "<HVB Cell>", null, null));
		
		TraceabilitySampleData.setPartMapping(this.partMappingDao.findAll());
		
		log.info("Testdata successfully initialized");
	}

	// BOM - PRS

	public ResponseEntity<List<PartRelationshipWithInfos>> getBOM(String oneIDManufacturer, String objectIDManufacturer,
			String aspect, Integer depth) {
		try {
			ResponseEntity<List<PartRelationshipWithInfos>> result = new ResponseEntity<List<PartRelationshipWithInfos>>(
					new ArrayList<PartRelationshipWithInfos>(), HttpStatus.NOT_IMPLEMENTED);
			return result;
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<PartRelationshipWithInfos>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	public ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(String oneid, Integer count,
			String vehicleType) {
		try {
			log.info("CREATE vehicles: " + oneid + " x " + count);
			
			BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.clear();
			for (BusinessPartner bp : this.businessPartnerDao.findAll()) {
				BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.put(bp.getBpn(), bp.getParent());
			}

			List<PartRelationshipWithInfos> result = new ArrayList<PartRelationshipWithInfos>();

			int c = 1;
			if (count != null & count > 0) {
				c = count;
			}

			for (int i = 0; i < c; i++) {
				OffsetDateTime effectiveTime = OffsetDateTime.now();

				BOM bom = VehicleSampleData.generateVehicle(oneid, vehicleType);
				String vin = bom.getTopLevelRelation().getParent().getPart().getObjectIDManufacturer();
				
				this.genTraceabilityVehicle(bom, vehicleType, vin);

				List<PartRelationshipWithInfos> resultSet = TestDataGenerator.generatePrsDataFromVehicle(bom);					
				
				for (PartRelationshipWithInfos info : resultSet) {
					for (PartInfo partInfo : info.getPartInfos()) {
						this.partIdDao.create(partInfo.getPart());
						for (Aspect aspect : partInfo.getAspects()) {
							this.aspectDao.create(aspect);

						}
						this.partInfoDao.create(partInfo);

						PartTypeNameUpdate partTypeNameUpdate = new PartTypeNameUpdate();
						partTypeNameUpdate.setPart(partInfo.getPart());
						partTypeNameUpdate.setPartTypeName(partInfo.getPartTypeName());
						partTypeNameUpdate.setEffectTime(effectiveTime);
						this.partTypeNameUpdateDao.create(partTypeNameUpdate);

						try {
							List<Aspect> aspectList = new ArrayList<Aspect>();
							aspectList.addAll(partInfo.getAspects());

							PartAspectUpdate aspectUpdate = new PartAspectUpdate();
							aspectUpdate.setAspects(aspectList);
							aspectUpdate.setPart(partInfo.getPart());
							aspectUpdate.setRemove(false);
							aspectUpdate.setEffectTime(effectiveTime);

							this.aspectUpdateDao.create(aspectUpdate);
						} catch (Exception e) {
							log.error(e.getLocalizedMessage());
						}
					}

					for (PartRelationship partRel : info.getRelationships()) {
						this.partRelationshipDao.create(partRel);

						PartRelationshipUpdate partRelUpdate = new PartRelationshipUpdate();
						partRelUpdate.setEffectTime(effectiveTime);
						partRelUpdate.setRelationship(partRel);
						partRelUpdate.setRemove(false);
						partRelUpdate.setStage(StageEnum.BUILD);
						this.partRelationshipUpdateDao.create(partRelUpdate);
					}
				}

				result.addAll(resultSet);
			}

			return new ResponseEntity<List<PartRelationshipWithInfos>>(result, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<PartRelationshipWithInfos>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Object>> getAspect(String aspect, String oneID, String partUniqueID) {
		try {
			List<Object> resultSet = AspectFactory.resolve(aspect, oneID, partUniqueID);

			return new ResponseEntity<List<Object>>(resultSet, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<PartAspectUpdate> getPartAspectUpdate(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd) {
		List<PartAspectUpdate> result = new ArrayList<PartAspectUpdate>();

		for (PartAspectUpdate update : this.aspectUpdateDao.findAll()) {
			result.add(update);
		}

		return result;
	}

	@Override
	public List<PartRelationshipUpdateList> getPartRelationshipUpdateList(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd) {
		List<PartRelationshipUpdateList> result = new ArrayList<PartRelationshipUpdateList>();
		PartRelationshipUpdateList resultList = new PartRelationshipUpdateList();

		for (PartRelationshipUpdate update : this.partRelationshipUpdateDao.findAll()) {
			resultList.addRelationshipsItem(update);
		}

		result.add(resultList);

		return result;
	}

	@Override
	public List<PartTypeNameUpdate> getPartTypeNameUpdate(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd) {
		List<PartTypeNameUpdate> result = new ArrayList<PartTypeNameUpdate>();

		for (PartTypeNameUpdate update : this.partTypeNameUpdateDao.findAll()) {
			result.add(update);
		}

		return result;
	}

}
