/*
 *
 */
package com.catenax.tdm.dao;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGenericDao.
 *
 * @param <T> the generic type
 */
public interface IGenericDao<T extends Serializable> {

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	T create(final T entity);

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	void delete(final T entity);

	/**
	 * Delete by id.
	 *
	 * @param entityId the entity id
	 */
	void deleteById(final long entityId);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<T> findAll();

	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the t
	 */
	T findOne(final long id);

	/**
	 * Sets the clazz.
	 *
	 * @param clazzToSet the new clazz
	 */
	void setClazz(Class<T> clazzToSet);

	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	T update(final T entity);
}