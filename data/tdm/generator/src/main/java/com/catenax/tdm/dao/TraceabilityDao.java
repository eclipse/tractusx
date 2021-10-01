/*
 *
 */
package com.catenax.tdm.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.Traceability;

// TODO: Auto-generated Javadoc
/**
 * The Class TraceabilityDao.
 */
@Repository
@Transactional
public class TraceabilityDao extends AbstractJpaDao<Traceability> implements IGenericDao<Traceability> {

	/**
	 * Instantiates a new traceability dao.
	 */
	public TraceabilityDao() {
		super.setClazz(Traceability.class);
	}

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return the traceability
	 */
	@Override
	public Traceability create(Traceability entity) {
		if (entity.getStaticData() != null) {
			entityManager.persist(entity.getStaticData());
		}
		if (entity.getUniqueData() != null) {
			entityManager.persist(entity.getUniqueData());
		}
		if (entity.getIndividualData() != null) {
			entityManager.persist(entity.getIndividualData());
		}
		if (entity.getPartTree() != null) {
			entityManager.persist(entity.getPartTree());
		}
		if (entity.getSupplierTree() != null) {
			entityManager.persist(entity.getSupplierTree());
		}
		if (entity.getQualityAlertData() != null) {
			entityManager.persist(entity.getQualityAlertData());
		}
		return super.create(entity);
	}

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	@Override
	public void delete(Traceability entity) {
		super.delete(entity);
		if (entity.getStaticData() != null) {
			entityManager.remove(entity.getStaticData());
		}
		if (entity.getUniqueData() != null) {
			entityManager.remove(entity.getUniqueData());
		}
		if (entity.getIndividualData() != null) {
			entityManager.remove(entity.getIndividualData());
		}
		if (entity.getPartTree() != null) {
			entityManager.remove(entity.getPartTree());
		}
		if (entity.getSupplierTree() != null) {
			entityManager.remove(entity.getSupplierTree());
		}
		if (entity.getQualityAlertData() != null) {
			entityManager.remove(entity.getQualityAlertData());
		}
	}
	
	public List<Traceability> findByBpn(String bpn) {
		Query query = entityManager.createQuery("SELECT from " + Traceability.class.getName() + " WHERE ");
		return query.getResultList();
	}

}
