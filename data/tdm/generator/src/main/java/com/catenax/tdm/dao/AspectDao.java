package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.Aspect;

@Repository
@Transactional 
public class AspectDao extends GenericJpaDao<Aspect> {
	
	public AspectDao() {
		super.setClazz(Aspect.class);
	}

}
