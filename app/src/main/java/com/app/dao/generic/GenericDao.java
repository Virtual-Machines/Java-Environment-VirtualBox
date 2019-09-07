package com.app.dao.generic;

import java.io.Serializable;
import java.util.List;

/**
 * Interface of Generic DAO
 * 
 * @author David García Prados
 *
 * @param <T>
 */
public interface GenericDao<T extends Serializable> {

	/**
	 * Find one element by id
	 * 
	 * @param id
	 * @param includeFakeDeleted
	 * @return T
	 */
	T findOne(final long id, final boolean includeFakeDeleted);

	/**
	 * Find all elements of Entity
	 * 
	 * @param includeFakeDeleted
	 * 
	 * @return List<T>
	 */
	List<T> findAll(final boolean includeFakeDeleted);

	/**
	 * Merges the entity
	 * 
	 * @param entity
	 * @return T
	 */
	T merge(final T entity);

	/**
	 * "Deletes" the entity (using deleted attribute)
	 * 
	 * @param entity
	 */
	void fakeDelete(final T entity);

	/**
	 * "Deletes" the entity by Id (using deleted attribute)
	 * 
	 * @param entityId
	 */
	void fakeDeleteById(final long entityId);

	/**
	 * Deletes the entity
	 * 
	 * @param entity
	 */
	void delete(final T entity);

	/**
	 * Deletes the entity by Id
	 * 
	 * @param entityId
	 */
	void deleteById(final long entityId);
}