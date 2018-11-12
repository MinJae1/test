<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>


<script type="text/javascript">
	function fn(pid, cid, chk) {
		if (cid == 0) {
			alert('로그인 해주세요!');
			} else {
				var quan = $('#quantity').val();
				if (quan == null || quan == 0) {
					alert('수량을 입력해 주세요');
					} else {
					if (chk == 1) {
						document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=cart&pid=" + pid
								+ "&q=" + quan + "&cid=" + cid;
						alert('상품이 장바구니에 담겼습니다.');
					} else {
						document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=order&pid=" + pid
						+ "&q=" + quan + "&cid=" + cid;
						alert('상품 주문이 완료되었습니다.');
					}
				}
		}
	}
</script>


<div align="center" class="panel panel-default">
	<c:set value="${item}" var="item"></c:set>
	<div class="panel-heading">상품 상세 페이지</div>

	<table class="table" >
		<thead>
			<tr height="200" align="center">
			<td colspan="2" width="100%"><img src="../../img/${item.img}"
				style="height: 200px;"></td>
			</tr>
		</thead>
		<tbody>
			<tr align="center">
				<td colspan="2" width="100%"><h4 style="font-weight: bold;">${item.pName}</h4></td>
			</tr>
			<tr align="center">
				<td colspan="2" width="100%"><fmt:formatNumber value="${item.pPrice}"
						pattern="###,###,###" /></td>
			</tr>
			<tr>
				<td width="8%">수량</td>
				<td width="100%"><input type="number" min=1 required="required"
					class="form-control" id="quantity" value="1"></td>
			</tr>
			<tr align="center">
				<td colspan="2" width="100%"><button class="btn btn-default"
						onclick="javascript:fn(${item.pId},${cid},1)" type="button">장바구니</button>
					<button class="btn btn-default"
						onclick="javascript:fn(${item.pId},${cid},2)" type="button">바로구매</button>
				<td>
			</tr>
			<tr align="center">
				<td width="100%" colspan="2" style="background-color: #f5f5f5;">상세 설명</td>
			</tr>

			<tr align="center">
				<td width="100%" colspan="2">${item.pDetail}</td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="/view/shop_footer.jsp"%>
