<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="login.*"%>
<%
	MembetDAO membetDAO = new MembetDAO();

	int id = (int) session.getAttribute("del_id");
	membetDAO.deleteMember(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>withdrawal</title>
</head>
<body>
	Delete Finish!
	<br>
	Good bye!
	<button onclick="location.href='Login.jsp'">home</button>
</body>
</html>