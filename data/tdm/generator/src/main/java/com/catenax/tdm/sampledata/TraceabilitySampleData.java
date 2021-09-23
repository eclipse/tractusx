package com.catenax.tdm.sampledata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.threeten.bp.LocalDate;

import com.catenax.tdm.BOM;
import com.catenax.tdm.TestDataFactory;
import com.catenax.tdm.model.v1.IsParentOfCharacteristic;
import com.catenax.tdm.model.v1.PartIndividualDataCharacteristic;
import com.catenax.tdm.model.v1.PartInfo;
import com.catenax.tdm.model.v1.PartMapping;
import com.catenax.tdm.model.v1.PartStaticDataCharacteristic;
import com.catenax.tdm.model.v1.PartTreeParentCharacteristic;
import com.catenax.tdm.model.v1.PartUniqueDataCharacteristic;
import com.catenax.tdm.model.v1.QualityAlertDataCharacteristic;
import com.catenax.tdm.model.v1.QualityTypeEnum;
import com.catenax.tdm.model.v1.Traceability;

public class TraceabilitySampleData {

	public static boolean TRACEABILITY_STATIC_DATA = true;
	public static boolean TRACEABILITY_UNIQUE_DATA = true;
	public static boolean TRACEABILITY_INDIVIDUAL_DATA = true;
	public static boolean TRACEABILITY_SUPPLIER_TREE = true;
	public static boolean TRACEABILITY_PART_TREE = true;
	public static boolean TRACEABILITY_QUALITY_ALERT = true;

	private static final Map<String, PartMapping> PART_MAPPING = new HashMap<String, PartMapping>();
	
	public static void setPartMapping(List<PartMapping> mappings) {
		PART_MAPPING.clear();
		for(PartMapping pm : mappings) {
			PART_MAPPING.put(pm.getPartNumberManufacturer(), pm);
		}
	}
	
	public static String resolvePartNameManufacturer(String key) {
		String result = key;
		if(PART_MAPPING.containsKey(key)) {
			result = PART_MAPPING.get(key).getPartNameManufacturer();
		}
		if(result == null) {
			result = key;
		}
		return result;
	}
	
	public static String resolvePartNameCustomerMapping(String key) {
		String result = key;
		if(PART_MAPPING.containsKey(key)) {
			result = PART_MAPPING.get(key).getPartNameCustomer();
		}
		if(result == null) {
			result = key;
		}
		return result;
	}
	
	public static String resolvePartNumberCustomerMapping(String key) {
		String result = key;
		if(PART_MAPPING.containsKey(key)) {
			result = PART_MAPPING.get(key).getPartNumberCustomer();
		}
		if(result == null) {
			result = key;
		}
		return result;
	}

	public static List<Traceability> resolvePartRelation(BOM.PartRelation rel) {
		return resolvePartRelation(rel, null, null);
	}

	public static List<Traceability> resolvePartRelation(BOM.PartRelation rel, PartInfo parent, Traceability parentT) {
		List<Traceability> resultSet = new ArrayList<Traceability>();
		if (rel != null) {
			Traceability t = fromPartInfo(rel.getParent(), parent, parentT);
			if (rel.getChildren() != null) {
				for (BOM.PartRelation child : rel.getChildren()) {
					// Set parent relation
					// String pc = child.getParent().getPart().getObjectIDManufacturer();
					// String sc = child.getParent().getPart().getOneIDManufacturer();		
					
					String pc = child.getParent().getPart().getObjectIDManufacturer();
					String sc = child.getParent().getPart().getOneIDManufacturer();	
					
					t.getPartTree().getIsParentOf().add(pc);
					t.getSupplierTree().getIsParentOf().add(sc);
				}
			}
			resultSet.add(t);

			if (rel.getChildren() != null) {
				for (BOM.PartRelation child : rel.getChildren()) {
					resultSet.addAll(resolvePartRelation(child, rel.getParent(), t));
				}
			}
		}
		return resultSet;
	}
	
	public static Traceability genTraceability(String tenantId) {
		// return PartRelationshipSampleData.generatePRSSampleData(oneIDManufacturer, objectIDManufacturer, aspect, depth);
		throw new RuntimeException("Method not supported");
	}

	public static Traceability generateRandTraceability(String tenantId) {
		Traceability t = new Traceability();

		if (TRACEABILITY_STATIC_DATA) {
			PartStaticDataCharacteristic staticData = new PartStaticDataCharacteristic();
			t.setStaticData(staticData);
		}

		if (TRACEABILITY_UNIQUE_DATA) {
			PartUniqueDataCharacteristic uniqueData = new PartUniqueDataCharacteristic();
			t.setUniqueData(uniqueData);
		}

		if (TRACEABILITY_INDIVIDUAL_DATA) {
			PartIndividualDataCharacteristic individualData = new PartIndividualDataCharacteristic();
			t.setIndividualData(individualData);
		}

		if (TRACEABILITY_SUPPLIER_TREE) {
			PartTreeParentCharacteristic supplierTree = new PartTreeParentCharacteristic();
			IsParentOfCharacteristic isParentOf = new IsParentOfCharacteristic();
			supplierTree.setIsParentOf(isParentOf);
			t.setSupplierTree(supplierTree);
		}

		if (TRACEABILITY_PART_TREE) {
			PartTreeParentCharacteristic partTree = new PartTreeParentCharacteristic();
			IsParentOfCharacteristic isParentOf = new IsParentOfCharacteristic();
			partTree.setIsParentOf(isParentOf);
			t.setPartTree(partTree);
		}

		if (TRACEABILITY_QUALITY_ALERT) {
			QualityAlertDataCharacteristic alert = new QualityAlertDataCharacteristic();
			alert.setQualityAlert(false);
			alert.setQualityType(QualityTypeEnum.MINOR);
			t.setQualityAlertData(alert);
		}

		return t;
	}

	public static Traceability fromPartInfo(PartInfo partInfo, PartInfo parent, Traceability parentT) {
		Traceability t = generateRandTraceability("");
		
		String uniqueSerialNo = TestDataFactory.getInstance().getRandomChars(64);

		t.getStaticData().setManufacturerOneID(partInfo.getPart().getOneIDManufacturer());
		t.getStaticData().setManufactureContractOneID(BusinessPartnerSampleData.resolveTopLevelBPN(partInfo.getPart().getOneIDManufacturer()));

		t.getStaticData().setPartNumberManufacturer(partInfo.getPart().getObjectIDManufacturer());
		t.getStaticData().setPartNameManufacturer(resolvePartNameManufacturer(partInfo.getPart().getObjectIDManufacturer()));

		t.getStaticData().setPartNameCustomer("");
		t.getStaticData().setPartNumberCustomer("");
		
		t.getStaticData().setCustomerOneID("");
		t.getStaticData().setCustomerContractOneID("");

		t.getUniqueData().setCustomerUniqueID(uniqueSerialNo);
		t.getUniqueData().setManufacturerUniqueID(uniqueSerialNo);
		t.getUniqueData().setUniqueID(uniqueSerialNo);

		t.getIndividualData().setProductionCountryCode("DE");
		t.getIndividualData().setProductionDateGMT(LocalDate.now());

		// t.getQualityAlertData().setQualityAlert(false);
		// t.getQualityAlertData().setQualityType(null);

		if (parent != null) {
			t.getStaticData().setCustomerOneID(parent.getPart().getOneIDManufacturer());
			t.getStaticData().setCustomerContractOneID(BusinessPartnerSampleData.resolveTopLevelBPN(parent.getPart().getOneIDManufacturer()));
			
			t.getStaticData().setPartNumberCustomer(resolvePartNumberCustomerMapping(partInfo.getPart().getObjectIDManufacturer()));
			t.getStaticData().setPartNameCustomer(resolvePartNameCustomerMapping(partInfo.getPart().getObjectIDManufacturer()));
		}

		if (parentT != null) {
			// t.getUniqueData().setCustomerUniqueID(parentT.getUniqueData().getManufacturerUniqueID());
		}
		
		partInfo.getPart().setObjectIDManufacturer(uniqueSerialNo);

		return t;
	}

}
