<!-- Left Menu @author David García Prados -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<div id="mySidenav" class="sidenav">

	<a href="<c:url value="/"/>"><img
		src="<c:url value="/resources/img/logo.png"/>" /> <fmt:message
			key="leftMenu.title" /></a>

	<!-- Only admin can edit users  -->
	<sec:authorize access="hasAnyRole('${CoreConstants.roleAdmin}')">
		<a href="#collapseUsers" data-toggle="collapse"><i
			class="fas fa-user"></i> <fmt:message key="leftMenu.users" /> <small
			class="fas fa-arrow-down collapse show" id="collapseUsers"></small> <small
			class="fas fa-arrow-up collapse" id="collapseUsers"></small></a>
		<small class="collapse show" id="collapseUsers"> <a
			href="<c:url value="/${NavigationConstants.userBasePath}/${NavigationConstants.list}"/>"><i
				class="fas fa-list"></i> <fmt:message key="option.list" /></a> <a
			href="<c:url value="/${NavigationConstants.userBasePath}/${NavigationConstants.detail}"/>"><i
				class="fas fa-edit"></i> <fmt:message key="option.detail" /></a>
		</small>
	</sec:authorize>
</div>

<!-- Mark active link on menu -->
<script>
	$(document).ready(function() {
		var current = location.pathname;
		$('#mySidenav a').each(function() {
			var $this = $(this);

			if ($this.attr('href') === current) {
				$this.addClass('active');
				$this.parent().prev('[data-toggle]').addClass('active');
			}
		})
	});
</script>