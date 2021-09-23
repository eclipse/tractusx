package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartAspectUpdate;

@Repository
@Transactional 
public class AspectUpdateDao extends GenericJpaDao<PartAspectUpdate> {
	
	public AspectUpdateDao() {
		super.setClazz(PartAspectUpdate.class);
	}

}
