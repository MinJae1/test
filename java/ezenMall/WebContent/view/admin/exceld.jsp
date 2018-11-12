<%@page contentType="application/vnd.ms-excel;charset=euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//�߿��� ���� : "attachment; filename=excel.xls" �� ������ excel.xls ������ �����ǰ� �ٿ�ε�ȴ�. 
	//�ǽ����� ���� �Ʒ����� �׳� ����� 
	//��� HTML�� Excel ������������ ��ȯ�� (������ �ʳ���?) 

	response.setHeader("Content-Disposition", "attachment; filename=test.xls");
	response.setHeader("Content-Description", "JSP Generated Data");
	response.setContentType("application/vnd.ms-excel");
%>
<html>
<body>

	<table border=1>
		<!-- border=1�� �ʼ� excel ���� �׵θ��� ������� -->
		<tr bgcolor=#CACACA>
			<!-- bgcolor=#CACACA excel ���� �������� ȸ������ -->
			<td colspan=3><H3>������ �����ݴϴ�</H3></td>
		</tr>
		<tr bgcolor=yellow>
			<th>��¥</th>
			<th>��ǰ��</th>
			<th>��ǰ����</th>
			<th>����</th>
			<th>��</th>
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