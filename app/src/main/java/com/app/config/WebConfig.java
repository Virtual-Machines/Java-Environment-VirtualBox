package com.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import com.app.constant.CoreConstants;
import com.app.constant.NavigationConstants;

/**
 * Spring MVC Configuration: JSP view resolver, login inline controller and
 * resource handlers
 * 
 * @author David García Prados
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { CoreConstants.PACKAGE_CONTROLLER })
public class WebConfig implements WebMvcConfigurer {
	/**
	 * Resolve jsp search prepending "/WEB-INF/views/" path and adding .jsp suffix
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix("/" + CoreConstants.VIEWS_PATH).suffix(CoreConstants.JSP_EXTENSION);
	}

	/**
	 * Inline special controller mapping for login url to login.jsp
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(NavigationConstants.LOGIN).setViewName(NavigationConstants.LOGIN);
	}

	/**
	 * Map all css,js,img,fonts, etc. from resources folder. Cache of 1 year and use
	 * version strategy with hash to detect changes. Needed a
	 * resourceUrlEncodingFilter in web.xml
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/" + CoreConstants.RESOURCES_PATH + "**")
				.addResourceLocations("/" + CoreConstants.RESOURCES_PATH)
				.setCachePeriod(CoreConstants.CACHE_ONE_YEAR_IN_SECONDS).resourceChain(false)
				.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
	}
}
