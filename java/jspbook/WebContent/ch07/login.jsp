<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="ch07.LoginBean" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="login" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		if (!login.checkUser()) {
			out.println("Login Fail");
		} else {
			out.println("login success");
		}
	%>
	<hr>
	userID :
	<jsp:getProperty property="userid" name="login" /><br>
	userPW :
	<jsp:getProperty property="passwd" name="login" /><br>

</body>
</html>