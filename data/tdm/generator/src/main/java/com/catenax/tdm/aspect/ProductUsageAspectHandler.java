package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.ProductUsage;

public class ProductUsageAspectHandler implements AspectHandler<ProductUsage> {

	@Override
	public List<ProductUsage> retrieveAspect(String oneID, String partUniqueID) {
		List<ProductUsage> list = new ArrayList<ProductUsage>();
		
		ProductUsage result = new ProductUsage();
		
		list.add(result);

		return list;
	}

}