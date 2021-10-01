/*
 *
 */
package com.catenax.tdm.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.PartRelationshipUpdate;

/**
 * The Interface PartRelationshipUpdateDao.
 */
@Repository
@Transactional
public interface PartRelationshipUpdateDao
		extends CrudRepository<PartRelationshipUpdate, Long>, JpaSpecificationExecutor<PartRelationshipUpdate> {

}
