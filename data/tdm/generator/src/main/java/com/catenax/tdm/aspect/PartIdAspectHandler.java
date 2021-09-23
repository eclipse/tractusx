package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.PartId;

public class PartIdAspectHandler implements AspectHandler<PartId> {

	@Override
	public List<PartId> retrieveAspect(String oneID, String partUniqueID) {
		List<PartId> list = new ArrayList<PartId>();
		
		PartId partId = new PartId();
		partId.setOneIDManufacturer(oneID);
		partId.setObjectIDManufacturer(partUniqueID);
		partId.setObjectIDManufacturer(partUniqueID);
		
		return list;
	}

}
