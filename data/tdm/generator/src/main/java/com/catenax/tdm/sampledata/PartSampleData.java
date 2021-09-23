package com.catenax.tdm.sampledata;

import com.catenax.tdm.PartType;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.PartInfo;

public class PartSampleData {

	public static PartInfo createHVS(PartInfo parent) {
		PartInfo pi = generatePartInfo(
				BusinessPartnerSampleData.BPN_BMWDGF, 
				"2412117", 
				PartType.HVS.toString());
		
		return pi;
	}
	
	public static PartInfo createHVBModule(PartInfo parent) {
		PartInfo pi = generatePartInfo(
				BusinessPartnerSampleData.BPN_BMWDGF, 
				"6127713", 
				PartType.HVB_MODULE.toString());
		
		return pi;
	}
	
	public static PartInfo createHVBCell(PartInfo parent) {
		PartInfo pi = generatePartInfo(
				BusinessPartnerSampleData.BPN_BMWLPZ, 
				"6127714", 
				PartType.HVB_CELL.toString());
		
		return pi;
	}
	
	public static PartInfo createGearbox(PartInfo paren) {
		PartInfo pi = generatePartInfo(BusinessPartnerSampleData.BPN_ZF,
				"8HP51XB47O1", PartType.GEARBOX.toString());
		
		return pi;
	}
	
	public static PartInfo generatePartInfo(String oneIDManufacturer, String objectIDManufacturer, String partTypeName) {
		PartInfo partInfo = new PartInfo();

		PartId partId = new PartId();
		partId.setOneIDManufacturer(oneIDManufacturer);
		partId.setObjectIDManufacturer(objectIDManufacturer);

		partInfo.setPart(partId);
		partInfo.partTypeName(partTypeName);

		return partInfo;
	}

}
