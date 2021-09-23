package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.ProductDescription;

public class ProductDescriptionAspectHandler implements AspectHandler<ProductDescription> {

	@Override
	public List<ProductDescription> retrieveAspect(String oneID, String partUniqueID) {
		List<ProductDescription> list = new ArrayList<ProductDescription>();
		
		ProductDescription result = new ProductDescription();
		
		list.add(result);

		return list;
	}

}