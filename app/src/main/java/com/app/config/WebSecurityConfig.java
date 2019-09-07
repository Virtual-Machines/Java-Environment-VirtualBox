package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.constant.CoreConstants;
import com.app.constant.NavigationConstants;

/**
 * Configure Spring Security
 * 
 * @author David García Prados
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Service with User details for Authentication
	@Autowired
	private UserDetailsService useDetailsService;

	/**
	 * Bean used to encode password
	 * 
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Configure authentication with password encoder
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(useDetailsService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Configure Spring Security routes
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// Permit all: resources, locale, error and login urls
				.antMatchers(NavigationConstants.LOGIN_PATTERN, NavigationConstants.RESOURCES_PATTERN,
						NavigationConstants.LOCALE_PATTERN, NavigationConstants.JAVASCRIPT_ERROR_PATTERN)
				.permitAll()
				// Permit only to admin: Java Melody monitoring urls
				.antMatchers(NavigationConstants.JAVA_MELODY_MONITORING_PATTERN).hasAnyRole(CoreConstants.ROLE_ADMIN)
				// Require authentication in all other pages
				.anyRequest().authenticated()
				// Definition of login page, login process url and logout success
				.and().formLogin().loginPage(NavigationConstants.ROOT_URL + NavigationConstants.LOGIN)
				.loginProcessingUrl(NavigationConstants.ROOT_URL + NavigationConstants.LOGIN_ACTION).permitAll().and()
				.logout().logoutSuccessUrl(NavigationConstants.ROOT_URL + NavigationConstants.LOGIN_PAGE_AFTER_LOGOUT)
				.permitAll();
	}
}
