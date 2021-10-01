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
import com.catenax.tdm.TestDataGenerator;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.sampledata.Blueprint.BlueprintItem;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleSampleData.
 */
public class VehicleSampleData {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(VehicleSampleData.class);

	/**
	 * Blueprint item to part info.
	 *
	 * @param bpi the bpi
	 * @return the part info
	 */
	private static PartInfo blueprintItemToPartInfo(BlueprintItem bpi) {
		final PartInfo pi = new PartInfo();
		final PartId pid = new PartId();

		pid.setOneIDManufacturer(bpi.getBpn());
		pid.setObjectIDManufacturer(bpi.getPartNumber());

		pi.setPart(pid);
		pi.setPartTypeName(bpi.getPartType());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Blueprint item to part realation.
	 *
	 * @param bpi the bpi
	 * @return the part relation
	 */
	private static PartRelation blueprintItemToPartRealation(BlueprintItem bpi) {
		final PartInfo pi = blueprintItemToPartInfo(bpi);
		final List<PartRelation> children = new ArrayList<>();

		for (final BlueprintItem child : bpi.getChildren()) {
			for (int i = 0; i < child.getCount(); i++) {
				children.add(blueprintItemToPartRealation(child));
			}
		}

		final PartRelation result = new PartRelation(pi, children);
		return result;
	}

	/**
	 * Blueprint to part realation.
	 *
	 * @param bp the bp
	 * @return the part relation
	 */
	private static PartRelation blueprintToPartRealation(Blueprint bp) {
		return blueprintItemToPartRealation(bp.getParent());
	}

	/**
	 * Generate vehicle.
	 *
	 * @param bp the bp
	 * @return the bom
	 */
	public static BOM generateVehicle(Blueprint bp) {

		final String bpn = bp.getParent().getBpn();
		final String vehicleType = bp.getParent().getPartNumber();
		final String vin = TestDataGenerator.genVIN("");

		log.info("Create vehicle for '" + bpn + "' of Type: '" + vehicleType + "'");
		final BOM vehicle = new BOM(blueprintToPartRealation(bp));

		final PartInfo piTemplate = PartSampleData.generatePartInfo(bpn, vehicleType, bp.getParent().getPartType());
		final AspectSampleData aspectData = new AspectSampleData(piTemplate, vehicle.getTopLevelRelation().getParent());

		vehicle.getTopLevelRelation().getParent().getPart().setObjectIDManufacturer(vin);

		log.info("Vehicle with vin '" + vin + "' successfully created");
		return vehicle;
	}

	/**
	 * Gets the part name customer from part number.
	 *
	 * @param partNumber the part number
	 * @return the part name customer from part number
	 */
	public static String getPartNameCustomerFromPartNumber(String partNumber) {
		return TraceabilitySampleData.resolvePartNameCustomerMapping(partNumber);
	}

	/**
	 * Gets the part name manufacturer from part number.
	 *
	 * @param partNumber the part number
	 * @return the part name manufacturer from part number
	 */
	public static String getPartNameManufacturerFromPartNumber(String partNumber) {
		return TraceabilitySampleData.resolvePartNameManufacturer(partNumber);
	}

	/**
	 * Gets the part number customer from part number.
	 *
	 * @param partNumber the part number
	 * @return the part number customer from part number
	 */
	public static String getPartNumberCustomerFromPartNumber(String partNumber) {
		return TraceabilitySampleData.resolvePartNumberCustomerMapping(partNumber);
	}

}
