package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.constant.CoreConstants;
import com.app.constant.NavigationConstants;

/**
 * Controls and logs errors of web app
 * 
 * @author David García Prados
 *
 */
@Controller
public class ErrorController {

	private final Logger logger = LogManager.getLogger();

	/**
	 * Loads error page. Mapping used in <error-page> of web.xml
	 * 
	 * @param httpRequest
	 * @return String view
	 */
	@GetMapping(NavigationConstants.ERROR)
	public String renderErrorPage(HttpServletRequest httpRequest) {
		try {
			Integer errorCode = getErrorCode(httpRequest);
			String errorUrl = getErrorUrl(httpRequest);
			if (errorCode != null && errorUrl != null) {
				logger.error("HTTP ERROR: " + errorCode + " - URL: " + errorUrl);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return NavigationConstants.ERROR;
	}

	/**
	 * Logs Javascript error
	 * 
	 * @param message
	 */
	@PostMapping(NavigationConstants.JAVASCRIPT_ERROR)
	@ResponseBody
	public void logClientJavascriptError(@RequestParam(required = true) String message) {
		try {
			logger.error(message);

		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	/**
	 * Private method that gets HTTP Error code from HttpServletRequest
	 * 
	 * @param httpRequest
	 * @return int errorCode
	 */
	private Integer getErrorCode(HttpServletRequest httpRequest) {
		Object result = httpRequest.getAttribute(CoreConstants.REQUEST_ATTRIBUTE_ERROR_STATUS_CODE);
		return result == null ? null : (Integer) result;
	}

	/**
	 * Private method that gets url that caused the error from HttpServletRequest
	 * 
	 * @param httpRequest
	 * @return String errorUrl
	 */
	private String getErrorUrl(HttpServletRequest httpRequest) {
		Object result = httpRequest.getAttribute(CoreConstants.REQUEST_ATTRIBUTE_REQUEST_URI);
		return result == null ? null : (String) result;
	}
}