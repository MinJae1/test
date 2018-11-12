<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>

<div align="center" class="panel panel-default">
	<div class="panel-heading">회원가입</div>
	<form action="<%=cPath%>/view/control/user_control.jsp?action=new" method="post">
		<table class="table">
			<tr>
				<td>이름</td>
				<td><input class="form-control" type="text" name="name" required="required"></td>
				<td></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="uid" required="required" class="form-control"></td>
				<td></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="email" name="email" required="required" class="form-control"></td>
				<td></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" id="passwd"
					required="required" class="form-control"></td>
				<td></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="pwcheck" id="pwcheck"
					required="required" class="form-control"></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td><input class="btn btn-default" type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="/view/shop_footer.jsp"%>