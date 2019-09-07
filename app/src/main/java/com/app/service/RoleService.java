package com.app.service;

import com.app.model.dto.RoleDto;
import com.app.model.entity.RoleEntity;

/**
 * Service of Role
 * 
 * @author David García Prados
 */

public interface RoleService {

	/**
	 * Get role by code
	 * 
	 * @param code
	 * @param includeFakeDeleted
	 * @return RoleDto
	 */
	RoleDto getRoleByCode(String code, final boolean includeFakeDeleted);

	/**
	 * Get role entity by code
	 * 
	 * @param code
	 * @param includeFakeDeleted
	 * @return RoleEntity
	 */
	RoleEntity getRoleEntityByCode(String code, final boolean includeFakeDeleted);

}