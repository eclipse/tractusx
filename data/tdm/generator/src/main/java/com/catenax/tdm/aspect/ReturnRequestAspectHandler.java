package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.ReturnRequest;

public class ReturnRequestAspectHandler implements AspectHandler<ReturnRequest> {

	@Override
	public List<ReturnRequest> retrieveAspect(String oneID, String partUniqueID) {
		List<ReturnRequest> list = new ArrayList<ReturnRequest>();
		
		ReturnRequest result = new ReturnRequest();
		
		list.add(result);

		return list;
	}

}