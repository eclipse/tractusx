package com.catenax.tdm.sampledata;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.catenax.tdm.BOM;
import com.catenax.tdm.TestDataGenerator;

public class VehicleSampleData {
	
	private static final Logger log = LoggerFactory.getLogger(VehicleSampleData.class);
	
	private static Map<String, VehicleSampleDataGenerator> GENERATORS = new HashMap<String, VehicleSampleDataGenerator>();

	static {
		// add BMW vehicles
		GENERATORS.put("G30", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWDGF, "G30"));
		GENERATORS.put("I01", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWLPZ, "I01"));
		
		GENERATORS.put("G01", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G01"));
		GENERATORS.put("G02", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G02"));
		GENERATORS.put("G05", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G05"));
		GENERATORS.put("G06", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G06"));		
		GENERATORS.put("G20", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G20"));
		GENERATORS.put("G21", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G21"));
		GENERATORS.put("G22", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G22"));			
		GENERATORS.put("G12", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G12"));
		GENERATORS.put("G32", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G32"));
		GENERATORS.put("G31", new DefaultVehicleSampleDataGenerator(BusinessPartnerSampleData.BPN_BMWGROUP, "G31"));

	}
	
	private static VehicleSampleDataGenerator getVehicleSampleDataGenerator(String bpn, String vehicleType) {
		VehicleSampleDataGenerator result = new DefaultVehicleSampleDataGenerator(bpn, "G01");
		String genId = vehicleType.toUpperCase();
		if(GENERATORS.containsKey(genId)) {
			result = GENERATORS.get(genId);
		}			
		return result;
	}
	
	public static BOM generateVehicle(String bpn, String vehicleType) {
		BOM vehicle = new BOM();
		
		String oid = bpn.toUpperCase();
		String vType = vehicleType.toUpperCase();
		String vin = TestDataGenerator.genVIN("");
		
		log.info("Create vehicle for '" + oid + "' of Type: '" + vType + "'");
		
		VehicleSampleDataGenerator generator = getVehicleSampleDataGenerator(oid, vType);
		vehicle = generator.generateVehicle(vin);
		
		log.info("Vehicle with vin '" + vin + "' successfully created");		
		return vehicle;
	}
	
	public static String getPartNameManufacturerFromPartNumber(String partNumber) {
		return TraceabilitySampleData.resolvePartNameManufacturer(partNumber);
	}
	
	public static String getPartNameCustomerFromPartNumber(String partNumber) {
		return TraceabilitySampleData.resolvePartNameCustomerMapping(partNumber);
	}
	
	public static String getPartNumberCustomerFromPartNumber(String partNumber) {
		return TraceabilitySampleData.resolvePartNumberCustomerMapping(partNumber);
	}

}
