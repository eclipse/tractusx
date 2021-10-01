/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartAspectUpdate;

/**
 * The Interface PartAspectUpdateDao.
 */
@Repository
@Transactional
public interface PartAspectUpdateDao
		extends CrudRepository<PartAspectUpdate, Long>, JpaSpecificationExecutor<PartAspectUpdate> {

}
