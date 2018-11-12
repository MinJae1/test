<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form name="fo" method="get" action="LoginProc.jsp">
		&nbsp;ID&nbsp;&nbsp;&nbsp;:&nbsp;<input type="text" size="15" value=""
			name="id">
		<br>
		&nbsp;PW&nbsp;:&nbsp;<input type="password" size="15" value=""
			name="pwd">
		<br>
		<input type="submit" value="Login"> <input type="button"
			value="Join" onclick="location.href='Join.jsp'">
	</form>
</body>
</html>
