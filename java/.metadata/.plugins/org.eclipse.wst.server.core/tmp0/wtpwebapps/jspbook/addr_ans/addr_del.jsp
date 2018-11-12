<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="am" class="addr_ans.AddrManager" scope="application" />
<%
	request.setCharacterEncoding("UTF-8");
	String sname = request.getParameter("sname");
	am.delete(sname);
	out.println("<script>");
	out.println("prompt('주소록에서 " + sname + "이(가) 삭제되었습니다.');");
	out.println("</script>");
	//out.println("history.go(-1);");
	response.sendRedirect("addr_list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ch07 : addr_mod.jsp</title>
</head>
<body>

</body>
</html>