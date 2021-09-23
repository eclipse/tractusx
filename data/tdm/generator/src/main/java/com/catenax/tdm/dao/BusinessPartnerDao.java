package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.BusinessPartner;

@Repository
@Transactional 
public class BusinessPartnerDao extends AbstractJpaDao<BusinessPartner> implements IGenericDao<BusinessPartner> {

	public BusinessPartnerDao() {
		super.setClazz(BusinessPartner.class);
	}

}
