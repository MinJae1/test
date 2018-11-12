<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="login.*"%>
<%
	MembetDAO membetDAO = new MembetDAO();
	String nm = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	int zipC = Integer.parseInt(request.getParameter("zip"));
	String adr = request.getParameter("add");

	MemberDTO memberDTO = new MemberDTO(nm, pwd, zipC, adr);

	membetDAO.insertMember(memberDTO);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Thank you for Join!
	<button onclick="location.href='Login.jsp'">login</button>
</body>
</html>