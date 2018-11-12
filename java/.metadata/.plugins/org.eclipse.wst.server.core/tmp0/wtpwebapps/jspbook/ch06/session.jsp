<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>
	<h2>Session test</h2>
	<hr>
	<%
		if (session.isNew()) {
			out.println(
					"<script>alert('Session will be released and reset')</script>");
			session.setAttribute("login", "test_name");
		}
	%>
	Welcome #<%=session.getAttribute("login")%>!!
	<br>
	ID :
	<%=session.getId()%><br>
	Session hold time :
	<%=session.getMaxInactiveInterval()%>
</body>
</html>