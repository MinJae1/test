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
		<H2>주소록:수정화면</H2>
		<HR>
		[<a href=addrbook_control.jsp?action=list>주소록 목록으로</a>]
		<p>
		<form name=form1 method=post action=addrbook_control.jsp>
			<input type=hidden name="ab_id" value="${ab.abId} "> <input
				type=hidden name="action" value="update">

			<table border="1">
				<tr>
					<th>이 름</th>
					<td><input type="text" name="ab_name"
						value="<%=ab.getAb_name()%>"></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="email" name="ab_email"
						value="<%=ab.getAb_email()%>"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="ab_tel"
						value="<%=ab.getAb_tel()%>" maxlength="11"></td>
				</tr>
				<tr>
					<th>생 일</th>
					<td><input type="date" name="ab_birth"
						value="<%=ab.getAb_birth()%>"></td>
				</tr>
				<tr>
					<th>회 사</th>
					<td><input type="text" name="ab_company"
						value="<%=ab.getAb_company()%>"></td>
				</tr>
				<tr>
					<th>메 모</th>
					<td><textarea rows="5" cols="26" name="ab_memo"><%=ab.getAb_memo()%></textarea></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="저장">
						<input type=reset value="취소"></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>