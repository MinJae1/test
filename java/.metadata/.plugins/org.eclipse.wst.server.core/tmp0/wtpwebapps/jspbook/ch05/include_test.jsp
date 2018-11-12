<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<center>
		<h2>include test page</h2>

		<%@ include file="menu.jsp"%>
		<table>
			<tr>
				<td><%@ include file="news.jsp"%></td>
				<td>&nbsp&nbsp&nbsp</td>
				<td><%@ include file="shopping.jsp"%></td>
			</tr>
		</table>
	</center>
</body>
</html>