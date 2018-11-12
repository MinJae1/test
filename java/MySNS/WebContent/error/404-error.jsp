<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 error</title>
</head>
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
<body>
	<div align="center">
		<H2>404 Error!</H2>
		<HR>
		<table cellpadding=5 width=400>
			<tr width=100% bgcolor="pink">
				<td>The file you requested cannot be found.<BR> Check the
					URL!!
				</td>
			</tr>
			<tr>
				<td>${now}<p>
						Error URI : ${pageContext.errorData.requestURI}
						<br>
						Status Code : ${pageContext.errorData.statusCode}
			</tr>
		</table>
	</div>

</body>

</html>