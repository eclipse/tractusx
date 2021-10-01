/*
 *
 */
package com.catenax.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catenax.tdm.model.v1.AspectMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class QueueDao.
 */
@Repository
@Transactional
public class QueueDao {

	/** The entity manager. */
	@PersistenceContext(unitName = "entityManagerFactory")
	protected EntityManager entityManager;

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return the object
	 */
	public Object create(final Object entity) {
		entityManager.persist(entity);
		return entity;
	}

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(final Object entity) {
		entityManager.remove(entity);
	}

	/**
	 * Delete all.
	 *
	 * @param clazz the clazz
	 */
	public void deleteAll(final Class clazz) {
		/*
		for (final Object o : this.findAll(clazz)) {
			this.delete(o);
		}
		*/

		Query q = entityManager.createQuery("DELETE from " + clazz.getName());
		q.executeUpdate();
	}

	/**
	 * Delete by id.
	 *
	 * @param clazz    the clazz
	 * @param entityId the entity id
	 */
	public void deleteById(final Class clazz, final long entityId) {
		final Object entity = findOne(clazz, entityId);
		delete(entity);
	}

	/**
	 * Find all.
	 *
	 * @param clazz the clazz
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Object> findAll(final Class clazz) {
		final String query = "from " + clazz.getName();
		return entityManager.createQuery(query).getResultList();
	}

	/**
	 * Find one.
	 *
	 * @param clazz the clazz
	 * @param id    the id
	 * @return the object
	 */
	public Object findOne(final Class clazz, final long id) {
		return entityManager.find(clazz, id);
	}

	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return the object
	 */
	public Object update(final Object entity) {
		return entityManager.merge(entity);
	}
	
	public void flush() {
		entityManager.flush();
	}

}
