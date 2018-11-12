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

		$(".second").each(function() {
			var rows = $(".second:contains('" + $(this).text() + "')");
			if (rows.length > 1) {
				rows.eq(0).attr("rowspan", rows.length);
				rows.not(":eq(0)").remove();
			}
		});
	});
</script>

<script type="text/javascript">
function adminGoTo(pno) {
	var lc = '${lcode}';
	var dp = '${dp}';
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=orderlist&listcode="
				+ lc + "&datepicker=" + dp + "&pageno=" + pno;
	}

	$(document).ready(function() {
		$("#excelConverBtn").on('click', function() {
			location.href = "<%=cPath%>/view/control/admin_control.jsp?action=download";
										});
					});
</script>
<div class="row">
	<div align="left" class="col-md-3">
		<table style="border: none">
			<tr>
				<td><input type="button" name="excelConverBtn"
					id="excelConverBtn" value="전체 판매내역 엑셀다운" style="cursor: hand;"
					class="btn btn-default" /></td>
			</tr>
		</table>
	</div>
	<div align="right" class="col-md-9">
		<form name="form1" method="post"
			action="${pageContext.request.contextPath}/view/control/admin_control.jsp?action=orderlist&pageno=1&listcode=${lcode}">
			<table style="border: none">
				<tr>
					<td><input id="datepicker" name="datepicker" width="270" /></td>
					<td><input type="submit" class="btn btn-default" value="검색" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>
<br>

<div align="center" class="panel panel-default">
	<c:choose>
		<c:when test="${lcode == 1}">
			<div class="panel-heading">일단위 상품별 판매내역</div>
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
					<c:forEach var="dplist" items="${dplist}">
						<tr>
							<td class="first">${dplist.date}</td>
							<td>${dplist.pName}</td>
							<td>${dplist.pPrice}</td>
							<td>${dplist.pQuantity}</td>
							<td>${dplist.pQuantity * dplist.pPrice}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:when test="${lcode == 2}">
			<div class="panel-heading">일단위 고객별 주문내역</div>
			<table class="table">
				<thead>
					<tr>
						<th>날짜</th>
						<th>고객이름</th>
						<th>상품명</th>
						<th>상품가격</th>
						<th>수량</th>
						<th>합</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="odList" items="${odList}">
						<tr>
							<td class="first">${odList.date}</td>
							<td class="second">${odList.cName}</td>
							<td>${odList.pName}</td>
							<td>${odList.pPrice}</td>
							<td>${odList.pQuantity}</td>
							<td>${odList.pQuantity * odList.pPrice}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
	</c:choose>
</div>
<div align="center">
	<jsp:include page="../admin_paging.jsp" flush="true"></jsp:include></div>

<%@ include file="/view/shop_footer.jsp"%>
