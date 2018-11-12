<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>
<script type="text/javascript">
function detail(cid) {
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=corderlist&pageno=1&cid=" + cid;
}

</script>

<script type="text/javascript">
function adminGoTo(pno) {
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=userlist&pageno="+pno;
}

</script>



<br>
<div align="center" class="panel panel-default">
	<div class="panel-heading">고객목록</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>no</th>
				<th>ID</th>
				<th>이름</th>
				<th>E-mail</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach varStatus="ccnt" var="c" items="${clist}">
				<tr onclick="javascript:detail(${c.id})">
					<td>${ccnt.index+1}</td>
					<td>${c.uid}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div align="center">
	<jsp:include page="../admin_paging.jsp" flush="true"></jsp:include></div>
<%@ include file="/view/shop_footer.jsp"%>
