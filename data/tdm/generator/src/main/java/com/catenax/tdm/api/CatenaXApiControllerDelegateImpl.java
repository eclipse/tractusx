/*
 *
 */
package com.catenax.tdm.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.chrono.ChronoLocalDate;

import com.catenax.tdm.BOM;
import com.catenax.tdm.TestDataGenerator;
import com.catenax.tdm.TransactionQueue;
import com.catenax.tdm.aspect.AspectFactory;
import com.catenax.tdm.dao.AspectDao;
import com.catenax.tdm.dao.AspectMappingDao;
import com.catenax.tdm.dao.BusinessPartnerDao;
import com.catenax.tdm.dao.MemberCompanyDao;
import com.catenax.tdm.dao.PartAspectUpdateDao;
import com.catenax.tdm.dao.PartIdDao;
import com.catenax.tdm.dao.PartInfoDao;
import com.catenax.tdm.dao.PartMappingDao;
import com.catenax.tdm.dao.PartRelationshipDao;
import com.catenax.tdm.dao.PartRelationshipUpdateDao;
import com.catenax.tdm.dao.PartTypeNameUpdateDao;
import com.catenax.tdm.dao.QueueDao;
import com.catenax.tdm.dao.TraceabilityDao;
import com.catenax.tdm.model.v1.Aspect;
import com.catenax.tdm.model.v1.AspectMapping;
import com.catenax.tdm.model.v1.BusinessPartner;
import com.catenax.tdm.model.v1.DocumentClassificationCharacteristicInner;
import com.catenax.tdm.model.v1.DocumentIdCharacteristicInner;
import com.catenax.tdm.model.v1.DocumentVersionsInner;
import com.catenax.tdm.model.v1.DocumentsInner;
import com.catenax.tdm.model.v1.FurtherInformation;
import com.catenax.tdm.model.v1.GeneralInformation;
import com.catenax.tdm.model.v1.Material;
import com.catenax.tdm.model.v1.MemberCompany;
import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.MultiLanguageProperty;
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
import com.catenax.tdm.model.v1.PerformanceIndicatorCharacteristic;
import com.catenax.tdm.model.v1.ProductClassificationsInner;
import com.catenax.tdm.model.v1.ProductDescription;
import com.catenax.tdm.model.v1.ProductUsage;
import com.catenax.tdm.model.v1.TechnicalData;
import com.catenax.tdm.model.v1.TechnicalProperties;
import com.catenax.tdm.model.v1.Traceability;
import com.catenax.tdm.resource.TDMResourceLoader;
import com.catenax.tdm.sampledata.Blueprint;
import com.catenax.tdm.sampledata.BusinessPartnerSampleData;
import com.catenax.tdm.sampledata.TraceabilitySampleData;
import com.catenax.tdm.sampledata.VehicleSampleData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CatenaXApiControllerDelegateImpl.
 */
public class CatenaXApiControllerDelegateImpl implements CatenaXApiControllerDelegate {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(CatenaXApiControllerDelegateImpl.class);

	/** The traceability dao. */
	@Autowired
	TraceabilityDao traceabilityDao;

	/** The member company dao. */
	@Autowired
	MemberCompanyDao memberCompanyDao;

	/** The business partner dao. */
	@Autowired
	BusinessPartnerDao businessPartnerDao;

	/** The part id dao. */
	@Autowired
	PartIdDao partIdDao;

	/** The part info dao. */
	@Autowired
	PartInfoDao partInfoDao;

	/** The part relationship dao. */
	@Autowired
	PartRelationshipDao partRelationshipDao;

	/** The aspect dao. */
	@Autowired
	AspectDao aspectDao;

	/** The part relationship update dao. */
	@Autowired
	PartRelationshipUpdateDao partRelationshipUpdateDao;

	/** The part type name update dao. */
	@Autowired
	PartTypeNameUpdateDao partTypeNameUpdateDao;

	/** The aspect update dao. */
	@Autowired
	PartAspectUpdateDao aspectUpdateDao;

	/** The part mapping dao. */
	@Autowired
	PartMappingDao partMappingDao;

	/** The queue dao. */
	@Autowired
	QueueDao queueDao;
	
	@Autowired
	AspectMappingDao aspectMappingDao;

	// GPDM

	/**
	 * Creates the business partner one ID.
	 *
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<String> createBusinessPartnerOneID() {
		try {
			final String oneID = BusinessPartnerSampleData.generateBPN('L');
			return new ResponseEntity<>(oneID, HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	@Transactional
	public ResponseEntity<List<PartRelationshipWithInfos>> createVehicle(String oneid, Integer count,
			String vehicleType) {
		try {
			log.info("CREATE vehicles: " + oneid + " x " + count);

			// TODO: improve, might cause race condition due to singleton
			TDMResourceLoader.flushCache();

			BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.clear();
			for (final BusinessPartner bp : this.businessPartnerDao.findAll()) {
				if(bp.getParent() != null) {
					log.info("Set Business Partner Parent: " + bp.getBpn() + " " + bp.getName1() + " => " + bp.getParent());
					BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.put(bp.getBpn(), bp.getParent());
				}
			}

			// final List<PartRelationshipWithInfos> result = new ArrayList<>();

			int c = 1;
			if (count != null & count > 0) {
				c = count;
			}

			final Blueprint bp = Blueprint.loadBlueprint(oneid.toUpperCase(), vehicleType.toUpperCase());
			
			for (int i = 0; i < c; i++) {
				createSingleVehicle(vehicleType, bp);
			}

			//result.clear();
			log.info(" --- prepare response");
			return new ResponseEntity<List<PartRelationshipWithInfos>>(new ArrayList<PartRelationshipWithInfos>(), HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<PartRelationshipWithInfos>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public void createSingleVehicle(String vehicleType, final Blueprint bp) {
		TransactionQueue.clear();
		
		final OffsetDateTime effectiveTime = OffsetDateTime.now();
		log.info(" --- generateVehicle");
		final BOM bom = VehicleSampleData.generateVehicle(bp);
		final String vin = bom.getTopLevelRelation().getParent().getPart().getObjectIDManufacturer();

		log.info(" --- createVehicleTraceability");
		this.createVehicleTraceability(bom, vehicleType, vin);

		final List<PartRelationshipWithInfos> resultSet = TestDataGenerator.generatePrsDataFromVehicle(bom);

		log.info(" --- resolve PRS");
		for (final PartRelationshipWithInfos info : resultSet) {
			for (final PartInfo partInfo : info.getPartInfos()) {
				this.partIdDao.create(partInfo.getPart());
				for (final Aspect aspect : partInfo.getAspects()) {
					this.aspectDao.create(aspect);

				}
				this.partInfoDao.create(partInfo);

				final PartTypeNameUpdate partTypeNameUpdate = new PartTypeNameUpdate();
				partTypeNameUpdate.setPart(partInfo.getPart());
				partTypeNameUpdate.setPartTypeName(partInfo.getPartTypeName());
				partTypeNameUpdate.setEffectTime(effectiveTime);
				this.partTypeNameUpdateDao.save(partTypeNameUpdate);

				try {
					final List<Aspect> aspectList = new ArrayList<>();
					aspectList.addAll(partInfo.getAspects());

					final PartAspectUpdate aspectUpdate = new PartAspectUpdate();
					aspectUpdate.setAspects(aspectList);
					aspectUpdate.setPart(partInfo.getPart());
					aspectUpdate.setRemove(false);
					aspectUpdate.setEffectTime(effectiveTime);

					this.aspectUpdateDao.save(aspectUpdate);
				} catch (final Exception e) {
					log.error(e.getLocalizedMessage());
				}
			}

			for (final PartRelationship partRel : info.getRelationships()) {
				this.partRelationshipDao.create(partRel);

				final PartRelationshipUpdate partRelUpdate = new PartRelationshipUpdate();
				partRelUpdate.setEffectTime(effectiveTime);
				partRelUpdate.setRelationship(partRel);
				partRelUpdate.setRemove(false);
				partRelUpdate.setStage(StageEnum.BUILD);
				this.partRelationshipUpdateDao.save(partRelUpdate);
			}
		}

		log.info(" --- flush");
		// result.addAll(resultSet);
		TransactionQueue.flush(queueDao);
	}

	// Member Company

	/**
	 * Creates the vehicle traceability.
	 *
	 * @param bom         the bom
	 * @param vehicleType the vehicle type
	 * @param vin         the vin
	 * @return the list
	 */
	@Transactional
	private List<Traceability> createVehicleTraceability(BOM bom, String vehicleType, String vin) {
		final List<Traceability> ts = TraceabilitySampleData.resolvePartRelation(bom.getTopLevelRelation());

		if (ts.size() > 0) {
			final Traceability vehicle = ts.get(0);

			vehicle.getStaticData()
					.setPartNumberCustomer(VehicleSampleData.getPartNumberCustomerFromPartNumber(vehicleType));
			vehicle.getStaticData()
					.setPartNameCustomer(VehicleSampleData.getPartNameCustomerFromPartNumber(vehicleType));

			vehicle.getStaticData().setPartNumberManufacturer(vehicleType);
			vehicle.getStaticData()
					.setPartNameManufacturer(VehicleSampleData.getPartNameManufacturerFromPartNumber(vehicleType));

			vehicle.getUniqueData().setCustomerUniqueID(vin);
			vehicle.getUniqueData().setManufacturerUniqueID(vin);
			vehicle.getUniqueData().setUniqueID(vin);
		}

		for (final Traceability t : ts) {
			this.traceabilityDao.create(t);
		}

		return ts;
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
	public ResponseEntity<List<Object>> getAspect(String aspect, String oneID, String partUniqueID) {
		try {
			if(aspect != null && "all".equals(aspect.toLowerCase())) {
				List<Object> resultSet = new ArrayList<Object>();
				for(Object o : this.aspectMappingDao.findAllByParentBpn(oneID)) {
					resultSet.add(o);
				}
				return new ResponseEntity<>(resultSet, HttpStatus.OK);
			}
			final List<Object> resultSet = AspectFactory.resolve(aspect, oneID, partUniqueID, queueDao);

			return new ResponseEntity<>(resultSet, HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Traceability

	/**
	 * Gets the business partner.
	 *
	 * @param businessPartnerNumber the business partner number
	 * @return the business partner
	 */
	@Override
	public ResponseEntity<List<BusinessPartner>> getBusinessPartner(String businessPartnerNumber) {
		try {
			final List<BusinessPartner> result = new ArrayList<>();

			for (final BusinessPartner bp : this.businessPartnerDao.findAll()) {
				if (matchBpn(businessPartnerNumber, bp.getBpn(), true)
						|| matchBpn(businessPartnerNumber, bp.getParent(), true)) {
					result.add(bp);
				}
			}

			log.info("Found Business Partners: " + result.size());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the member company.
	 *
	 * @param businessPartnerOneID the business partner one ID
	 * @return the member company
	 */
	@Override
	public ResponseEntity<List<MemberCompany>> getMemberCompany(String businessPartnerOneID) {
		try {

			List<MemberCompany> result = new ArrayList<>();
			if (businessPartnerOneID != null && businessPartnerOneID.trim().length() > 0) {
				for (final MemberCompany m : this.memberCompanyDao.findAll()) {
					if (businessPartnerOneID.equals(m.getBPN())) {
						result.add(m);
					}
				}
			} else {
				result = this.memberCompanyDao.findAll();
			}
			log.info("Found Member Companies: " + result.size());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Gets the member company roles all.
	 *
	 * @return the member company roles all
	 */
	@Override
	public ResponseEntity<List<MemberCompanyRole>> getMemberCompanyRolesAll() {
		try {
			return new ResponseEntity<>(TestDataGenerator.getAllCompanyRoles(), HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Admin
	private String getParentBpn(String bpn) {
		boolean bpnEmpty = bpn == null || bpn.isBlank();
		
		for(String key : BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.keySet()) {
			// log.info(" ==> BPN Parent Mapping: " + key + " => " + BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.get(key));
		}
		
		if((!bpnEmpty) && BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.containsKey(bpn)) {
			String parent = BusinessPartnerSampleData.BUSINESS_PARTNER_PARENT.get(bpn);
			// log.info(" ===> BPN Parent Mapping Result: " + bpn + " => " + parent);
			return parent;
		}
		
		return null;
	}

	/**
	 * Gets the part aspect update.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part aspect update
	 */
	@Override
	public List<PartAspectUpdate> getPartAspectUpdate(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd) {
		final boolean bpnEmpty = bpn == null || bpn.trim().length() == 0;
		final boolean startEmpty = effectiveDateTimeStart == null;
		final boolean endEmpty = effectiveDateTimeEnd == null;

		final List<PartAspectUpdate> result = new ArrayList<>();

		for (final PartAspectUpdate update : this.aspectUpdateDao.findAll()) {
			final ChronoLocalDate eff = ChronoLocalDate.from(update.getEffectTime());

			String parent = getParentBpn(update.getPart().getOneIDManufacturer());
			
			boolean bpnMatch = (bpnEmpty || update.getPart().getOneIDManufacturer().equals(bpn) || bpn.equals(parent));
			// log.info(update.getPart().getOneIDManufacturer() + " == " + bpn + " || " + parent + " = " + bpnMatch);
			
			if (bpnMatch) {
				if (startEmpty || effectiveDateTimeStart.isBefore(eff) || effectiveDateTimeStart.equals(eff)) {
					if (endEmpty || effectiveDateTimeEnd.isAfter(eff) || effectiveDateTimeEnd.equals(eff)) {
						result.add(update);
					}
				}
			}
		}

		return result;
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
	public List<PartRelationshipUpdateList> getPartRelationshipUpdateList(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd) {
		final boolean bpnEmpty = bpn == null || bpn.trim().length() == 0;
		final boolean startEmpty = effectiveDateTimeStart == null;
		final boolean endEmpty = effectiveDateTimeEnd == null;

		final List<PartRelationshipUpdateList> r = new ArrayList<>();

		final PartRelationshipUpdateList rl = new PartRelationshipUpdateList();

		for (final PartRelationshipUpdate update : this.partRelationshipUpdateDao.findAll()) {
			final ChronoLocalDate eff = ChronoLocalDate.from(update.getEffectTime());

			String parentBpn = update.getRelationship().getParent().getOneIDManufacturer();
			String parentParentBpn = getParentBpn(parentBpn);
			
			String childBpn = update.getRelationship().getChild().getOneIDManufacturer();
			String childParentBpn = getParentBpn(childBpn);
			
			boolean bpnMatch = (
					bpnEmpty || 
					parentBpn.equals(bpn) || bpn.equals(parentParentBpn) ||
					childBpn.equals(bpn) || bpn.equals(childParentBpn)
			);

			if (bpnMatch) {
				if (startEmpty || effectiveDateTimeStart.isBefore(eff) || effectiveDateTimeStart.equals(eff)) {
					if (endEmpty || effectiveDateTimeEnd.isAfter(eff) || effectiveDateTimeEnd.equals(eff)) {
						rl.addRelationshipsItem(update);
					}
				}
			}
		}

		r.add(rl);
		return r;
	}

	// BOM - PRS

	/**
	 * Gets the part type name update.
	 *
	 * @param bpn                    the bpn
	 * @param effectiveDateTimeStart the effective date time start
	 * @param effectiveDateTimeEnd   the effective date time end
	 * @return the part type name update
	 */
	@Override
	public List<PartTypeNameUpdate> getPartTypeNameUpdate(String bpn, LocalDate effectiveDateTimeStart,
			LocalDate effectiveDateTimeEnd) {

		final boolean bpnEmpty = bpn == null || bpn.trim().length() == 0;
		final boolean startEmpty = effectiveDateTimeStart == null;
		final boolean endEmpty = effectiveDateTimeEnd == null;

		final List<PartTypeNameUpdate> result = new ArrayList<>();

		for (final PartTypeNameUpdate update : this.partTypeNameUpdateDao.findAll()) {
			final ChronoLocalDate eff = ChronoLocalDate.from(update.getEffectTime());
			
			String parent = getParentBpn(update.getPart().getOneIDManufacturer());
			
			boolean bpnMatch = (bpnEmpty || update.getPart().getOneIDManufacturer().equals(bpn) || bpn.equals(parent));
			// log.info(update.getPart().getOneIDManufacturer() + " == " + bpn + " || " + parent + " = " + bpnMatch);

			if (bpnMatch) {				
				if (startEmpty || effectiveDateTimeStart.isBefore(eff) || effectiveDateTimeStart.equals(eff)) {
					if (endEmpty || effectiveDateTimeEnd.isAfter(eff) || effectiveDateTimeEnd.equals(eff)) {
						result.add(update);
					}
				}
			}
		}

		return result;
	}

	/**
	 * Gets the traceability.
	 *
	 * @param bpn the bpn
	 * @return the traceability
	 */
	@Override
	public ResponseEntity<List<Traceability>> getTraceability(String bpn) {
		try {
			final List<Traceability> ts = new ArrayList<>(); // genTraceability(oneid);
			boolean isEmpty = bpn == null || bpn.isBlank();

			for (final Traceability t : this.traceabilityDao.findAll()) {
				if (isEmpty || matchBpn(bpn, t.getStaticData().getManufactureContractOneID(), true)
						|| matchBpn(bpn, t.getStaticData().getManufacturerOneID(), true)) {
					t.setQualityAlertData(null);
					ts.add(t);
				}
			}

			log.info("Found Persistent Traceability DataSets: " + ts.size());

			final ResponseEntity<List<Traceability>> result = new ResponseEntity<>(ts, HttpStatus.OK);

			return result;
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Initialize test data.
	 */
	@Transactional
	private void initializeTestData() {
		log.info("-= Initialize Test Data =-");

		final ObjectMapper mapper = new ObjectMapper();

		try {
			final String bpRaw = TDMResourceLoader.resourceToString("testdata/BusinessPartner.json");

			for (final BusinessPartner bp : mapper.readValue(bpRaw, new TypeReference<List<BusinessPartner>>() {
			})) {
				log.info("Create BusinessPartner for: " + bp.getBpn() + " " + bp.getName1());
				this.businessPartnerDao.create(bp);
			}
		} catch (final IOException e) {
			log.error(e.getMessage());
			// e.printStackTrace();
		}

		try {
			final String mcRaw = TDMResourceLoader.resourceToString("testdata/MemberCompany.json");

			for (final MemberCompany mc : mapper.readValue(mcRaw, new TypeReference<List<MemberCompany>>() {
			})) {
				log.info("Create MemberCompany for: " + mc.getBPN() + " " + mc.getName());
				this.memberCompanyDao.create(mc);
			}
		} catch (final IOException e) {
			log.error(e.getMessage());
			// e.printStackTrace();
		}

		try {
			final InputStreamReader reader = new InputStreamReader(
					TDMResourceLoader.loadResource("testdata/partmapping.csv"));
			final CSVReader csvReader = new CSVReader(reader);// new FileReader("yourfile.csv"), '\t', '\'', 2);
			final CsvToBeanBuilder<PartMapping> builder = new CsvToBeanBuilder<PartMapping>(csvReader)
					.withType(PartMapping.class);

			for (final PartMapping partMapping : builder.build().parse()) {
				log.info("Create PartMapping for: " + partMapping.getPartNumberManufacturer());
				try {
					this.partMappingDao.create(partMapping);
				} catch (final Exception e) {
					log.error(e.getMessage());
				}
			}
		} catch (final IOException e) {
			log.error(e.getMessage());
			// e.printStackTrace();
		}

		TraceabilitySampleData.setPartMapping(this.partMappingDao.findAll());

		log.info("-= Testdata successfully initialized =-");

		final boolean createVehicles = false;
		if (createVehicles) {
			final int num_cars = 1;
			log.info("-= Creating test vehicles .... =-");

			this.createVehicle(BusinessPartnerSampleData.BPN_BMWLPZ, num_cars, "I01");
			this.createVehicle(BusinessPartnerSampleData.BPN_BMWDGF, num_cars, "G30");
			this.createVehicle(BusinessPartnerSampleData.BPN_BMWDGF, num_cars, "G31");

			log.info("-= Test vehicles successfully initialized =-");
		}

	}

	/**
	 * Match bpn.
	 *
	 * @param parameter             the parameter
	 * @param bpn                   the bpn
	 * @param emptyParameterIsMatch the empty parameter is match
	 * @return true, if successful
	 */
	private boolean matchBpn(String parameter, String bpn, boolean emptyParameterIsMatch) {
		boolean result = false;

		final boolean isEmpty = parameter == null || parameter.trim().length() == 0;

		if (emptyParameterIsMatch && isEmpty) {
			result = true;
		} else if (parameter != null && bpn != null && parameter.toLowerCase().equals(bpn.toLowerCase())) {
			result = true;
		}

		return result;
	}

	/**
	 * Purge test data.
	 *
	 * @param API_KEY the api key
	 * @return the response entity
	 */
	@Override
	@Transactional
	public ResponseEntity<String> purgeTestData(String API_KEY) {
		final String apiKey = System.getenv("TDM_API_KEY");
		log.info("API KEY: " + apiKey);

		try {
			if (API_KEY == null || !API_KEY.toLowerCase().equals(apiKey.toLowerCase())) {
				throw new RuntimeException("Wrong API Key");
			}
		} catch (final Exception e1) {
			throw new RuntimeException("Wrong API Key");
		}

		try {
			// Purge Aspects
			List<Class> classes = Arrays.asList(

					// MaterialCollectionInner.class,
					// MaterialCharacteristic.class,
					// Material.class,
					
					// DocumentVersionsInner.class,
					// DocumentClassificationCharacteristicInner.class,
					// DocumentIdCharacteristicInner.class,
					// DocumentsInner.class,
					
					// ProductDescription.class,
					// PerformanceIndicatorCharacteristic.class,					
					// ProductUsage.class,
					
					// GeneralInformation.class,
					// FurtherInformation.class,
					// ProductClassificationsInner.class,
					// TechnicalProperties.class,
					// TechnicalData.class,
					
					// MultiLanguageProperty.class,
					AspectMapping.class
			);
			
			for(Class clazz : classes) {
				this.queueDao.deleteAll(clazz);
			}

			// Purge PRS
			for (final PartRelationshipUpdate pru : this.partRelationshipUpdateDao.findAll()) {
				this.partRelationshipUpdateDao.delete(pru);
			}
			for (final PartRelationship pr : this.partRelationshipDao.findAll()) {
				this.partRelationshipDao.delete(pr);
			}

			for (final PartAspectUpdate pau : this.aspectUpdateDao.findAll()) {
				this.aspectUpdateDao.delete(pau);
			}
			for (final Aspect aspect : this.aspectDao.findAll()) {
				this.aspectDao.delete(aspect);
			}

			for (final PartTypeNameUpdate ptynu : this.partTypeNameUpdateDao.findAll()) {
				this.partTypeNameUpdateDao.delete(ptynu);
			}
			for (final PartInfo pi : this.partInfoDao.findAll()) {
				this.partInfoDao.delete(pi);
			}
			for (final PartId pid : this.partIdDao.findAll()) {
				this.partIdDao.delete(pid);
			}

			for (final Traceability t : this.traceabilityDao.findAll()) {
				this.traceabilityDao.delete(t);
			}

			for (final MemberCompany mc : this.memberCompanyDao.findAll()) {
				this.memberCompanyDao.delete(mc);
			}
			for (final BusinessPartner bp : this.businessPartnerDao.findAll()) {
				this.businessPartnerDao.delete(bp);
			}
			for (final PartMapping pm : this.partMappingDao.findAll()) {
				this.partMappingDao.delete(pm);
			}
			this.initializeTestData();
			return new ResponseEntity<>("All Testdata purged", HttpStatus.OK);
		} catch (final Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
