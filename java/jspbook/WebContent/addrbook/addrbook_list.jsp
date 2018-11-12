<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="addrbook_error.jsp"
	import="java.util.*, jspbook.addrbook.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="addrbook.css" type="text/css"
	media="screen" />

<script type="text/javascript">
	function check(ab_id) {
		pwd = prompt('수정하시려면 비밀번호를 넣으세요');
		document.location.href = "addrbook_control.jsp?action=edit&ab_id="
				+ ab_id + "&upasswd=" + pwd;
	}

	function del_check(ab_id) {
		pwd = prompt('삭제하시려면 비밀번호를 넣으세요');
		document.location.href = "addrbook_control.jsp?action=delete&ab_id="
				+ ab_id + "&upasswd=" + pwd;
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:목록화면</title>

</head>
<%-- <jsp:useBean id="datas" scope="request" class="java.util.ArrayList" /> --%>

<body>
	<div align="center">
		<H2>주소록:목록화면</H2>
		<form method="POST" action="addrbook_control.jsp?action=search">
			검색 : <input type="text" name="sname" placeholder="이름"> <input
				type="submit" value="검색">
		</form>
		<hr>
		<form>
			<a href="addrbook_form.jsp">주소록 등록</a>
			<P>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>이 름</th>
					<th>전화번호</th>
					<th>생 일</th>
					<th>회 사</th>
					<th></th>
				</tr>

				<c:set var="ablist" value="${requestScope.datas}" />
				<c:forEach var="abDTO" items="${ablist}">
					<tr>
						<td><a
							href="addrbook_control.jsp?action=view&ab_id=${abDTO.ab_id}">${abDTO.ab_id}</a></td>
						<td>${abDTO.ab_name}</td>
						<td>${abDTO.ab_tel}</td>
						<td>${abDTO.ab_birth}</td>
						<td>${abDTO.ab_company}</td>
						<td>[<a href="javascript:check(${abDTO.ab_id})">수정</a>] [<a
							href="javascript:del_check(${abDTO.ab_id})">삭제</a>]
						</td>

					</tr>

				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>