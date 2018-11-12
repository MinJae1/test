<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>call footer in include action</h2>
	<hr>
	<%-- <jsp:include page="footer.jsp"> --%>
	<jsp:forward page="footer.jsp">
		<jsp:param name="email" value="test@test.com" />
		<jsp:param name="tel" value="000-000-000" />
	</jsp:forward>
	<%-- </jsp:include> --%>
</body>
</html>