package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.dao.QueueDao;
import com.catenax.tdm.model.v1.AspectMapping;
import com.catenax.tdm.model.v1.PartId;

public class AspectMappingHandler implements AspectHandler<AspectMapping> {

	@Override
	public void createAspect(PartId pPart) {
		throw new RuntimeException("Method not supported!");
	}

	@Override
	public Class<AspectMapping> getMainEntityClass() {
		return AspectMapping.class;
	}
	
	@Override
	public List<AspectMapping> retrieveAspect(PartId pPart, QueueDao pDao) {
		return retrieveAspect(pPart.getOneIDManufacturer(), pPart.getObjectIDManufacturer(), pDao);
	}

	@Override
	public List<AspectMapping> retrieveAspect(String pBpn, String pPartUniqueID, QueueDao pDao) {
		List<AspectMapping> list = new ArrayList<AspectMapping>();

		final String bpn = pBpn.trim();
		final String serialNo = pPartUniqueID.trim();

		final List<Object> mappings = pDao.findAll(AspectMapping.class);
		for (final Object o : mappings) {
			final AspectMapping mapping = (AspectMapping) o;
			if (AspectFactory.matchKey(bpn, mapping.getPart().getOneIDManufacturer(), serialNo,
					mapping.getPart().getObjectIDManufacturer())
				|| bpn.equals(mapping.getParentBpn())) {
				list.add(mapping);
			}
		}
		

		return list;
	}

}
