/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartRelationship;

// TODO: Auto-generated Javadoc
/**
 * The Class PartRelationshipDao.
 */
@Repository
@Transactional
public class PartRelationshipDao extends GenericJpaDao<PartRelationship> {

	/**
	 * Instantiates a new part relationship dao.
	 */
	public PartRelationshipDao() {
		super.setClazz(PartRelationship.class);
	}
}
