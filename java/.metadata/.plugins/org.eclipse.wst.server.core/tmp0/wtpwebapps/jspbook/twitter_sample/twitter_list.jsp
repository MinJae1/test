<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("username");

	if (name != null) {
		session.setAttribute("user", name);
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>Twitter Sample</h3>
		<hr>
		<form action="tweet.jsp" method="post">
			@<%=session.getAttribute("user")%>
			<input type="text" name="msg"><input type="submit"
				value="tweet">
		</form>
		<hr>
		<div align="left">
			<ul>
				<%
					ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

					if (msgs != null) {
						for (String outM : msgs) {
							out.println("<li>" + outM + "</li>");
						}
					}
				%>
			</ul>
		</div>
	</div>
</body>
</html>