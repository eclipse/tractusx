/*
 *
 */
package com.catenax.tdm.aspect;

import java.util.List;

import com.catenax.tdm.dao.QueueDao;
import com.catenax.tdm.model.v1.PartId;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectHandler.
 *
 * @param <T> the generic type
 */
public interface AspectHandler<T> {

	/**
	 * Creates the aspect.
	 *
	 * @param part the part
	 */
	public void createAspect(PartId part);

	/**
	 * Gets the main entity class.
	 *
	 * @return the main entity class
	 */
	public Class<T> getMainEntityClass();

	/**
	 * Retrieve aspect.
	 *
	 * @param part the part
	 * @param dao  the dao
	 * @return the list
	 */
	public List<T> retrieveAspect(PartId part, QueueDao dao);

	/**
	 * Retrieve aspect.
	 *
	 * @param bpn          the bpn
	 * @param partUniqueID the part unique ID
	 * @param dao          the dao
	 * @return the list
	 */
	public List<T> retrieveAspect(String bpn, String partUniqueID, QueueDao dao);

}
