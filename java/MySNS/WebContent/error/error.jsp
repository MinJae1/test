<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
</head>
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<body>
	<div align="center">
		<H2>My SNS Error!</H2>
		<HR>
		<table cellpadding=5 width=400>
			<tr width=100% bgcolor="pink">
				<td>관리자에게 문의해 주세요..<BR> 빠른시일내 복구하겠습니다.
				</td>
			</tr>
			<tr>
				<td>${now}<p>
						Error URI : ${pageContext.errorData.requestURI}
						<br>
						Status Code : ${pageContext.errorData.statusCode}
						<br>
						Exception Type : ${pageContext.errorData.throwable}</td>
			</tr>
		</table>
	</div>

</body>
</html>