<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String cPath = request.getContextPath();
%>

<script type="text/javascript">
function cat(code) {
	document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=getall&cc="+code+"&pageno=1";
}
</script>

<form class="navbar-form navbar-left" name="loginform" method="post"
	action="user_control.jsp">

	<c:choose>
		<c:when test="${code == 1}">
			<div align="center">
				<button type="button" class="btn btn-default btn-lg"
					style="width: 250px; height: 250px" onclick="javascript:userlist()">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					<br>
					고객목록
				</button>
				<button type="button" class="btn btn-default btn-lg"
					style="width: 250px; height: 250px" onclick="javascript:dplist()">
					<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
					<br>
					일단위
					<br>
					상품별 주문내역
				</button>
				<button type="button" class="btn btn-default btn-lg"
					style="width: 250px; height: 250px" onclick="javascript:odList()">
					<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
					<br>
					일단위
					<br>
					고객별 판매내역
				</button>
				<button type="button" class="btn btn-default btn-lg"
					style="width: 250px; height: 250px" onclick="javascript:pList()">
					<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
					<br>
					상품관리
				</button>

			</div>
		</c:when>

		<c:otherwise>
			<c:choose>
				<c:when test="${cnt == 0}">

					<div align="center">
						<span>상품을 준비중 입니다.</span>
					</div>

				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-md-2">
							<div class="list-group" style="position:fixed;top: 100px; left: 35px;">
								<a href="#" class="list-group-item active"> Category </a> <a
									href="javascript:cat(1)" class="list-group-item">소설</a> <a
									href="javascript:cat(2)" class="list-group-item">에세이</a> <a
									href="javascript:cat(3)" class="list-group-item">Etc</a>
							</div>
						</div>
						<div class="col-md-10">
							<div align="center" class="row">
								<c:forEach var="msgs" items="${plist}" varStatus="mcnnt">
									<div class="col-md-4">
										<table class="table"
											onclick="javascript:detail(${msgs.pId},${cid})">
											<thead>
												<tr>
													<th>${msgs.pName}</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td height="200" width="200" align="center"><img
														src="../../img/${msgs.img}" style="height: 200px;"></td>
												</tr>
												<tr>
													<td><fmt:formatNumber value="${msgs.pPrice}"
															pattern="###,###,###" /></td>
												</tr>
											</tbody>
										</table>
									</div>
								</c:forEach>

								<c:if test="${fn:length(plist) < 6}">
									<c:forEach begin="${fn:length(plist)}"
										end="${6 - (fn:length(plist))}" step="1">
										<div class="col-md-4">
											<table class="table" style="visibility: hidden">
												<thead>
													<tr>
														<th>제목</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td height="110" width="200" ></td>
													</tr>
													<tr>
														<td>가격</td>
													</tr>
											</table>
										</div>
									</c:forEach>
								</c:if>
							</div>
						</div>
						<div align="center">
							<jsp:include page="../../view/paging.jsp" flush="true"></jsp:include></div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</form>
