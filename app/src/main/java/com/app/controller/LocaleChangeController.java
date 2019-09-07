package com.app.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.LocaleResolver;

import com.app.constant.CoreConstants;
import com.app.constant.NavigationConstants;

/**
 * Controller of locale change
 * 
 * @author David García Prados
 *
 */
@Controller
public class LocaleChangeController {

	@Autowired
	private LocaleResolver localeResolver;

	private final Logger logger = LogManager.getLogger();

	/**
	 * Change locale to specified by langCode and redirect to previous page with the
	 * new locale
	 * 
	 * @param langCode
	 * @param request
	 * @param response
	 * @return String
	 */
	@GetMapping(NavigationConstants.LOCALE + "/" + NavigationConstants.LOCALE_LANG_CODE_PATH_VARIABLE)
	public String localeChange(@PathVariable String langCode, HttpServletRequest request,
			HttpServletResponse response) {
		String view;
		try {
			localeResolver.setLocale(request, response, new Locale(langCode));
			view = NavigationConstants.REDIRECT_TO + request.getHeader(CoreConstants.REQUEST_HEADER_REFERER);
		} catch (Exception ex) {
			logger.error(ex);
			view = NavigationConstants.REDIRECT_TO + NavigationConstants.ERROR;
		}
		return view;
	}
}
