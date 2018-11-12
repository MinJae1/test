<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>score1</th>
				<th>score2</th>
				<th>score3</th>
				<th>Total</th>
				<th>Average</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=request.getParameter("pSc1")%></td>
				<td><%=request.getParameter("pSc2")%></td>
				<td><%=request.getParameter("pSc3")%></td>
				<td><%=request.getParameter("pTotal")%></td>
				<td><%=request.getParameter("pAvg")%></td>
			</tr>
		</tbody>
	</table>

</body>
</html>