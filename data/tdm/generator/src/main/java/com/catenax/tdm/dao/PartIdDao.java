/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartId;

// TODO: Auto-generated Javadoc
/**
 * The Class PartIdDao.
 */
@Repository
@Transactional
public class PartIdDao extends GenericJpaDao<PartId> {

	/**
	 * Instantiates a new part id dao.
	 */
	public PartIdDao() {
		super.setClazz(PartId.class);
	}

}
