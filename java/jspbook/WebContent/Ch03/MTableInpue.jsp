<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name=form1 method=post>
		<table>
			<tbody>
				<tr>
					<td>MultiPle Table value</td>
					<td><input type="text" NAME="value"></td>
					<td><input type="submit" name="b1" value="cal" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<%
		if (request.getMethod().equals("POST")) {

			int v = Integer.parseInt(request.getParameter("value"));
	%>
	<table>
		<tbody>
			<tr>
				<td>
					<%
						int ans = 0;
							for (int j = 1; j <= 9; j++) {
								ans = v * j;
					%> <%=v%> X <%=j%> = <%=ans%> <br> <%
 	}
 %>
				</td>
			</tr>
		</tbody>
	</table>

	<%
		}
	%>
</body>
</html>