/*
 *
 */
package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.dao.QueueDao;
import com.catenax.tdm.model.v1.PartId;

// TODO: Auto-generated Javadoc
/**
 * The Class PartIdAspectHandler.
 */
public class PartIdAspectHandler implements AspectHandler<PartId> {

	/**
	 * Creates the aspect.
	 *
	 * @param part the part
	 */
	@Override
	public void createAspect(PartId part) {
		// Nothing to do for this aspect (assumption: already persisted in createVehicle
		// method)
	}

	/**
	 * Gets the main entity class.
	 *
	 * @return the main entity class
	 */
	@Override
	public Class<PartId> getMainEntityClass() {
		return PartId.class;
	}

	/**
	 * Retrieve aspect.
	 *
	 * @param part the part
	 * @param dao  the dao
	 * @return the list
	 */
	@Override
	public List<PartId> retrieveAspect(PartId part, QueueDao dao) {
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
	public List<PartId> retrieveAspect(String oneID, String partUniqueID, QueueDao dao) {
		final List<PartId> list = new ArrayList<>();

		final PartId partId = new PartId();
		partId.setOneIDManufacturer(oneID);
		partId.setObjectIDManufacturer(partUniqueID);

		return list;
	}

}
