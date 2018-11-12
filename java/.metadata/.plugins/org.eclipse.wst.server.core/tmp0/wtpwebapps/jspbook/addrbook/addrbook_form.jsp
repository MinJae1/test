<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:작성화면</title>
<link rel="stylesheet" href="addrbook.css" type="text/css"
	media="screen" />
</head>
<body>
	<div align="center">
		<H2>주소록:작성화면</H2>
		<HR>
		[<a href=addrbook_control.jsp?action=list>주소록 목록으로</a>]
		<P>
		<form name=form1 method=post action=addrbook_control.jsp>
			<input type=hidden name="action" value="insert">
			<table border="1">
				<tr>
					<th>이 름</th>
					<td><input type="text" name="ab_name" maxlength="15"></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="email" name="ab_email" maxlength="50"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="ab_tel" id="ab_tel"
						maxlength="11"></td>
				</tr>
				<tr>
					<th>생 일</th>
					<td><input type="date" name="ab_birth" id="ab_birth"></td>
				</tr>
				<tr>
					<th>회 사</th>
					<td><input type="text" name="ab_company" maxlength="20"></td>
				</tr>
				<tr>
					<th>메 모</th>
					<td><textarea rows="5" cols="26" name="ab_memo"></textarea></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="저장">
						<input type=reset value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function getFormatDate(date) {
			var year = date.getFullYear();

			var month = (1 + date.getMonth());
			month = month >= 10 ? month : '0' + month;

			var day = date.getDate();
			day = day >= 10 ? day : '0' + day;

			return year + '-' + month + '-' + day;
		}

		var date = document.querySelector('input[type="date"]');
		var today = new Date();
		today = getFormatDate(today);

		date.value = today;
	</script>

	<script>
		$('#ab_tel').mask('000-0000-0000');
	</script>

</body>
</html>