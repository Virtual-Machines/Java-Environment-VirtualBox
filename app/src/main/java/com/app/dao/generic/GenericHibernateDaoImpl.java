package com.app.dao.generic;

import org.springframework.stereotype.Repository;

import com.app.model.entity.generic.GenericEntity;

/**
 * Generic Dao Implementation and extends AbstractHibernateDao
 * 
 * @author David García Prados
 *
 * @param <T>
 */
@Repository
public class GenericHibernateDaoImpl<T extends GenericEntity> extends AbstractHibernateDao<T> implements GenericDao<T> {
}