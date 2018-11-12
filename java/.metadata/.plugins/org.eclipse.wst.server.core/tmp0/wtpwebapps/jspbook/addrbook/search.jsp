<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="addrbook_error.jsp"
	import="java.util.*, jspbook.addrbook.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="addrbook.css" type="text/css"
	media="screen" />

<meta charset="UTF-8">
<title>Search</title>
</head>
<jsp:useBean id="sdatas" scope="request" class="java.util.ArrayList" />

<body>
	<div align="center">
		<h2>검색결과</h2>
		<hr>
		<table border="1">
			<tr>
				<th>이 름</th>
				<th>전화번호</th>
				<th>생 일</th>
				<th>회 사</th>
			</tr>
			<%
				if (sdatas.size() != 0) {
					for (AddrBook ab : (ArrayList<AddrBook>) sdatas) {
						System.out.print("#" + ab.getAb_name());
			%>
			<tr>
				<td><%=ab.getAb_name()%></td>
				<td><%=ab.getAb_tel()%></td>
				<td><%=ab.getAb_birth()%></td>
				<td><%=ab.getAb_company()%></td>
			</tr>
			<%
				}
				} else {
			%>
			<tr>
				<td colspan="4">검색 결과가 없습니다.</td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="addrbook_control.jsp?action=list">목록으로</a>
	</div>
</body>
</html>