package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.model.v1.Material;
import com.catenax.tdm.model.v1.MaterialCharacteristic;

public class MaterialAspectHandler implements AspectHandler<Material> {

	@Override
	public List<Material> retrieveAspect(String oneID, String partUniqueID) {
		List<Material> list = new ArrayList<Material>();
		
		Material mat = new Material();
		
		MaterialCharacteristic material = new MaterialCharacteristic();
		
		
		
		mat.setMaterialDetails(material);
		
		list.add(mat);

		return list;
	}

}