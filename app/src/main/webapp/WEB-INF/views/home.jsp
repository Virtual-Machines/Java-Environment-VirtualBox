<!-- Home @author David García Prados -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/head.jsp" />
<title><fmt:message key="home.title" /></title>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="include/topRightMenu.jsp" />
		<jsp:include page="include/leftMenu.jsp" />
		<div id="main">
			<h1 class="text-center">
				<fmt:message key="home.title"/>
			</h1>
		</div>
	</div>
</body>
</html>