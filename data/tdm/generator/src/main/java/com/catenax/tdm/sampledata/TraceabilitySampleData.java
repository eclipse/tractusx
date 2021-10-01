/*
 *
 */
package com.catenax.tdm.sampledata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.OffsetDateTime;

import com.catenax.tdm.BOM;
import com.catenax.tdm.TestDataFactory;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.PartMapping;
import com.catenax.tdm.model.v1.Traceability;
import com.catenax.tdm.resource.TDMResourceLoader;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class TraceabilitySampleData.
 */
public class TraceabilitySampleData {

	/** The Constant LENGTH_SERIAL_NO. */
	private static final int LENGTH_SERIAL_NO = 64;

	/** The Constant TRACEABILITY_TEMPLATE_NAME. */
	public static final String TRACEABILITY_TEMPLATE_NAME = "testdata/traceability/Template.json";

	/** The template. */
	private static String TEMPLATE = null;

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(TraceabilitySampleData.class);

	/** The traceability static data. */
	public static boolean TRACEABILITY_STATIC_DATA = true;

	/** The traceability unique data. */
	public static boolean TRACEABILITY_UNIQUE_DATA = true;

	/** The traceability individual data. */
	public static boolean TRACEABILITY_INDIVIDUAL_DATA = true;

	/** The traceability supplier tree. */
	public static boolean TRACEABILITY_SUPPLIER_TREE = true;

	/** The traceability part tree. */
	public static boolean TRACEABILITY_PART_TREE = true;

	/** The traceability quality alert. */
	public static boolean TRACEABILITY_QUALITY_ALERT = true;

	/** The allow child duplicates. */
	private static boolean ALLOW_CHILD_DUPLICATES = false;

	/** The Constant PART_MAPPING. */
	private static final Map<String, PartMapping> PART_MAPPING = new HashMap<>();

	/**
	 * From part info.
	 *
	 * @param partInfo the part info
	 * @param parent   the parent
	 * @param parentT  the parent T
	 * @return the traceability
	 * @throws Exception the exception
	 */
	public static Traceability fromPartInfo(PartInfo partInfo, PartInfo parent, Traceability parentT) throws Exception {
		if (TEMPLATE == null) {
			final String resourceName = TRACEABILITY_TEMPLATE_NAME;
			TEMPLATE = TDMResourceLoader.resourceToString(resourceName);
		}

		String template = TEMPLATE;

		final String uniqueSerialNo = TestDataFactory.getInstance().getRandomChars(LENGTH_SERIAL_NO);
		final String uniqueSerialNoManufacturer = TestDataFactory.getInstance().getRandomChars(LENGTH_SERIAL_NO);
		final String uniqueSerialNoCustomer = TestDataFactory.getInstance().getRandomChars(LENGTH_SERIAL_NO);

		final Map<String, String> values = new HashMap<>();
		values.put("bpnManufacturer", partInfo.getPart().getOneIDManufacturer());
		values.put("bpnManufacturerContract",
				BusinessPartnerSampleData.resolveTopLevelBPN(partInfo.getPart().getOneIDManufacturer()));
		values.put("partNumberManufacturer", partInfo.getPart().getObjectIDManufacturer());
		values.put("partNameManufacturer", resolvePartNameManufacturer(partInfo.getPart().getObjectIDManufacturer()));
		values.put("partNumberCustomer",
				resolvePartNumberCustomerMapping(partInfo.getPart().getObjectIDManufacturer()));
		values.put("partNameCustomer", resolvePartNameCustomerMapping(partInfo.getPart().getObjectIDManufacturer()));

		final PartMapping mapping = getPartMapping(partInfo.getPart().getObjectIDManufacturer());
		if (mapping != null) {
			values.put("country1", mapping.getCountry1());
			values.put("country2", mapping.getCountry2());
		} else {
			values.put("country1", "DE");
			values.put("country2", "GER");
		}

		if (parent != null) {
			values.put("bpnCustomerContract",
					BusinessPartnerSampleData.resolveTopLevelBPN(parent.getPart().getOneIDManufacturer()));
			values.put("bpnCustomer", parent.getPart().getOneIDManufacturer());
		} else {
			values.put("bpnCustomerContract", "");
			values.put("bpnCustomer", "");
		}

		for (final String key : values.keySet()) {
			final String val = values.get(key);
			template = template.replaceAll("@" + key + "@", val);
		}

		final ObjectMapper om = new ObjectMapper();
		final Traceability t = om.readValue(template, Traceability.class);
		t.getIndividualData().setProductionDateGMT(OffsetDateTime.now());

		t.getUniqueData().setCustomerUniqueID(uniqueSerialNoCustomer);
		t.getUniqueData().setManufacturerUniqueID(uniqueSerialNoManufacturer);
		t.getUniqueData().setUniqueID(uniqueSerialNo);

		if (!"vehicle".equals(partInfo.getPartTypeName().toLowerCase())) {
			partInfo.getPart().setObjectIDManufacturer(uniqueSerialNo);
		}

		return t;
	}

	/**
	 * Gets the part mapping.
	 *
	 * @param key the key
	 * @return the part mapping
	 */
	public static PartMapping getPartMapping(String key) {
		if (PART_MAPPING.containsKey(key)) {
			return PART_MAPPING.get(key);
		}
		return null;
	}

	/**
	 * Resolve part name customer mapping.
	 *
	 * @param key the key
	 * @return the string
	 */
	public static String resolvePartNameCustomerMapping(String key) {
		String result = key;
		if (PART_MAPPING.containsKey(key)) {
			result = PART_MAPPING.get(key).getPartNameCustomer();
		}
		if (result == null) {
			result = key;
		}
		return result;
	}

	/**
	 * Resolve part name manufacturer.
	 *
	 * @param key the key
	 * @return the string
	 */
	public static String resolvePartNameManufacturer(String key) {
		String result = key;
		if (PART_MAPPING.containsKey(key)) {
			result = PART_MAPPING.get(key).getPartNameManufacturer();
		}
		if (result == null) {
			result = key;
		}
		return result;
	}

	/**
	 * Resolve part number customer mapping.
	 *
	 * @param key the key
	 * @return the string
	 */
	public static String resolvePartNumberCustomerMapping(String key) {
		String result = key;
		if (PART_MAPPING.containsKey(key)) {
			result = PART_MAPPING.get(key).getPartNumberCustomer();
		}
		if (result == null) {
			result = key;
		}
		return result;
	}

	/**
	 * Resolve part relation.
	 *
	 * @param rel the rel
	 * @return the list
	 */
	public static List<Traceability> resolvePartRelation(BOM.PartRelation rel) {
		return resolvePartRelation(rel, null, null);
	}

	/**
	 * Resolve part relation.
	 *
	 * @param rel     the rel
	 * @param parent  the parent
	 * @param parentT the parent T
	 * @return the list
	 */
	public static List<Traceability> resolvePartRelation(BOM.PartRelation rel, PartInfo parent, Traceability parentT) {
		final List<Traceability> resultSet = new ArrayList<>();

		try {
			if (rel != null) {
				final Traceability t = fromPartInfo(rel.getParent(), parent, parentT);
				resultSet.add(t);

				if (rel.getChildren() != null) {
					for (final BOM.PartRelation child : rel.getChildren()) {
						final String sc = child.getParent().getPart().getObjectIDManufacturer();

						if (ALLOW_CHILD_DUPLICATES || !t.getSupplierTree().getIsParentOf().contains(sc)) {
							t.getSupplierTree().getIsParentOf().add(sc);
						}

						final List<Traceability> children = resolvePartRelation(child, rel.getParent(), t);
						resultSet.addAll(children);

						final String pc = children.get(0).getUniqueData().getUniqueID();

						if (ALLOW_CHILD_DUPLICATES || !t.getPartTree().getIsParentOf().contains(pc)) {
							t.getPartTree().getIsParentOf().add(pc);
						}
					}
				}
			}
		} catch (final Exception e) {
			log.error(e.getMessage());
		}

		return resultSet;
	}

	/**
	 * Sets the part mapping.
	 *
	 * @param mappings the new part mapping
	 */
	public static void setPartMapping(List<PartMapping> mappings) {
		PART_MAPPING.clear();
		for (final PartMapping pm : mappings) {
			PART_MAPPING.put(pm.getPartNumberManufacturer(), pm);
		}
	}

}
