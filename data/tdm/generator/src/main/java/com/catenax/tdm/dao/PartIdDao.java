package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartId;

@Repository
@Transactional 
public class PartIdDao extends GenericJpaDao<PartId> {
	
	public PartIdDao() {
		super.setClazz(PartId.class);
	}

}
