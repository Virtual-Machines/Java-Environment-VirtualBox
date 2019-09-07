package com.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.generic.GenericHibernateDaoImpl;
import com.app.model.dto.RoleDto;
import com.app.model.entity.RoleEntity;

/**
 * Role DAO (Data Access Object) implementation
 * 
 * @author David García Prados
 *
 */
@Repository
@Transactional
public class RoleDaoImpl extends GenericHibernateDaoImpl<RoleEntity> implements RoleDao {

	/**
	 * Set class of Dao that extends of Generic
	 */
	public RoleDaoImpl() {
		setClazz(RoleEntity.class);
	}

	@Override
	public RoleEntity findByCode(String code, boolean includeFakeDeleted) {
		RoleEntity result = getCurrentSession().byNaturalId(RoleEntity.class).using(RoleDto.ROL_CODE_FIELD, code)
				.getReference();

		if (!includeFakeDeleted && result != null && result.getDeleted()) {
			result = null;
		}

		return result;
	}
}
