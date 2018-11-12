<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>

<script type="text/javascript">
	var check = false;

	function CheckAll() {

		var chk = document.getElementsByName("del_unit[]");

		if (check == false) {
			check = true;
			for (var i = 0; i < chk.length; i++) {
				chk[i].checked = true; //모두 체크
			}
		} else {
			check = false;
			for (var i = 0; i < chk.length; i++) {
				chk[i].checked = false; //모두 해제
			}
		}
	}

	function selectRow(cid,f) {

		var chk = document.getElementsByName("del_unit[]"); // 체크박스객체를 담는다
		var len = chk.length; //체크박스의 전체 개수
		var checkRow = new Array(); //체크된 체크박스의 value를 담기위한 변수
		var checkCnt = 0; //체크된 체크박스의 개수
		var checkLast = ''; //체크된 체크박스 중 마지막 체크박스의 인덱스를 담기위한 변수
		var cnt = 0;

		for (var i = 0; i < len; i++) {
			if (chk[i].checked == true) {
				checkCnt++; //체크된 체크박스의 개수
				checkLast = i; //체크된 체크박스의 인덱스
			}
		}
		var j =0;

		for (var i = 0; i < len; i++) {
			if (chk[i].checked == true) { //체크가 되어있는 값 구분	
				checkRow[j] = chk[i].value;
				j++;
			}
		}
		if (f == 1) {
	 		del(checkRow,cid);
		} else {
			chkorder(checkRow,cid);
		}
		
 	}

	function del(oid,cid) {
		document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=delete&oid=" + oid + "&cid="+ cid;
	}

	function chkorder(oid,cid) {
		document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=selOrder&oid=" + oid + "&cid="+ cid;
	}
	
	function orderall(cid) {
		var chk = document.getElementsByName("del_unit[]"); // 체크박스객체를 담는다
		var oid = new Array();
		var len = chk.length; //체크박스의 전체 개수
		
		for (var i = 0; i < len; i++) {
			oid[i] = chk[i].value;	
		}
		 document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=selOrder&oid=" + oid + "&cid="+ cid; 
	}

</script>

<div align="center" class="panel panel-default">
	<div class="panel-heading">장바구니</div>
	<div class="panel-body">
		<br>
		<br>
		<br>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th><input type="checkbox" name="checkall"
					onclick="javascript:CheckAll()" value="0"></th>
				<th>날짜</th>
				<th>사진</th>
				<th>상품이름</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:set value="0" var="total"></c:set>

			<c:forEach var="clist" varStatus="ccnt" items="${cartList}">
				<c:set value="${clist.pPrice * clist.pQuantity}" var="sum"></c:set>
				<tr>
					<td><input type="checkbox" id="del_id" name="del_unit[]"
						value="${clist.oId}"></td>
					<td>${clist.date}</td>
					<td height="100" width="100"><img src="../../img/${clist.img}"
						style="height: 100px;"></td>
					<td>${clist.pName}</td>
					<td>${clist.pQuantity}</td>
					<td>${sum}</td>
				</tr>
				<c:set value="${total + sum}" var="total"></c:set>
			</c:forEach>

		</tbody>
		<tfoot>
			<tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>${total}</td>
			</tr>
		</tfoot>
	</table>
	<button class="btn btn-default"
		onclick="javascript:selectRow(${cid},1)" role="button">선택한 상품
		삭제</button>
	<button class="btn btn-default"
		onclick="javascript:selectRow(${cid},2)" role="button">선택한 상품
		구매</button>
	<button class="btn btn-default" onclick="javascript:orderall(${cid})"
		role="button">모두구매</button>
	<br>
	<br>
</div>

<%@ include file="/view/shop_footer.jsp"%>
