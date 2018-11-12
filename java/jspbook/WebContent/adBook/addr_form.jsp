<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>Add Address</h2>
	<hr>
	<form action="addr_add.jsp" method="post" name="form1">
		<table border="1">
			<tr>
				<td>Name</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email"></td>
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
					value="input"> <input type="reset" value="cancle"></td>
			</tr>
		</table>
	</form>
</body>
</html>