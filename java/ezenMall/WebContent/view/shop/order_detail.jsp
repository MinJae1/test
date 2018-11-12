<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>

<div align="center" class="panel panel-default">
	<div class="panel-heading">주문상세내역</div>
	<div class="panel-body">
		<br>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th></th>
				<th>사진</th>
				<th>상품이름</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="odetail" varStatus="odcnt" items="${orderDetail}">
				<tr>
					<td></td>
					<td height="100" width="100"><img
						src="../../img/${odetail.img}" style="height: 100px;"></td>
					<td>${odetail.pName}</td>
					<td>${odetail.pQuantity}</td>
					<td>${odetail.pPrice * odetail.pQuantity}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
</div>

<%@ include file="/view/shop_footer.jsp"%>