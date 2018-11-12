<%@page contentType="application/vnd.ms-excel;charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//중요한 사항 : "attachment; filename=excel.xls" 로 적으면 excel.xls 파일이 생성되고 다운로드된다. 
	//의심하지 말고 아래줄은 그냥 적어요 
	//모든 HTML은 Excel 파일형식으로 변환됨 (편하지 않나요?) 

	response.setHeader("Content-Disposition", "attachment; filename=test.xls");
	response.setHeader("Content-Description", "JSP Generated Data");
	response.setContentType("application/vnd.ms-excel");
%>
<html>
<body>

	<table border=1>
		<!-- border=1은 필수 excel 셀의 테두리가 생기게함 -->
		<tr bgcolor=#CACACA>
			<!-- bgcolor=#CACACA excel 셀의 바탕색을 회색으로 -->
			<td colspan=3><H3>제목을 적어줍니다</H3></td>
		</tr>
		<tr bgcolor=yellow>
			<th>날짜</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>수량</th>
			<th>합</th>
		</tr>
		<c:forEach var="dplist" items="${test}">
			<tr>
				<td class="first">${dplist.date}</td>
				<td>${dplist.pName}</td>
				<td>${dplist.pPrice}</td>
				<td>${dplist.pQuantity}</td>
				<td>${dplist.pQuantity * dplist.pPrice}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>