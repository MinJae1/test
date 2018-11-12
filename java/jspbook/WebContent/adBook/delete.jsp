<%@page import="adbook.AddrManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<%
		String nm = request.getParameter("name");
		AddrManager am = new AddrManager();
		am.del(nm);
	%>

	<script type="text/javascript">
		alert(<%=nm %>+ ' delete!');
		history.go(-1);
	</script>

</body>
</html>