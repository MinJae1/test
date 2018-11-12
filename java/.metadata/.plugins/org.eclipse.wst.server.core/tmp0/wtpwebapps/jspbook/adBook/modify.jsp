<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="addr" class="adbook.AddrBean"></jsp:useBean>
<jsp:setProperty property="*" name="addr" />
<jsp:useBean id="am" class="adbook.AddrManager" scope="application"></jsp:useBean>
<%
	am.mod(addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>Modify details</h2>
	<hr>
	name :
	<jsp:getProperty property="username" name="addr" /><p />
	tel :
	<%=addr.getTel()%><p />
	email :
	<%=addr.getEmail()%><p />
	gender :
	<%=addr.getGender()%>
	<hr>
	<a href="addr_list.jsp">list</a>

</body>
</html>