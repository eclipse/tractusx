/*
 *
 */
package com.catenax.tdm.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractJpaDao.
 *
 * @param <T> the generic type
 */
public abstract class AbstractJpaDao<T extends Serializable> {

	/** The clazz. */
	private Class<T> clazz;

	/** The entity manager. */
	@PersistenceContext(unitName = "entityManagerFactory")
	protected EntityManager entityManager;

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T create(final T entity) {
		entityManager.persist(entity);
		return entity;
	}

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(final T entity) {
		entityManager.remove(entity);
	}

	/**
	 * Delete by id.
	 *
	 * @param entityId the entity id
	 */
	public void deleteById(final long entityId) {
		final T entity = findOne(entityId);
		delete(entity);
	}

	/*
	 * @SuppressWarnings("unchecked") public List<T> findAll(Specification<T> spec)
	 * { String query = "from " + this.clazz.getName(); return
	 * entityManager.createQuery(query).getResultList(); }
	 */

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		final String query = "from " + this.clazz.getName();
		return entityManager.createQuery(query).getResultList();
	}

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T findOne(final long id) {
		return entityManager.find(clazz, id);
	}

	/**
	 * Sets the clazz.
	 *
	 * @param clazzToSet the new clazz
	 */
	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T update(final T entity) {
		return entityManager.merge(entity);
	}
}