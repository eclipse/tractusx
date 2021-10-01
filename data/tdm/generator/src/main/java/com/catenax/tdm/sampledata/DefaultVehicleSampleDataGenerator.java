/*
 *
 */
package com.catenax.tdm.sampledata;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.catenax.tdm.BOM;
import com.catenax.tdm.BOM.PartRelation;
import com.catenax.tdm.PartType;
import com.catenax.tdm.model.v1.PartInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultVehicleSampleDataGenerator.
 */
public class DefaultVehicleSampleDataGenerator implements VehicleSampleDataGenerator {

	/** The Constant DEFAULT_COUNT_HVB_MODULE. */
	private static final int DEFAULT_COUNT_HVB_MODULE = 6;

	/** The Constant DEFAULT_COUNT_HVB_CELL. */
	private static final int DEFAULT_COUNT_HVB_CELL = 16;

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(DefaultVehicleSampleDataGenerator.class);

	/** The Constant DEFAULT_PART_ID_LEN. */
	private static final int DEFAULT_PART_ID_LEN = 17;

	/** The bpn. */
	private String bpn = "";

	/** The vehicle type. */
	private String vehicleType = null;

	/** The is hybrid. */
	private boolean isHybrid = false;

	/** The is electric. */
	private boolean isElectric = false;

	/** The id len. */
	private final int idLen = DEFAULT_PART_ID_LEN;

	/**
	 * Instantiates a new default vehicle sample data generator.
	 *
	 * @param bpn         the bpn
	 * @param vehicleType the vehicle type
	 */
	public DefaultVehicleSampleDataGenerator(String bpn, String vehicleType) {
		this.bpn = bpn;
		this.vehicleType = vehicleType;
	}

	/**
	 * Generate gearbox.
	 *
	 * @param piTop the pi top
	 * @return the part relation
	 */
	private PartRelation generateGearbox(PartInfo piTop) {
		final PartInfo piGearbox = PartSampleData.createGearbox(piTop);

		final PartInfo piSump = PartSampleData.createSump(piGearbox);

		final PartInfo piMaterial = PartSampleData.createMaterial(piSump);
		final PartInfo piAdhesive = PartSampleData.createAdhesive(piSump);

		final PartRelation gMaterial = new PartRelation(piMaterial);
		final PartRelation gAdhesive = new PartRelation(piAdhesive);

		final PartRelation gSump = new PartRelation(piSump, gMaterial, gAdhesive);

		final PartRelation gGearbox = new PartRelation(piGearbox, gSump);

		return gGearbox;
	}

	/**
	 * Generate generic example.
	 *
	 * @param piTop the pi top
	 * @param vin   the vin
	 * @return the bom
	 */
	private BOM generateGenericExample(PartInfo piTop, String vin) {

		final BOM bom = new BOM();

		if (this.isHybrid) {
			log.info("Create Hybrid vehicle" + " '" + this.vehicleType + "'");

			final PartRelation gbr = generateGearbox(piTop);

			final PartRelation hvs = generateHVS(piTop, DEFAULT_COUNT_HVB_MODULE);

			final PartRelation pr = new PartRelation(piTop, gbr, hvs);

			bom.setTopLevelRelation(pr);
		} else if (this.isElectric) {
			log.info("Create Electric vehicle" + " '" + this.vehicleType + "'");
			final PartRelation hvs = generateHVS(piTop, DEFAULT_COUNT_HVB_MODULE);

			final PartRelation pr = new PartRelation(piTop, hvs);

			bom.setTopLevelRelation(pr);
		} else {
			log.info("Create Classic vehicle" + " '" + this.vehicleType + "'");
			final PartRelation gbr = generateGearbox(piTop);

			final PartRelation pr = new PartRelation(piTop, gbr);

			bom.setTopLevelRelation(pr);
		}

		return bom;
	}

	/**
	 * Generate HVB cell.
	 *
	 * @param piTop the pi top
	 * @return the part relation
	 */
	private PartRelation generateHVBCell(PartInfo piTop) {
		final PartInfo piHVC = PartSampleData.createHVBCell(piTop);

		final PartRelation hvc = new PartRelation(piHVC);

		return hvc;
	}

	/**
	 * Generate HVB module.
	 *
	 * @param piTop     the pi top
	 * @param cellCount the cell count
	 * @return the part relation
	 */
	private PartRelation generateHVBModule(PartInfo piTop, int cellCount) {
		final PartInfo piHVM = PartSampleData.createHVBModule(piTop);

		final List<PartRelation> cells = new ArrayList<>();
		for (int i = 0; i < cellCount; i++) {
			cells.add(generateHVBCell(piHVM));
		}

		final PartRelation hvm = new PartRelation(piHVM, cells);
		return hvm;
	}

	/**
	 * Generate HVS.
	 *
	 * @param piTop       the pi top
	 * @param moduleCount the module count
	 * @return the part relation
	 */
	private PartRelation generateHVS(PartInfo piTop, int moduleCount) {
		final PartInfo piHVS = PartSampleData.createHVS(piTop);

		final List<PartRelation> modules = new ArrayList<>();
		for (int i = 0; i < moduleCount; i++) {
			modules.add(generateHVBModule(piHVS, DEFAULT_COUNT_HVB_CELL));
		}

		final PartRelation hvs = new PartRelation(piHVS, modules);

		return hvs;
	}

	/**
	 * Generate vehicle.
	 *
	 * @param vin the vin
	 * @return the bom
	 */
	@Override
	public BOM generateVehicle(String vin) {
		if (this.vehicleType.toUpperCase().startsWith("I")) {
			this.isElectric = true;
		} else if ("G31".equals(vehicleType.toUpperCase())) {
			this.isHybrid = true;
		}

		final PartInfo piTop = PartSampleData.generatePartInfo(this.bpn, vin, PartType.VEHICLE.toString());

		return generateGenericExample(piTop, vin);
	}

}
