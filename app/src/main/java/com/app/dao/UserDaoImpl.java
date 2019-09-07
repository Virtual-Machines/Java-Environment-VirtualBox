package com.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.generic.GenericHibernateDaoImpl;
import com.app.model.dto.UserDto;
import com.app.model.entity.UserEntity;

/**
 * User DAO (Data Access Object) implementation
 * 
 * @author David García Prados
 *
 */
@Repository
@Transactional
public class UserDaoImpl extends GenericHibernateDaoImpl<UserEntity> implements UserDao {

	/**
	 * Set class of Dao that extends of Generic
	 */
	public UserDaoImpl() {
		setClazz(UserEntity.class);
	}

	/**
	 * Find user by naturalId username
	 */
	@Override
	public UserEntity findByUsername(String username, boolean includeFakeDeleted) {
		UserEntity result = getCurrentSession().byNaturalId(UserEntity.class)
				.using(UserDto.USR_USERNAME_FIELD, username).getReference();

		if (!includeFakeDeleted && result != null && result.getDeleted()) {
			result = null;
		}

		return result;
	}

}
