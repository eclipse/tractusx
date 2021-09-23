package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartTypeNameUpdate;

@Repository
@Transactional 
public class PartTypeNameUpdateDao extends GenericJpaDao<PartTypeNameUpdate> {

	public PartTypeNameUpdateDao() {
		super.setClazz(PartTypeNameUpdate.class);
	}
}
