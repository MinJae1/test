<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="addr_ans.*"%>
<jsp:useBean id="am" class="addr_ans.AddrManager" scope="application" />
<%
	request.setCharacterEncoding("UTF-8");
	AddrBean addr = am.getAddr(request.getParameter("sname"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ch07 : addr_add_form.jsp</title>
</head>
<body>
	<div align="center">
		<H2>주소록 수정</H2>
		<HR>
		<form name=form1 method="post" action="addr_mod.jsp">
			<input type="hidden" name=username value="<%=addr.getUsername()%>">
			<table border=1 cellspacing="1" cellpadding="5">
				<tr>
					<td>이 름</td>
					<td><%=addr.getUsername()%></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type=text size=20 name=tel
						value="<%=addr.getTel()%>"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type=text size=20 name=email
						value="<%=addr.getEmail()%>"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><select name=sex>
							<%
								if (addr.getSex().equals("남")) {
							%>
							<option selected>남</option>
							<option>여</option>
							<%
								} else {
							%>
							<option>남</option>
							<option selected>여</option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="수정">
						<input type=reset value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>