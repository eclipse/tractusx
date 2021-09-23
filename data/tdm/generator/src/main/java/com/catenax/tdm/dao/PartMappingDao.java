package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartMapping;

@Repository
@Transactional 
public class PartMappingDao extends GenericJpaDao<PartMapping> {

	public PartMappingDao() {
		super.setClazz(PartMapping.class);
	}
}
