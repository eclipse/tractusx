package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartRelationshipUpdate;

@Repository
@Transactional 
public class PartRelationshipUpdateDao extends GenericJpaDao<PartRelationshipUpdate> {

	public PartRelationshipUpdateDao() {
		super.setClazz(PartRelationshipUpdate.class);
	}
}
