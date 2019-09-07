<!-- Generic imports @author David García Prados -->

<!-- Encoding -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Taglibs -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- Use Java Constants in jsp -->
<jsp:useBean id="NavigationConstants"
	class="com.app.constant.NavigationConstants" scope="session" />
<jsp:useBean id="CoreConstants" class="com.app.constant.CoreConstants"
	scope="session" />

<!-- Variables -->
<c:url var="datatablesi18Spanish" scope="session"
	value="/resources/js/datables.i18.spanish.json" />
<c:set var="localeCode" scope="session"
	value="${fn:toUpperCase(pageContext.response.locale.language)}" />

<c:url var="urlJavascriptError" scope="session"
	value="/${NavigationConstants.javascriptError}" />

<!-- Metatags -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicon -->
<link rel="icon" href="<c:url value="/resources/img/favicon.ico"/>">

<!-- Jquery -->
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<!-- Font Awesome -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/font-awesome-all.min.css"/>">

<!-- DataTables -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/datatables.min.css"/>">
<script src="<c:url value="/resources/js/datatables.min.js"/>"></script>

<!-- Custom CSS and JS (keep these at end of file) -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app/app.css"/>">

<script>
	/*
	Script with basic data that retain and encapsulate Java information
	@author David García Prados
	 */

	//Add the CSRF token to all Ajax Calls
	$.ajaxSetup({
		beforeSend : function(xhr, settings) {
			xhr.setRequestHeader('X-CSRF-Token', '${_csrf.token}');
		}
	});

	//Navigation constants info
	function NavigationConstants() {
		this.LIST_URL = '${NavigationConstants.list}';
		this.TABLE_URL = '${NavigationConstants.table}';
		this.DETAIL_URL = '${NavigationConstants.detail}';
		this.DELETE_URL = '${NavigationConstants.delete}';
	};

	//Locale info
	function LocaleInfo() {
		this.LOCALE_CODE = '${localeCode}';
		this.LOCALE_FILE_DATATABLES = '${localeCode == "ES" ? datatablesi18Spanish : ""}';
	};

	//Function that logs errors to server
	function logToServer(ex) {
		$.ajax({
			type : 'POST',
			url : '${urlJavascriptError}',
			data : {
				message : ex + "\nstack: " + ex.stack + "\nlocation: "
						+ window.location.href + "\nuserAgent: "
						+ navigator.userAgent
			}
		});
	}
</script>