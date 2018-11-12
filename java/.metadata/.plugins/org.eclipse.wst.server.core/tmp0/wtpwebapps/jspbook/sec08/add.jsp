<%@page import="java.util.*"%>
<%@page import="sec08.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");

		String pro_name = request.getParameter("product");
		int count = Integer.parseInt(request.getParameter("cnt"));
		CartDTO cartDTO = new CartDTO(pro_name, count);

		ArrayList<CartDTO> list = (ArrayList<CartDTO>) session.getAttribute("pList");
		if (list == null) {
			list = new ArrayList<CartDTO>();
			session.setAttribute("pList", list);
		}
		list.add(cartDTO);
	%>
	<script type="text/javascript">
		alert('add!');
		history.go(-1);
	</script>
</body>
</html>