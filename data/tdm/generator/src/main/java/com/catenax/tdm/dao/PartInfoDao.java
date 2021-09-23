package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartInfo;

@Repository
@Transactional 
public class PartInfoDao extends GenericJpaDao<PartInfo> {
	
	public PartInfoDao() {
		super.setClazz(PartInfo.class);
	}

}
