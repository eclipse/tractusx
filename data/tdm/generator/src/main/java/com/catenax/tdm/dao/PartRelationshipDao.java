package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartRelationship;

@Repository
@Transactional 
public class PartRelationshipDao extends GenericJpaDao<PartRelationship> {

	public PartRelationshipDao() {
		super.setClazz(PartRelationship.class);
	}
}
