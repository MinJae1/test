<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User</title>
</head>
<body>
	<h2>Join</h2>
	<hr>
	<form action="user_control.jsp?action=new" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" size="10"
					required="required"></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="uid" size="10" required="required"></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="email" name="email" size="10"
					required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="passwd" size="10"
					required="required"> <input type="submit" value="join"></td>
			</tr>
		</table>
	</form>
</body>
</html>