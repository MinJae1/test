<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="addr" class="addr_ans.AddrBean" />
<jsp:setProperty name="addr" property="*" />
<jsp:useBean id="am" class="addr_ans.AddrManager" scope="application" />
<%
	am.modify(addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ch07 : addr_mod.jsp</title>
</head>
<body>
	<div align="center">
		<H2>수정내용</H2>
		이름 :
		<jsp:getProperty property="username" name="addr" /><P>
			전화번호 :
			<%=addr.getTel()%>
		<P>
			이메일 :
			<%=addr.getEmail()%>
		<P>
			성별 :
			<%=addr.getSex()%>
		<HR>
		<a href="addr_list.jsp">목록 보기</a>
	</div>
</body>
</html>