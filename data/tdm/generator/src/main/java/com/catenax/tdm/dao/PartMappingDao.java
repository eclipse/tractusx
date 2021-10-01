/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class PartMappingDao.
 */
@Repository
@Transactional
public class PartMappingDao extends GenericJpaDao<PartMapping> {

	/**
	 * Instantiates a new part mapping dao.
	 */
	public PartMappingDao() {
		super.setClazz(PartMapping.class);
	}
}
