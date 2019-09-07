<!-- User detail @author David García Prados-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/head.jsp" />

<c:if test="${userForm.usrId == null}">
	<fmt:message key="userdetail.new.title" var="title" />
</c:if>

<c:if test="${userForm.usrId != null}">
	<fmt:message key="userdetail.edit.title" var="title" />
</c:if>

<title>${title}</title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/topRightMenu.jsp" />
		<jsp:include page="../include/leftMenu.jsp" />
		<div id="main">
			<h1 class="text-center">${title}</h1>
			<c:url
				value="/${NavigationConstants.userBasePath}/${NavigationConstants.detail}"
				var="action" />
			<c:if test="${success}">
				<div class="text-center col-md-3 alert alert-success fade show"
					data-dismiss="alert">
					<strong><fmt:message key="text.savedSuccessfully" /></strong>
				</div>
			</c:if>

			<form:form method="POST" action="${action}" modelAttribute="userForm">

				<c:set var="usrUsernameHasBindError">
					<form:errors path="usrUsername" />
				</c:set>
				<c:set var="usrPasswordHasBindError">
					<form:errors path="usrPassword" />
				</c:set>

				<form:input type="hidden" path="usrId"></form:input>

				<c:if test="${userForm.usrId == null}">
					<div class="form-group">
						<fmt:message key="userdetail.username" var="fmtUsername" />
						${fmtUsername} <small class="text-danger">${usrUsernameHasBindError}</small>
						<form:input placeholder="${fmtUsername}"
							class="form-control ${empty usrUsernameHasBindError ? '' : 'is-invalid'} col-md-3"
							path="usrUsername"></form:input>
					</div>

					<div class="form-group">
						<fmt:message key="userdetail.password" var="fmtPassword" />
						${fmtPassword} <small class="text-danger">${usrPasswordHasBindError}</small>
						<form:input type="password" placeholder="${fmtPassword}"
							class="form-control ${empty usrPasswordHasBindError ? '' : 'is-invalid'} col-md-3"
							path="usrPassword"></form:input>
					</div>
				</c:if>

				<c:if test="${userForm.usrId != null}">

					<form:input type="hidden" path="usrUsername"></form:input>
					<form:input type="hidden" path="usrPassword"></form:input>
					<p>
						<b> <fmt:message key="userdetail.username" />:
						</b> ${userForm.usrUsername}
					</p>
				</c:if>

				<fmt:message key="userdetail.active" />
				<br />
				<label class="switch"><form:checkbox path="usrEnabled"></form:checkbox><span
					class="slider round"></span></label>

				<br />
				<br />

				<form:button class="btn btn-primary">
					<i class="far fa-save"></i>
					<fmt:message key="btn.save" />
				</form:button>

				<a
					href="<c:url value="/${NavigationConstants.userBasePath}/${NavigationConstants.list}"/>"
					class="btn btn-secondary"> <i class="fas fa-arrow-left"></i> <fmt:message
						key="btn.exit" />
				</a>

			</form:form>
		</div>
	</div>
</body>
</html>