/*
 *
 */
package com.catenax.tdm.sampledata;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.catenax.tdm.PartType;
import com.catenax.tdm.TestDataGenerator;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.resource.TDMResourceLoader;

// TODO: Auto-generated Javadoc
/**
 * The Class PartSampleData.
 */
public class PartSampleData {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(PartSampleData.class);

	/** The Constant PART_NO_GEARBOX_8HP_1. */
	private static final String PART_NO_GEARBOX_8HP_1 = "8HP51XB47O1";

	/** The Constant PART_NO_HVS_1. */
	private static final String PART_NO_HVS_1 = "2412117";

	/** The Constant PART_NO_HVS_2. */
	private static final String PART_NO_HVS_2 = "8849262-01";

	/** The Constant PART_NO_HVB_MODULE_1. */
	private static final String PART_NO_HVB_MODULE_1 = "6127713";

	/** The Constant PART_NO_HVB_MODULE_2. */
	private static final String PART_NO_HVB_MODULE_2 = "8840841-04";

	/** The Constant PART_NO_HVB_CELL_1. */
	private static final String PART_NO_HVB_CELL_1 = "8844604-01";

	/** The Constant PART_NO_SUMP_1. */
	private static final String PART_NO_SUMP_1 = "501294308";

	/**
	 * Creates the adhesive.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createAdhesive(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_HENKEL,
				TestDataGenerator.genString("HE", 17).toUpperCase(), PartType.ADHESIVE.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Creates the gearbox.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createGearbox(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_ZFSBR, PART_NO_GEARBOX_8HP_1,
				PartType.GEARBOX.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Creates the HVB cell.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createHVBCell(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_SAMSUNG, PART_NO_HVB_CELL_1,
				PartType.HVB_CELL.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Creates the HVB module.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createHVBModule(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_BMWDGF, PART_NO_HVB_MODULE_2,
				PartType.HVB_MODULE.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Creates the HVS.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createHVS(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_BMWDGF, PART_NO_HVS_2,
				PartType.HVS.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Creates the material.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createMaterial(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_BASF, "12324", PartType.MATERIAL.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Creates the sump.
	 *
	 * @param parent the parent
	 * @return the part info
	 */
	public static PartInfo createSump(PartInfo parent) {
		final PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_ZFSBR, PART_NO_SUMP_1,
				PartType.SUMP.toString());

		final AspectSampleData aspectData = new AspectSampleData(pi);

		return pi;
	}

	/**
	 * Generate part info.
	 *
	 * @param oneIDManufacturer    the one ID manufacturer
	 * @param objectIDManufacturer the object ID manufacturer
	 * @param partTypeName         the part type name
	 * @return the part info
	 */
	public static PartInfo generatePartInfo(String oneIDManufacturer, String objectIDManufacturer,
			String partTypeName) {
		final PartInfo partInfo = new PartInfo();

		final PartId partId = new PartId();
		partId.setOneIDManufacturer(oneIDManufacturer);
		partId.setObjectIDManufacturer(objectIDManufacturer);

		partInfo.setPart(partId);
		partInfo.partTypeName(partTypeName);

		return partInfo;
	}

	// ---

	/**
	 * Resolve resource.
	 *
	 * @param partInfo the part info
	 * @param aspect   the aspect
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String resolveResource(PartInfo partInfo, String aspect) throws IOException {
		String result = "";

		final String resourceName = "testdata/aspects/" + aspect.toLowerCase() + "_"
				+ partInfo.getPart().getOneIDManufacturer() + "_" + partInfo.getPart().getObjectIDManufacturer()
				+ ".json";

		try {
			result = TDMResourceLoader.resourceToString(resourceName);
		} catch (final IOException e) {
			// log.debug("No Template found: " + resourceName);
			throw e;
		}

		return result;
	}

	/**
	 * Resolve resource.
	 *
	 * @param partInfo     the part info
	 * @param aspect       the aspect
	 * @param replacements the replacements
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String resolveResource(PartInfo partInfo, String aspect, Map<String, String> replacements)
			throws IOException {
		String result = resolveResource(partInfo, aspect);

		if (replacements != null) {
			for (final String key : replacements.keySet()) {
				final String val = replacements.get(key);
				result = result.replaceAll("@" + key + "@", val);
			}
		}

		return result;
	}

}
