<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<script type="text/javascript">
	document.cookie = "test=OK."
</script>
</head>
<body>
	<div align="center">
		<h2>input test</h2>
		<hr>
		<form action="request_result.jsp" name="form1" method="post">
			<table border="1" cellspacing="1" cellpadding="5">
				<tr>
					<td>name</td>
					<td><input type="text" size="10" name="username"></td>
				</tr>
				<tr>
					<td>Job</td>
					<td><select name="job">
							<option selected="selected">none</option>
							<option>employee</option>
							<option>specialized job</option>
							<option>student</option>
					</select></td>
				</tr>
				<tr>
					<td>field of interest</td>
					<td><input type="checkbox" name="favorite" value="politics">politics
						<input type="checkbox" name="favorite" value="society">society
						<input type="checkbox" name="favorite" value="it">IT</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="submit"> <input type="reset" value="cancle"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>