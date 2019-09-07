<!-- Bar with locale changer links and current one @author David García Prados-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<i class="fas fa-globe"></i>
<strong>${localeCode}</strong>
&nbsp;
<a href='<c:url value="/${NavigationConstants.localeEn}"/>'><fmt:message key="locale.EN" /></a>
&nbsp;
<a href='<c:url value="/${NavigationConstants.localeEs}"/>'><fmt:message key="locale.ES" /></a>