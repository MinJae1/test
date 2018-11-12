<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="navbar-form navbar-left" name="loginform" method="post"
	action="${pageContext.request.contextPath}/view/control/user_control.jsp">

	<c:choose>
		<c:when test="${uid!=null}">
			:: ${name} 님 안녕하세요! &nbsp;
			<input type="hidden" name="action" value="logout">
			<input class="btn btn-default" type="submit" value="logout">

		</c:when>
		<c:otherwise>
			:: Login &nbsp;
			<input type="hidden" name="action" value="login">
			<input class="form-control" type="text" name="uid" size="10">
			<input class="form-control" type="password" name="passwd" size="10">
			<input class="btn btn-default" type="submit" value="login">
		</c:otherwise>
	</c:choose>
</form>
