package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.RoleDao;
import com.app.model.dto.RoleDto;
import com.app.model.entity.RoleEntity;
import com.app.service.generic.DozerMappingService;

/**
 * Implements RoleService for application Dao
 * 
 * @author David García Prados
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private DozerMappingService dozerMappingService;

	@Override
	public RoleDto getRoleByCode(String code, boolean includeFakeDeleted) {
		RoleEntity entity = getRoleEntityByCode(code, includeFakeDeleted);
		return entity == null ? null : dozerMappingService.mapOne(entity, RoleDto.class);
	}

	@Override
	public RoleEntity getRoleEntityByCode(String code, boolean includeFakeDeleted) {
		return roleDao.findByCode(code, includeFakeDeleted);
	}

}
