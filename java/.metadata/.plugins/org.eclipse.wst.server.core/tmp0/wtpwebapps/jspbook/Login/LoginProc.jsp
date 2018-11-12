<%@page import="com.sun.org.apache.bcel.internal.generic.IFEQ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="login.*"%>
<%
	MembetDAO membetDAO = new MembetDAO();
	int in_id = Integer.parseInt(request.getParameter("id"));
	String in_pwd = request.getParameter("pwd");
	int chk = membetDAO.login(in_id, in_pwd);
	String name = "";
	out.println("<script>");
	if (chk == 1) {
		out.println("alert('Login Success')");
		name = membetDAO.getNm(in_id);
	} else if (chk == 2) {
		out.println("alert('The password is incorrect.')");
		out.println("history.go(-1)");
	} else {
		out.println("alert('ID does not exist.')");
		out.println("history.go(-1)");
	}
	out.println("</script>");
	session.setAttribute("del_id", in_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	Hello!
	<%=name%>!
	<br>
	<button onclick="location.href='comment.jsp'">home</button>
	<button onclick="location.href='Login.jsp'">logout</button>
	<button onclick="location.href='withdrawal.jsp'">withdrawal</button>
	<button onclick="location.href='modify.jsp'">modify</button>
</body>
</html>