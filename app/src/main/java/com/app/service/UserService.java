package com.app.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.app.model.dto.UserDto;
import com.app.model.form.UserForm;

/**
 * Service of User
 * 
 * @author David García Prados
 */

public interface UserService {

	/**
	 * Get all users
	 * 
	 * @param includeFakeDeleted
	 * @return List<UserDto>
	 */
	List<UserDto> getAllUsers(final boolean includeFakeDeleted);

	/**
	 * Get user by id
	 *
	 * @param id
	 * @param includeFakeDeleted
	 * @return UserDto
	 */
	UserDto getUserById(final Long id, final boolean includeFakeDeleted);

	/**
	 * Get user by username
	 * 
	 * @param username
	 * @param includeFakeDeleted
	 * @return User
	 */
	UserDto getUserByUsername(String username, final boolean includeFakeDeleted);

	/**
	 * Persists user
	 * @param userForm
	 * @return UserDto
	 */
	UserDto saveUser(UserForm userForm);

	/**
	 * "Delete" user
	 * 
	 * @param id
	 */
	void fakeDeleteUser(Long id);

	/**
	 * Validates user form and edits a binding result
	 * 
	 * @param userForm
	 * @param bindingResult
	 * @param locale
	 */
	void validateUserForm(UserForm userForm, BindingResult bindingResult);

}