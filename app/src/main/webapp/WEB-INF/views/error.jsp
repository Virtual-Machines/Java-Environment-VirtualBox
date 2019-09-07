<!-- Error page @author David García Prados-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="include/head.jsp" />
<title><fmt:message key="error.generic.title"/></title>
</head>
<body>
	<h1 class="text-center">
		<fmt:message key="error.generic.body"/>
	</h1>

	<p class="text-center">
		<a class="btn btn-primary" href="<c:url value="/"/>"><fmt:message
				key="error.returnHome"/></a>
	</p>
</body>
</html>