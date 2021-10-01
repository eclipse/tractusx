/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.Aspect;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectDao.
 */
@Repository
@Transactional
public class AspectDao extends GenericJpaDao<Aspect> {

	/**
	 * Instantiates a new aspect dao.
	 */
	public AspectDao() {
		super.setClazz(Aspect.class);
	}

}
