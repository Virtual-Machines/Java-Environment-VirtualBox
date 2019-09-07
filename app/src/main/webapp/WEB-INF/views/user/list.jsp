<!-- Users list @author David García Prados-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/head.jsp" />
<title><fmt:message key="users.title" /></title>
</head>
<body>

	<div class="container-fluid">
		<jsp:include page="../include/topRightMenu.jsp" />
		<jsp:include page="../include/leftMenu.jsp" />
		<div id="main">
			<h1 class="text-center">
				<fmt:message key="users.title" />
			</h1>

			<p>
				<a class="btn btn-primary"
					href="<c:url value="/${NavigationConstants.userBasePath}/${NavigationConstants.detail}"/>"><i
					class="fas fa-plus"></i> <fmt:message key="btn.new" /></a>
			</p>

			<table class="datable" class="display">
				<thead>
					<tr>
						<th><fmt:message key="users.datatable.username" /></th>
						<th><fmt:message key="users.datatable.active" /></th>
						<th><fmt:message key="users.datatable.roles" /></th>
						<th class='no-sort-datatables no-export-datatables'><fmt:message
								key="datatables.actions" /></th>
					</tr>
				</thead>
			</table>
			<script src="<c:url value="/resources/js/app/CustomDatatable.js"/>"></script>
			<script src="<c:url value="/resources/js/app/user/UserList.js"/>"></script>
		</div>
	</div>
</body>
</html>