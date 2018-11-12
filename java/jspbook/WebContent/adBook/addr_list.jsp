<%@page import="adbook.AddrBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="am" class="adbook.AddrManager" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	function idDelete(name) {

		location.href = "delete.jsp?name=" + name;

	}
</script>
</head>
<body>
	<h2>Content</h2>
	<hr>
	<a href="addr_form.jsp">add Address</a>
	<form method="post">
		<table border="1">
			<tr>
				<td>Name</td>
				<td>Phone Number</td>
				<td>E-mail</td>
				<td>Gender</td>
				<td></td>
			</tr>
			<%
				for (AddrBean ad : am.getAddrlist()) {
			%>
			<tr>
				<td><input name="name" value="<%=ad.getUsername()%>"
					type="hidden"><%=ad.getUsername()%></td>
				<td><%=ad.getTel()%></td>
				<td><%=ad.getEmail()%></td>
				<td><%=ad.getGender()%></td>
				<td><a href="modify_form.jsp">[modify]</a> <a href="#" onclick="idDelete('<%=ad.getUsername()%>')">[delete]</a></td>
			</tr>

			<%
				}
			%>
		</table>
	</form>
</body>
</html>