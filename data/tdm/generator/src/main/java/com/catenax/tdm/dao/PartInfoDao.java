/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartInfo;

// TODO: Auto-generated Javadoc
/**
 * The Class PartInfoDao.
 */
@Repository
@Transactional
public class PartInfoDao extends GenericJpaDao<PartInfo> {

	/**
	 * Instantiates a new part info dao.
	 */
	public PartInfoDao() {
		super.setClazz(PartInfo.class);
	}

}
