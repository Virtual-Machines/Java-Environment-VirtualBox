package com.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring MVC Initializer
 * 
 * @author David García Prados
 *
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Load Application Configuration and Spring security Configuration
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, WebSecurityConfig.class };
	}

	/**
	 * Load Web Configuration
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	/**
	 * Map all inside the root path
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
