package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.constant.NavigationConstants;

/**
 * Homepage controller
 * 
 * @author David García Prados
 *
 */
@Controller
public class HomeController {

	/**
	 * Loads homepage
	 * 
	 * @return String view
	 */
	@GetMapping(value = { NavigationConstants.ROOT_URL })
	public String home() {
		return NavigationConstants.HOME;
	}

}
