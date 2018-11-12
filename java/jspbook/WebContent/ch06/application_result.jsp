<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<h2>result</h2>
	<hr>
	username value :
	<%=application.getAttribute("username")%><p>
		<%
			Integer count = (Integer) application.getAttribute("count");
			int cnt = count.intValue() + 1;
			application.setAttribute("count", cnt);
		%>
		visit :
		<%=cnt%>
</body>
</html>