package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.TechnicalData;

public class TechnicalDataAspectHandler implements AspectHandler<TechnicalData> {

	@Override
	public List<TechnicalData> retrieveAspect(String oneID, String partUniqueID) {
		List<TechnicalData> list = new ArrayList<TechnicalData>();
		
		TechnicalData result = new TechnicalData();

		list.add(result);
		
		return list;
	}

}