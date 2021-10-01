/*
 *
 */
package com.catenax.tdm.aspect;

import java.util.ArrayList;
import java.util.List;

import com.catenax.tdm.dao.QueueDao;
import com.catenax.tdm.model.v1.AspectMapping;
import com.catenax.tdm.model.v1.PartId;
import com.catenax.tdm.model.v1.ReturnRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class ReturnRequestAspectHandler.
 */
public class ReturnRequestAspectHandler implements AspectHandler<ReturnRequest> {

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
	public Class<ReturnRequest> getMainEntityClass() {
		return ReturnRequest.class;
	}

	/**
	 * Retrieve aspect.
	 *
	 * @param part the part
	 * @param dao  the dao
	 * @return the list
	 */
	@Override
	public List<ReturnRequest> retrieveAspect(PartId part, QueueDao dao) {
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
	public List<ReturnRequest> retrieveAspect(String oneID, String partUniqueID, QueueDao dao) {
		final List<ReturnRequest> list = new ArrayList<>();

		final String bpn = oneID.trim();
		final String serialNo = partUniqueID.trim();

		final List<Object> mappings = dao.findAll(AspectMapping.class);
		for (final Object o : mappings) {
			final AspectMapping mapping = (AspectMapping) o;
			if (AspectFactory.matchKey(bpn, mapping.getPart().getOneIDManufacturer(), serialNo,
					mapping.getPart().getObjectIDManufacturer())) {
				list.addAll(mapping.getReturnRequest());
			}
		}

		return list;
	}

}