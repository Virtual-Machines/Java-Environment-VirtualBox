package com.app.constant;

/**
 * Constants with environments, roles, packages, configuration paths...
 * 
 * @author David García Prados
 *
 */
public class CoreConstants {

	// Error log constant
	public static final String ERROR_LOG = "ERROR:";
	
	// Constant for resources cache
	public static final int CACHE_ONE_YEAR_IN_SECONDS = 60 * 60 * 24 * 365;

	// Encoding constant
	public static final String UTF_8 = "UTF-8";

	/* Roles constants */
	public static final String PREFIX_OF_ROLE = "ROLE_";
	public static final String ROLE_USER = "USER";
	public static final String ROLE_ADMIN = "ADMIN";

	/* Environments constants */
	public static final String CURRENT_ENVIRONMENT = "${environment}";
	public static final String LOCAL_ENVIRONMENT = "local";
	public static final String DEV_ENVIRONMENT = "dev";
	public static final String PRE_ENVIRONMENT = "pre";
	public static final String PRO_ENVIRONMENT = "pro";

	/* Packages constants */
	public static final String PACKAGE_BASE_NAME = "com.app";
	public static final String PACKAGE_CONTROLLER = PACKAGE_BASE_NAME + ".controller";
	public static final String PACKAGE_SERVICE = PACKAGE_BASE_NAME + ".service";
	public static final String PACKAGE_DAO = PACKAGE_BASE_NAME + ".dao";
	public static final String PACKAGE_MODEL = PACKAGE_BASE_NAME + ".model";
	public static final String PACKAGE_UTIL = PACKAGE_BASE_NAME + ".util";

	/* Paths constants */
	public static final String CLASSPATH = "classpath:";
	public static final String ENVIRONMENT_PATH = CLASSPATH + CURRENT_ENVIRONMENT;
	public static final String APPLICATION_PROPERTIES_PATH = ENVIRONMENT_PATH + "/application.properties";
	public static final String MESSAGES_PATH = CLASSPATH + "messages/messages";
	public static final String VIEWS_PATH = "WEB-INF/views/";
	public static final String RESOURCES_PATH = "resources/";
	public static final String JSP_EXTENSION = ".jsp";

	/* Request constants */
	public static final String REQUEST_HEADER_REFERER = "referer";
	public static final String REQUEST_ATTRIBUTE_ERROR_STATUS_CODE = "javax.servlet.error.status_code";
	public static final String REQUEST_ATTRIBUTE_REQUEST_URI = "javax.servlet.forward.request_uri";

	/* Properties constants */

	// DB
	public static final String DB_DRIVER_CLASS = "db.driverClass";
	public static final String DB_JDBC_URL = "db.jdbcUrl";
	public static final String DB_USERNAME = "db.username";
	public static final String DB_PASS = "db.password";

	// Hibernate
	public static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String HIBERNATE_HBM_2_DDL_AUTO = "hibernate.hbm2ddl.auto";

	// Mail
	public static final String MAIL_USERNAME = "mail.username";
	public static final String MAIL_PASS = "mail.password";
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static final String MAIL_SMTP_HOST = "mail.smtp.host";
	public static final String MAIL_SMTP_FROM = "mail.smtp.from";
	public static final String MAIL_SMTP_SEND_PARTIAL = "mail.smtp.sendpartial";

	/* Getters */
	public String getRoleUser() {
		return ROLE_USER;
	}

	public String getRoleAdmin() {
		return ROLE_ADMIN;
	}
}
