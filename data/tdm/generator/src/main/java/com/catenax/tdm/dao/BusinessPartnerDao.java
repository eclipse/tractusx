/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.BusinessPartner;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessPartnerDao.
 */
@Repository
@Transactional
public class BusinessPartnerDao extends AbstractJpaDao<BusinessPartner> implements IGenericDao<BusinessPartner> {

	/**
	 * Instantiates a new business partner dao.
	 */
	public BusinessPartnerDao() {
		super.setClazz(BusinessPartner.class);
	}

}
