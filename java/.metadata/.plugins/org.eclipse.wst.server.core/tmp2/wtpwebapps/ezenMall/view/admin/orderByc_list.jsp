<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>
<script>
	$(window).load(function() {
		$(".first").each(function() {
			var rows = $(".first:contains('" + $(this).text() + "')");
			if (rows.length > 1) {
				rows.eq(0).attr("rowspan", rows.length);
				rows.not(":eq(0)").remove();
			}
		});
	});
</script>

<script type="text/javascript">
function adminGoTo(pno) {
	var cid = '${cid}';
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=corderlist&pageno="+pno+"&cid=" + cid;
}

</script>

<div align="center" class="panel panel-default">

	<div class="panel-heading">고객단위 일별 주문내역</div>
	<table class="table">
		<thead>
			<tr>
				<th>날짜</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>수량</th>
				<th>합</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ocList" items="${ocList}">
				<tr>
					<td  class="first">${ocList.date}</td>
					<td>${ocList.pName}</td>
					<td>${ocList.pPrice}</td>
					<td>${ocList.pQuantity}</td>
					<td>${ocList.pQuantity * ocList.pPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div align="center">
	<jsp:include page="../admin_paging.jsp" flush="true"></jsp:include></div>
<%@ include file="/view/shop_footer.jsp"%>
