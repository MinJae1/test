<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<%
	request.setCharacterEncoding("utf-8");

	session.setAttribute("name", request.getParameter("username"));
%>
<body>
	<div align="center">
		<h2>select product</h2>
		<hr>
		Welcome
		<%=session.getAttribute("name")%>!
		<hr>
		<form action="add.jsp" name="form1" method="post">
			<select name="product">
				<option>apple</option>
				<option>mandarin</option>
				<option>pineapple</option>
				<option>grapefruit</option>
				<option>lemon</option>
			</select><input type="text" name="cnt"><input type="submit"
				value="add">
		</form>
		<a href="checkOut.jsp">calculate</a>
	</div>
</body>
</html>