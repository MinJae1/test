<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="addrbook_error.jsp"
	import="jspbook.addrbook.*"%>
<!DOCTYPE HTML>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>

<script>
	$('#ab_tel').mask('000-0000-0000');
</script>


<link rel="stylesheet" href="addrbook.css" type="text/css"
	media="screen" />

<script type="text/javascript">
	function delcheck() {
		result = confirm("정말로 삭제하시겠습니까 ?");

		if (result == true) {
			document.form1.action.value = "delete";
			document.form1.submit();
		} else
			return;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:수정화면</title>
</head>

<jsp:useBean id="ab" scope="request" class="jspbook.addrbook.AddrBook" />

<body>
	<div align="center">
		<H2>주소록:View</H2>
		<HR>
		[<a href=addrbook_control.jsp?action=list>주소록 목록으로</a>]
		<p>
			<input type=hidden name="ab_id" value="<%=ab.getAb_id()%>">
		<table border="1">
			<tr>
				<th>이 름</th>
				<td><%=ab.getAb_name()%></td>
			</tr>
			<tr>
				<th>email</th>
				<td><%=ab.getAb_email()%></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><%=ab.getAb_tel()%></td>
			</tr>
			<tr>
				<th>생 일</th>
				<td><%=ab.getAb_birth()%></td>
			</tr>
			<tr>
				<th>회 사</th>
				<td><%=ab.getAb_company()%></td>
			</tr>
			<tr>
				<th>메 모</th>
				<td><textarea rows="5" cols="26" name="ab_memo"
						disabled="disabled"
						style="background: none; border: none"><%=ab.getAb_memo()%></textarea></td>
			</tr>
		</table>

	</div>
</body>
</html>