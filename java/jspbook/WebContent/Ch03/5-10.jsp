<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<title>표응용1</title>
<style media="screen">
table {
	border-collapse: collapse;
}

td, th {
	text-align: left;
	padding: 5px;
	height: 15px;
	width: 100px;
}

thead, tfoot {
	background: #D8CEF6;
	color: white;
}

tbody tr:nth-last-child(even) {
	background: #E0E0F8;
}

tbody tr:hover {
	background: pink;
}
</style>
</head>

<body>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>html</th>
				<th>css</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>합</th>
				<th>310</th>
				<th>249</th>
			</tr>
		</tfoot>
		<tbody>
			<tr>
				<td>황기태</td>
				<td>80</td>
				<td>70</td>
			</tr>
			<tr>
				<td>이재문</td>
				<td>95</td>
				<td>99</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>85</td>
				<td>90</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>50</td>
				<td>40</td>
			</tr>
		</tbody>
	</table>
</body>

</html>