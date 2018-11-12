<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<div align="center">
		<h2>result test</h2>
		<hr>
		<table border="1" cellspacing="1" cellpadding="5">
			<tr>
				<td>name</td>
				<td><%=request.getParameter("username")%></td>
			</tr>
			<tr>
				<td>Job</td>
				<td><%=request.getParameter("job")%></td>
			</tr>
			<tr>
				<td>field of interest</td>
				<td>
					<%
						String favor[] = request.getParameterValues("favorite");

						for (String fav : favor) {
							out.println(fav + "<br>");
						}
					%>
				</td>
			</tr>
		</table>

		<table border="0">
			<tr>
				<td>IP Address : <%=request.getRemoteAddr()%> <br> 
				Method : <%=request.getMethod()%><br> 
				<%
				 	Cookie cookie[] = request.getCookies();
				 %> 
				 <%=cookie[0].getName()%> cookie value : <%=cookie[0].getValue()%><br>
				 Protocol : <%=request.getProtocol()%><br>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>