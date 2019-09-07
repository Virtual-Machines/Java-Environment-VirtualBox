package com.app.dao;

import com.app.dao.generic.GenericDao;
import com.app.model.entity.RoleEntity;

/**
 * Role DAO (Data Access Object) interface
 * 
 * @author David García Prados
 *
 */
public interface RoleDao extends GenericDao<RoleEntity> {
	/**
	 * Find Role by code
	 * 
	 * @param code
	 * @param includeFakeDeleted
	 * @return RoleEntity
	 */
	RoleEntity findByCode(String code, final boolean includeFakeDeleted);
}
