<%@ page contentType="text/html;charset=utf-8"%>

<%
	// 변수를 설정한다.
	int result = 0;

	// POST 로 젼달된 경우만 수행
	if (request.getMethod().equals("POST")) {

		// 연산자를 가지고 온다.
		String op = request.getParameter("operator");

		// 문자열 형태로 전달된 인자를 int로 변환한다.
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		// 각 연산자별로 처리한다.
		if (op.equals("+")) {
			result = num1 + num2;
		} else if (op.equals("-")) {
			result = num1 - num2;
		} else if (op.equals("*")) {
			result = num1 * num2;
		} else if (op.equals("/")) {
			result = num1 / num2;
		}
	}
%>

<HTML>
<HEAD>
<TITLE>계산기</TITLE>
</HEAD>

<BODY>

	<H3>계산기</H3>
	<HR>
	<form name=form1 method=post>
		<INPUT TYPE="text" NAME="num1" width=200 size="5"> <SELECT
			NAME="operator">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</SELECT> <INPUT TYPE="text" NAME="num2" width=200 size="5"> <input
			type="submit" value="계산" name="B1"> <input type="reset"
			value="다시입력" name="B2">
	</form>
	<HR>

	계산 결과 :
	<%=result%>
</BODY>
</HTML>


