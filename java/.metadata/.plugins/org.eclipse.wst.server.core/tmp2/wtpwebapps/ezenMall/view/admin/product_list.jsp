
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>

<script type="text/javascript">
function pInsert() {
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=productinsert";
}

function page(pno) {
	document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=productlist&pageno="+pno;
	}
	
	function modify(pid) {
		document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=productmod&pid="+pid;
	}
	
	function del(pid) {
		document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=productdel&pid="+pid;
	}

	
	
</script>

<div align="right">
	<button type="button" class="btn btn-default"
		onclick="javascript:pInsert()">상품등록</button>
</div>

<div>
	<table class="table">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>카테고리</th>
				<th width="150"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="msgs" items="${plist}" varStatus="mcnnt">
				<tr>
					<td>${msgs.pId}</td>
					<td height="80" width="80" align="center"><img
						src="../../img/${msgs.img}" style="height: 80px;"></td>
					<td>${msgs.pName}</td>
					<td><fmt:formatNumber value="${msgs.pPrice}"
							pattern="###,###,###" /></td>
					<td><c:choose>
							<c:when test="${msgs.code == 1}">소설</c:when>
							<c:when test="${msgs.code == 2}">에세이</c:when>
							<c:when test="${msgs.code == 3}">Etc.</c:when>
						</c:choose></td>
					<td><button class="btn btn-default"
							onclick="javascript:modify(${msgs.pId})">수정</button>
						<button class="btn btn-default" onclick="javascript:del(${msgs.pId})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div align="center">
	<div class="paginate">
		<c:set value="${pageArray}" var="page"></c:set>
		<%-- 
	("prev_pageno", pageNo[0])
	("page_sno", pageNo[1])
	("page_eno", pageNo[2])
	("next_pageno", pageNo[3])
	("total_page", pageNo[4])
	("record_start_no", pageNo[5])
	("record_end_no", pageNo[6])
	("group_no", pageNo[7])
	 --%>
		<nav>
			<ul class="pagination">

				<li class="<c:if test="${page[7] eq page[1]}">disabled</c:if>"><a
					href="javascript:page(1)" aria-label="home"><span
						aria-hidden="true">&laquo;</span></a></li>
				<li class="<c:if test="${page[7] eq page[1]}">disabled</c:if>"><a
					href="javascript:page(${page[0]})" aria-label="pre"><span
						aria-hidden="true">&lt;</span></a></li>
				<c:forEach begin="${page[1]}" end="${page[2]}" step="1" var="p">
					<c:choose>
						<c:when test="${currentPage==p}">
							<li class="active"><a href="javascript:page(${p})">${p}<span
									class="sr-only">(current)</span></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:page(${p})">${p}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="<c:if test="${page[4] eq page[2]}">disabled</c:if>"><a
					href="javascript:page(${page[3]})" aria-label="Next"><span
						aria-hidden="true">&gt;</span></a></li>
				<li class="<c:if test="${page[4] eq page[2]}">disabled</c:if>"><a
					href="javascript:page(${page[4]})" aria-label="End"><span
						aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
	</div>
</div>

<%@ include file="/view/shop_footer.jsp"%>

