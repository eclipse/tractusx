package com.catenax.tdm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.catenax.tdm.model.v1.AspectMapping;

public interface AspectMappingDao extends CrudRepository<AspectMapping, Long>, JpaSpecificationExecutor<AspectMapping> {
	
	public List<AspectMapping> findAllByParentBpn(String bpn);

}
