<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="adbook.*"%>
<jsp:useBean id="am" class="adbook.AddrManager" scope="application"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Modify Address</h2>
	<hr>
	<form action="modify.jsp">
		<table border="1">
			<%
			String name = request.getParameter("in");
				for (AddrBean ad : am.getAddrlist()) {
					if (ad.getUsername().equals(name)) {
			%>

			<tr>
				<td>Name</td>
				<td><%=ad.getUsername()%></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" name="tel" value="<%=ad.getTel()%>"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" value="<%=ad.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><select name="gender">
						<option selected="selected">M</option>
						<option>W</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="modify"> <input type="button" value="cancle"
					onclick="location.href='addr_list.jsp'"></td>
			</tr>
			<%
				}
				}
			%>

		</table>
	</form>

</body>
</html>