package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.app.constant.CoreConstants;
import com.app.constant.MessageConstants;
import com.app.dao.UserDao;
import com.app.model.dto.UserDto;
import com.app.model.entity.AuthorityEntity;
import com.app.model.entity.RoleEntity;
import com.app.model.entity.UserEntity;
import com.app.model.form.UserForm;
import com.app.service.generic.DozerMappingService;
import com.app.service.generic.MessageService;

/**
 * Implements UserService for application Dao
 * 
 * @author David García Prados
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private DozerMappingService dozerMappingService;

	@Autowired
	private MessageService messageService;

	@Override
	public List<UserDto> getAllUsers(boolean includeFakeDeleted) {
		return dozerMappingService.mapList(userDao.findAll(includeFakeDeleted), UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id, boolean includeFakeDeleted) {
		UserDto result;
		if (id == null) {
			result = new UserDto();
		} else {
			UserEntity entity = userDao.findOne(id, includeFakeDeleted);
			result = entity == null ? null : dozerMappingService.mapOne(entity, UserDto.class);
		}
		return result;
	}

	@Override
	public UserDto getUserByUsername(String username, boolean includeFakeDeleted) {
		UserEntity entity = userDao.findByUsername(username, includeFakeDeleted);
		return entity == null ? null : dozerMappingService.mapOne(entity, UserDto.class);
	}

	@Override
	public UserDto saveUser(UserForm userForm) {
		UserEntity userEntity;
		// New
		if (userForm.getUsrId() == null) {
			userEntity = new UserEntity(userForm.getUsrEnabled(), passwordEncoder.encode(userForm.getUsrPassword()),
					userForm.getUsrUsername());
			RoleEntity roleEntity = roleService.getRoleEntityByCode(CoreConstants.ROLE_USER, false);

			userEntity.addAuthority(new AuthorityEntity(roleEntity, userEntity));

			// Edit
		} else {
			userEntity = userDao.findOne(userForm.getUsrId(), true);
			userEntity.setUsrEnabled(userForm.getUsrEnabled());
		}

		userEntity = userDao.merge(userEntity);

		return dozerMappingService.mapOne(userEntity, UserDto.class);
	}

	@Override
	public void fakeDeleteUser(Long id) {
		userDao.fakeDeleteById(id);
	}

	@Override
	public void validateUserForm(UserForm userForm, BindingResult bindingResult) {
		if (userForm.getUsrId() == null && getUserByUsername(userForm.getUsrUsername(), true) != null) {
			bindingResult.rejectValue(UserDto.USR_USERNAME_FIELD, "username-exists",
					messageService.getMessage(MessageConstants.USERDETAIL_ERROR_USERNAME_EXISTS));
		}
	}

}
