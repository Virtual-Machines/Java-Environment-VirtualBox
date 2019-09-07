package com.app.constant;

/**
 * Constants with website URLs and JSP views
 * 
 * @author David García Prados
 *
 */

public class NavigationConstants {

	/* Root URL and redirect */
	public static final String ROOT_URL = "/";
	public static final String REDIRECT_TO = "redirect:";

	// datatable, list, detail and delete url parts
	public static final String TABLE = "table";
	public static final String LIST = "list";
	public static final String DETAIL = "detail";
	public static final String DELETE = "delete";

	/* General pages: error, login, logout and locale */
	public static final String ERROR = "error";
	public static final String JAVASCRIPT_ERROR = "javascripterror";
	public static final String LOGIN = "login";
	public static final String LOGOUT = "logout";
	public static final String LOGIN_ACTION = "loginAction";
	public static final String LOGIN_PAGE_AFTER_LOGOUT = LOGIN + "?" + LOGOUT;
	public static final String LOCALE = "locale";
	public static final String LOCALE_LANG_CODE_PATH_VARIABLE = "{langCode}";
	public static final String LOCALE_EN = LOCALE + "/en";
	public static final String LOCALE_ES = LOCALE + "/es";

	/* Patterns used in resources mappings and Spring Security rules */
	public static final String LOGIN_PATTERN = ROOT_URL + LOGIN + "**";
	public static final String JAVASCRIPT_ERROR_PATTERN = ROOT_URL + JAVASCRIPT_ERROR + "/**";
	public static final String RESOURCES_PATTERN = ROOT_URL + "resources/**";
	public static final String LOCALE_PATTERN = ROOT_URL + LOCALE + "/**";
	public static final String JAVA_MELODY_MONITORING_PATTERN = ROOT_URL + "monitoring/**";

	/* All other pages */
	public static final String HOME = "home";
	public static final String USER_BASE_PATH = "user";

	/* Getters used to be accessible from JSP with useBean in head.jsp */

	public String getRootUrl() {
		return ROOT_URL;
	}

	public String getRedirectTo() {
		return REDIRECT_TO;
	}


	public String getList() {
		return LIST;
	}
	
	public String getTable() {
		return TABLE;
	}

	public String getDetail() {
		return DETAIL;
	}

	public String getDelete() {
		return DELETE;
	}

	public String getError() {
		return ERROR;
	}

	public String getJavascriptError() {
		return JAVASCRIPT_ERROR;
	}

	public String getLogin() {
		return LOGIN;
	}

	public String getLoginPattern() {
		return LOGIN_PATTERN;
	}

	public String getResourcesPattern() {
		return RESOURCES_PATTERN;
	}

	public String getLocalePattern() {
		return LOCALE_PATTERN;
	}

	public String getJavaMelodyMonitoringPattern() {
		return JAVA_MELODY_MONITORING_PATTERN;
	}

	public String getLoginAction() {
		return LOGIN_ACTION;
	}

	public String getLoginPageAfterLogout() {
		return LOGIN_PAGE_AFTER_LOGOUT;
	}

	public String getLogout() {
		return LOGOUT;
	}

	public String getLocale() {
		return LOCALE;
	}

	public String getLocaleEn() {
		return LOCALE_EN;
	}

	public String getLocaleEs() {
		return LOCALE_ES;
	}

	public String getLocaleLangCodePathVariable() {
		return LOCALE_LANG_CODE_PATH_VARIABLE;
	}

	public String getHome() {
		return HOME;
	}

	public String getUserBasePath() {
		return USER_BASE_PATH;
	}

}
