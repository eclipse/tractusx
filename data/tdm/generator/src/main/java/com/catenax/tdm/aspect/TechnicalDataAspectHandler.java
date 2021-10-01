/*
 *
 */
package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.dao.QueueDao;
import com.catenax.tdm.model.v1.AspectMapping;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.TechnicalData;

// TODO: Auto-generated Javadoc
/**
 * The Class TechnicalDataAspectHandler.
 */
public class TechnicalDataAspectHandler implements AspectHandler<TechnicalData> {

	/**
	 * Creates the aspect.
	 *
	 * @param part the part
	 */
	@Override
	public void createAspect(PartId part) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the main entity class.
	 *
	 * @return the main entity class
	 */
	@Override
	public Class<TechnicalData> getMainEntityClass() {
		return TechnicalData.class;
	}

	/**
	 * Retrieve aspect.
	 *
	 * @param part the part
	 * @param dao  the dao
	 * @return the list
	 */
	@Override
	public List<TechnicalData> retrieveAspect(PartId part, QueueDao dao) {
		return retrieveAspect(part.getOneIDManufacturer(), part.getObjectIDManufacturer(), dao);
	}

	/**
	 * Retrieve aspect.
	 *
	 * @param oneID        the one ID
	 * @param partUniqueID the part unique ID
	 * @param dao          the dao
	 * @return the list
	 */
	@Override
	public List<TechnicalData> retrieveAspect(String oneID, String partUniqueID, QueueDao dao) {
		final List<TechnicalData> list = new ArrayList<>();

		final String bpn = oneID.trim();
		final String serialNo = partUniqueID.trim();

		final List<Object> mappings = dao.findAll(AspectMapping.class);
		for (final Object o : mappings) {
			final AspectMapping mapping = (AspectMapping) o;
			if (AspectFactory.matchKey(bpn, mapping.getPart().getOneIDManufacturer(), serialNo,
					mapping.getPart().getObjectIDManufacturer())) {
				list.addAll(mapping.getTechnicalData());
			}
		}

		return list;
	}

}