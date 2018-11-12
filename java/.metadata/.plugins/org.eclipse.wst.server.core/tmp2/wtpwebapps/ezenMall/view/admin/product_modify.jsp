<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>
<script type="text/javascript">
function Home() {
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=productlist&pageno=0";
	}
</script>

<div align="center" class="panel panel-default">
	<c:set value="${item}" var="item"></c:set>
	<div class="panel-heading">상품 수정</div>
	<form method="post" enctype="multipart/form-data"
		action="<%=cPath%>/view/control/admin_control.jsp?action=modify">
		<table class="table">
			<tr>
				<td>상품명</td>
				<td><input class="form-control" type="text" name="name"
					required="required" value="${item.pName}"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" required="required"
					class="form-control" value="${item.pPrice}"></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><textarea rows="3" name="detail" required="required"
						class="form-control">${item.pDetail}</textarea> <!-- <input type="text" name="detail" required="required"
					class="form-control"> --></td>
			</tr>
			<tr>
				<td>파일첨부</td>
				<td><input type="file" name="filename1" size=40>
				<br> 현재 파일 : ${item.img}<br> <img
					src="../../img/${item.img}" style="height: 45px;"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><select name="cat_code" class="form-control">
						<option value="1">소설</option>
						<option value="2">에세이</option>
						<option value="3">etc</option>
				</select></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input class="form-control" type="hidden"
					name="pid" required="required" value="${item.pId}"><input
					class="btn btn-default" type="submit" value="수정">
				<button class="btn btn-default" onclick="javascript:Home()" type="button" >돌아가기</button></td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="/view/shop_footer.jsp"%>
