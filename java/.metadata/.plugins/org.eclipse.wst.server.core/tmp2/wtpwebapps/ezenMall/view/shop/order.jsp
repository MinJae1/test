<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>

<script type="text/javascript">
	function orderdetail(oid) {
		document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=orderdetail&oid=" + oid;
	}
</script>


<div align="center" class="panel panel-default">
	<div class="panel-heading">주문내역</div>
	<div class="panel-body">
		<br>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>주문번호</th>
				<th>날짜</th>
				<th>사진</th>
				<th>상품이름</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="olist" varStatus="ocnt" items="${order}">
				<tr onclick="javascript:orderdetail(${olist.oId})">
					<td>${olist.oId}</td>
					<td>${olist.date}</td>
					<td height="100" width="100"><img src="../../img/${olist.img}"
						style="height: 100px;"></td>
					<td>${olist.pName}<c:if test="${olist.cnt > 0}"> 외 ${olist.cnt}개</c:if></td>
					<td>${olist.oPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="/view/shop_footer.jsp"%>
