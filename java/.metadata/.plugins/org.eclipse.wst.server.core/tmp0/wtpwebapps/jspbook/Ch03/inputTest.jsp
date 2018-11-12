<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<form name=form1 method=post>
		<table>
			<tbody>
				<tr>
					<td>score1</td>
					<td><input type="text" NAME="sc1"></td>
				</tr>
				<tr>
					<td>score2</td>
					<td><input type="text" NAME="sc2"></td>
				</tr>
				<tr>
					<td>score3</td>
					<td><input type="text" NAME="sc3"></td>
				</tr>
				<tr>
					<td><input type="submit" name="b1" value="cal" /></td>
					<td><input type="reset" name="b2" value="retry" /></td>
				</tr>
			</tbody>
		</table>
	</form>

	<%
		if (request.getMethod().equals("POST")) {

			int score1 = Integer.parseInt(request.getParameter("sc1"));
			int score2 = Integer.parseInt(request.getParameter("sc2"));
			int score3 = Integer.parseInt(request.getParameter("sc3"));
			int total = score1 + score2 + score3;
			double avg = (double) total / 3.0;
	%>
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
				<td><%=score1%></td>
				<td><%=score2%></td>
				<td><%=score3%></td>
				<td><%=total%></td>
				<td><%=avg%></td>
			</tr>
		</tbody>
	</table>
	<%
		}
	%>
</body>
</html>