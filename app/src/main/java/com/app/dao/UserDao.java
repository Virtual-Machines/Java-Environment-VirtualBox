package com.app.dao;

import com.app.dao.generic.GenericDao;
import com.app.model.entity.UserEntity;

/**
 * User DAO (Data Access Object) interface
 * 
 * @author David García Prados
 *
 */
public interface UserDao extends GenericDao<UserEntity> {

	/**
	 * Find User by username
	 * 
	 * @param username
	 * @param includeFakeDeleted
	 * @return User
	 */
	UserEntity findByUsername(String username, final boolean includeFakeDeleted);
}
