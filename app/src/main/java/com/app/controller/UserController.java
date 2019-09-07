package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.constant.CoreConstants;
import com.app.constant.NavigationConstants;
import com.app.model.dto.UserDto;
import com.app.model.form.UserForm;
import com.app.service.UserService;
import com.app.service.generic.DozerMappingService;

/**
 * Users controller
 * 
 * @author David García Prados
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DozerMappingService dozerMappingService;

	private final Logger logger = LogManager.getLogger();

	/**
	 * Loads users page
	 * 
	 * @param model
	 * @param request
	 * @return String view
	 */
	@GetMapping(NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.LIST)
	public String userList(HttpServletRequest request) {
		String view;
		// Only allow admin to enter in
		if (!request.isUserInRole(CoreConstants.ROLE_ADMIN)) {
			throw new SecurityException();
		}

		try {
			view = NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.LIST;
		} catch (Exception ex) {
			logger.error(ex);
			view = NavigationConstants.REDIRECT_TO + NavigationConstants.ERROR;
		}
		return view;
	}

	/**
	 * Load user detail
	 * 
	 * @param userForm
	 * @param id
	 * @param model
	 * @param request
	 * @return String view
	 */
	@GetMapping(NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.DETAIL)
	public String userDetail(UserForm userForm, @RequestParam(required = false) Long id, Model model,
			HttpServletRequest request) {
		String view;
		// Only allow admin to enter in
		if (!request.isUserInRole(CoreConstants.ROLE_ADMIN)) {
			throw new SecurityException();
		}

		try {
			UserDto userDetail = userService.getUserById(id, false);
			if (userDetail == null) {
				logger.error("User not found!");
				view = NavigationConstants.REDIRECT_TO + "/" + NavigationConstants.DETAIL;
			} else {
				model.addAttribute("userForm", dozerMappingService.mapOne(userDetail, UserForm.class));
				view = NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.DETAIL;
			}

		} catch (Exception ex) {
			logger.error(ex);
			view = NavigationConstants.REDIRECT_TO + NavigationConstants.ERROR;

		}
		return view;
	}

	/**
	 * Save user (new and edit scenarios)
	 * 
	 * @param userForm
	 * @param bindingResult
	 * @param request
	 * @param redirectAttributes
	 * @return String view
	 */
	@PostMapping(NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.DETAIL)
	public String userDetailSave(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult,
			HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		String view;
		// Only allow admin to enter in
		if (!request.isUserInRole(CoreConstants.ROLE_ADMIN)) {
			throw new SecurityException();
		}
		try {
			userService.validateUserForm(userForm, bindingResult);

			if (bindingResult.hasErrors()) {
				view = NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.DETAIL;
			} else {
				UserDto result = userService.saveUser(userForm);
				view = NavigationConstants.REDIRECT_TO + NavigationConstants.DETAIL + "?id=" + result.getUsrId();
				redirectAttributes.addFlashAttribute("success", true);
			}
		} catch (Exception ex) {
			logger.error(ex);
			view = NavigationConstants.REDIRECT_TO + NavigationConstants.ERROR;
		}
		return view;
	}

	/**
	 * Delete user
	 * 
	 * @param id
	 * @param request
	 */

	@PostMapping(NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.DELETE)
	@ResponseBody
	public void deleteUser(@RequestParam(required = true) Long id, HttpServletRequest request) {
		// Only allow admin to enter in
		if (!request.isUserInRole(CoreConstants.ROLE_ADMIN)) {
			throw new SecurityException();
		}

		try {
			userService.fakeDeleteUser(id);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	@PostMapping(path = NavigationConstants.USER_BASE_PATH + "/" + NavigationConstants.LIST + "/"
			+ NavigationConstants.TABLE)
	@ResponseBody
	public List<UserDto> getAllUsers() {

		List<UserDto> result = null;
		try {
			result = userService.getAllUsers(false);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return result;
	}
}
