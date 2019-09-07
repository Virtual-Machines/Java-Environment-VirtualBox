<!-- Login @author David García Prados -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/head.jsp" />
<title><fmt:message key="login.title" /></title>
</head>
<body>

	<div class="container">
		<p class="text-right">
			<jsp:include page="include/localeBar.jsp" />
		</p>

		<h1 class="text-center">
			<img src="<c:url value="/resources/img/logo.png"/>" />
			<fmt:message key="login.title" />
		</h1>

		<c:choose>
			<c:when test="${param.error!=null}">
				<div class="text-center alert alert-danger" data-dismiss="alert">
					<strong><fmt:message key="login.error" /></strong>
				</div>
			</c:when>
			<c:when test="${param.logout!=null}">
				<div class="text-center alert alert-success" data-dismiss="alert">
					<strong><fmt:message key="login.logoutSuccess" /></strong>
				</div>
			</c:when>
			<c:otherwise>
				<div class="text-center alert alert-secondary" data-dismiss="alert">
					<fmt:message key="login.info" />
				</div>
			</c:otherwise>
		</c:choose>

		<form action='<c:url value="/${NavigationConstants.loginAction}"/>'
			method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<p>
				<input class="form-control text-center" type="text" name="username"
					placeholder="<fmt:message key="login.username" />">
			</p>
			<p>
				<input class="form-control text-center" type="password"
					name="password" placeholder="<fmt:message key="login.password" />">
			</p>
			<p class="text-center">
				<button class="btn btn-primary btn-block" type="submit">
					<fmt:message key="login.submit" />
				</button>
			</p>
		</form>
	</div>
</body>
</html>