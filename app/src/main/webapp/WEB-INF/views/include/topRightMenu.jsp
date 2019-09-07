<!-- Top right menu with locale bar and user info + logout @author David García Prados -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<sec:authentication var="user" property="principal" />

<div class="topnav">
	<form id="logout-form"
		action="<c:url value="/${NavigationConstants.logout}"/>" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<jsp:include page="localeBar.jsp" />
		&nbsp; <span title="${user.username}">${user.username}</span>
		<button class="btn btn-danger"
			title="<fmt:message key="topRightMenu.logout"/>">
			<i class="fas fa-power-off"></i>
		</button>

	</form>
</div>