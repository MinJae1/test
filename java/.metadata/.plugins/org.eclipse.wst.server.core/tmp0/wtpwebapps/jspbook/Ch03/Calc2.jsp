<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="calc" scope="page" class="jspbook.Ch03.CalcBean"></jsp:useBean>
<jsp:setProperty property="*" name="calc" />
<%
	calc.calculator();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator2</title>
</head>
<body>
	<h3>Calculator2</h3>
	<hr>
	<form name="form1" method="post">
		<input type="text" name="num1" width="200" size="5"> <select
			name="operator">
			<option selected="selected">+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select> <input type="text" name="num2" width="200" size="5" /> <input
			type="submit" name="b1" value="cal" /> <input type="reset" name="b2"
			value="retry" />
	</form>
	result >
	<jsp:getProperty property="result" name="calc" />
</body>
</html>