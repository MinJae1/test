<%@page import="java.util.*"%>
<%@page import="sec08.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculate</title>
</head>
<body>
	<h2>calculate</h2>
	<hr>
	List
	<hr>
	<%
		int value = 0;

		ArrayList<CartDTO> list = (ArrayList<CartDTO>) session.getAttribute("pList");
		if (list == null) {
			out.println("Not select");
		} else {
			out.println("<table>");
			for (CartDTO cartDTO : list) {
				out.println("<tr><td>" + cartDTO.getName() + "</td><td>" + cartDTO.getCnt() + "</td></tr>");
				value += cartDTO.getCnt();
			}
			out.println("<tr><td> total  </td><td>" + value + "</td></tr>");
			out.println("</table>");
		}
	%>
	<script>
		// 타임아웃에 인한 로그아웃 처리를 수행할 스크립트 함수
		function expireSession() {

			alert("세션이 만료되었습니다.");

			window.location = "login.jsp"; //로그아웃처리를 수행할 web page 로 이동
		}

		//setTimeout() 함수를 사용하여 세션유효시간 후에 수행 함수를 호출한다. (비동기)
		setTimeout('expireSession()',
	<%=request.getSession().getMaxInactiveInterval() * 10%>
		);
	</script>

</body>
</html>