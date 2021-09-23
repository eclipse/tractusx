package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.MemberCompany;

@Repository
@Transactional 
public class MemberCompanyDao extends AbstractJpaDao<MemberCompany> implements IGenericDao<MemberCompany> {

	public MemberCompanyDao() {
		super.setClazz(MemberCompany.class);
	}

}
