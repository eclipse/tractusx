package com.catenax.tdm.sampledata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.catenax.tdm.BOM;
import com.catenax.tdm.BOM.PartRelation;
import com.catenax.tdm.PartType;
import com.catenax.tdm.TestDataGenerator;
import com.catenax.tdm.model.v1.PartInfo;

public class DefaultVehicleSampleDataGenerator implements VehicleSampleDataGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(DefaultVehicleSampleDataGenerator.class);

	private static final int DEFAULT_PART_ID_LEN = 17;
	private String bpn = "";
	private String vehicleType = null;
	
	
	private boolean isHybrid = false;
	private boolean isElectric = false;
	
	private int idLen = DEFAULT_PART_ID_LEN;

	public DefaultVehicleSampleDataGenerator(String bpn, String vehicleType) {
		this.bpn = bpn;
		this.vehicleType = vehicleType;
	}

	@Override
	public BOM generateVehicle(String vin) {
		if(this.vehicleType.toUpperCase().startsWith("I")) {
			this.isElectric = true;
		} else if(vehicleType.toUpperCase().equals("G31")) {
			this.isHybrid = true;
		}		
		
		PartInfo piTop = PartSampleData.generatePartInfo(this.bpn, vin, PartType.VEHICLE.toString());

		return generateGenericExample(piTop, vin);
	}

	private PartRelation generateHVS(PartInfo piTop) {
		PartInfo piHVS = PartSampleData.createHVS(piTop);
		
		PartInfo piHVB = PartSampleData.createHVBModule(piTop);
		
		PartInfo piHVC = PartSampleData.createHVBCell(piHVS);
		
		PartRelation hvc = new PartRelation(piHVC);
		
		PartRelation hvb = new PartRelation(piHVB, hvc);
		
		PartRelation hvs = new PartRelation(piHVS, hvb);
		
		return hvs;
	}
	
	private PartRelation generateGearbox(PartInfo piTop) {
		PartInfo piGearbox = PartSampleData.createGearbox(piTop);

		PartInfo piHenkel = PartSampleData.generatePartInfo(BusinessPartnerSampleData.BPN_HENKEL,
				TestDataGenerator.genString("HE", idLen), PartType.SUMP.toString());
		
		PartInfo piGlue = PartSampleData.generatePartInfo(BusinessPartnerSampleData.BPN_BASF,
				TestDataGenerator.genString("BA", idLen), PartType.GLUE.toString());

		PartRelation glr = new PartRelation(piGlue);

		PartRelation ghe = new PartRelation(piHenkel, glr);

		PartRelation gbr = new PartRelation(piGearbox, ghe);
		
		return gbr;
	}

	private BOM generateGenericExample(PartInfo piTop, String vin) {		
		
		BOM bom = new BOM();
		
		if(this.isHybrid) {
			log.info("Create Hybrid vehicle" + " '" + this.vehicleType + "'");

			PartRelation gbr = generateGearbox(piTop);
			
			PartRelation hvs = generateHVS(piTop);

			PartRelation pr = new PartRelation(piTop, gbr, hvs);			

			bom.setTopLevelRelation(pr);	
		} else if(this.isElectric) {
			log.info("Create Electric vehicle" + " '" + this.vehicleType + "'");
			PartRelation hvs = generateHVS(piTop);

			PartRelation pr = new PartRelation(piTop, hvs);

			bom.setTopLevelRelation(pr);	
		} else {
			log.info("Create Classic vehicle" + " '" + this.vehicleType + "'");
			PartRelation gbr = generateGearbox(piTop);

			PartRelation pr = new PartRelation(piTop, gbr);			

			bom.setTopLevelRelation(pr);			
		}

		return bom;
	}

}
