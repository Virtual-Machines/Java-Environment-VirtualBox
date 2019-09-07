package com.app.dao.generic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.entity.generic.GenericEntity;

/**
 * Abstract Hibernate DAO
 * 
 * @author David García Prados
 *
 * @param <T>
 */
public abstract class AbstractHibernateDao<T extends GenericEntity> {
	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Sets the model Entity class to DAO
	 * 
	 * @param clazzToSet
	 */
	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/**
	 * Find one element by id
	 * 
	 * @param id
	 * @param includeFakeDeleted
	 * @return T
	 */
	public T findOne(long id, boolean includeFakeDeleted) {
		T result = clazz.cast(getCurrentSession().get(clazz, id));

		// If fakedeleted are not included and result found is fakedeleted return null
		if (!includeFakeDeleted && result != null && result.getDeleted()) {
			result = null;
		}

		return result;
	}

	/**
	 * Find all elements of Entity
	 * 
	 * @param includeFakeDeleted
	 * @return List<T>
	 */
	public List<T> findAll(boolean includeFakeDeleted) {
		return getCurrentSession().createQuery("from " + clazz.getName()
				+ (includeFakeDeleted ? "" : " where " + GenericEntity.DELETED_FIELD + " = false"), clazz).list();

	}

	/**
	 * Merges the entity
	 * 
	 * @param entity
	 * @return T
	 */
	public T merge(T entity) {
		return clazz.cast(getCurrentSession().merge(entity));
	}

	/**
	 * "Deletes" the entity (using deleted attribute)
	 * 
	 * @param entity
	 */
	public void fakeDelete(T entity) {
		entity.setDeleted(true);
		merge(entity);
	}

	/**
	 * "Deletes" the entity by Id (using deleted attribute)
	 * 
	 * @param entityId
	 */
	public void fakeDeleteById(long entityId) {
		T entity = findOne(entityId, false);
		fakeDelete(entity);
	}

	/**
	 * Deletes the entity
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	/**
	 * Deletes the entity by Id
	 * 
	 * @param entityId
	 */
	public void deleteById(long entityId) {
		T entity = findOne(entityId, true);
		delete(entity);
	}

	/**
	 * Gets the current database session
	 * 
	 * @return Session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}