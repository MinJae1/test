<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<title>구구단표</title>
<!-- <script type="text/javascript">
	function multi() {

		document.write("<table><tbody><tr>");
		for (var i = 1; i <= 9; i++) {
			document.write("<td style='padding : 10px'>");
			for (var j = 1; j <= 9; j++) {
				document.write(i + " X " + j + " = " + i * j + " <br>");
			}
			document.write("</td>");
			if (i % 3 == 0) {
				document.write("<tr>");
			}
		}
	}
	multi();
</script> -->
</head>

<body>
	<table>
		<tbody>
			<tr>
				<%
					for (int i = 1; i <= 9; i++) {
				%>
				<td style='padding: 10px'>
					<%
						int ans = 0;
							for (int j = 1; j <= 9; j++) {
								ans = i * j;
					%><%=i%> X <%=j%> = <%=ans%> <br> <%
                	}
                    %>
				</td>
				<%
					if (i % 3 == 0) {
				%>			
			<tr/>
				<%
					}
					}
				%>

			</tr>
		</tbody>
	</table>
</body>

</html>