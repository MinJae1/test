<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>application example</h2>
	<hr>
	server info :
	<%=application.getServerInfo()%><br>
	 servlet API info :
	<%=application.getMajorVersion() + "." + application.getMinorVersion()%><br>
	application.jsp root :
	<%=application.getRealPath("application.jsp")%>
	<hr>
	username set "TEST" by setAttribute
	<p>
		<%
			application.setAttribute("username", "TEST");
			application.log("username = TEST");
			application.setAttribute("count", 0);
		%>
		<a href="application_result.jsp">Check</a>
</body>
</html>