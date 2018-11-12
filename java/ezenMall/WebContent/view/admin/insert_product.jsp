<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>

<div align="center" class="panel panel-default">
	<div class="panel-heading">상품입력</div>
	<form method="post" enctype="multipart/form-data"
		action="<%=cPath%>/view/control/admin_control.jsp?action=new">
		<table class="table">
			<tr>
				<td>상품명</td>
				<td><input class="form-control" type="text" name="name"
					required="required"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" required="required"
					class="form-control"></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><textarea rows="3" name="detail" required="required"
					class="form-control"></textarea></td>
			</tr>
			<tr>
				<td>파일첨부</td>
				<td><input type="file" name="filename1" size=40></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><select name="cat_code" class="form-control">
						<option value="1">소설</option>
						<option value="2">에세이</option>
						<option value="3">etc</option>
				</select></td>
			</tr>
			<tr>

				<td colspan="2" align="right"><input class="btn btn-default" type="submit" value="상품등록"></td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="/view/shop_footer.jsp"%>
