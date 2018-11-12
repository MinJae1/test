<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean example</title>
</head>
<body>
	<div align="center">
		<form action="login.jsp" method="post" name="form1">
			<table>
				<tr>
					<td align="center" colspan="2">login</td>
				</tr>
				<tr>
					<td align="center">ID</td>
					<td><input type="text" name="userid" size="10"></td>
				</tr>
				<tr>
					<td align="center">Password</td>
					<td><input type="password" name="userpwd" size="10"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="login" name="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>