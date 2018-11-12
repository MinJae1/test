<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div align="center">
		<h2>using out</h2>
		<hr>
		buffer size :
		<%=out.getBufferSize()%><br> remain buffer size :
		<%=out.getRemaining()%><br>
		<%
			out.flush();
		%>
		remain buffer size After flush :
		<%=out.getRemaining()%><br>
		<%
			out.clear();
		%>
		Exception 한글 테스트
		remain buffer size After clear :
		<%=out.getRemaining()%><br>
		<%
			out.close();
		%>
		remain buffer size After close :
		<%=out.getRemaining()%><br>
	</div>
</body>
</html>