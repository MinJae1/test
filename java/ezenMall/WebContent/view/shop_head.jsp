<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>
<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ezenMall</title>
<link href="http://fonts.googleapis.com/earlyaccess/notosanskr.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<%
	String cPath = request.getContextPath();
%>

<script>
	function newuser() {
		document.location.href = "<%=cPath%>/view/control/user_control.jsp?action=join";
	}
</script>

</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/view/control/shop_control.jsp?action=getall&code=${code}&cc=0&pageno=1">Shop
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="${pageContext.request.contextPath}/view/control/shop_control.jsp?action=getall&code=${code}&cc=0&pageno=1">Home</a></li>
					<li><a href="javascript:newuser()">New User</a></li>
				</ul>

				<shop:login></shop:login>
				<c:choose>
					<c:when test="${code == 1}">

						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">관리자
									메뉴 <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a
										href="${pageContext.request.contextPath}/view/control/admin_control.jsp?action=userlist&pageno=1">고객목록</a></li>
									<li><a
										href="${pageContext.request.contextPath}/view/control/admin_control.jsp?action=orderlist&pageno=1&listcode=1&datepicker=">일단위
											상품별 주문내역</a></li>
									<li><a
										href="${pageContext.request.contextPath}/view/control/admin_control.jsp?action=orderlist&pageno=1&listcode=2&datepicker=">일단위
											고객별 판매내역</a></li>
									<li><a
										href="${pageContext.request.contextPath}/view/control/admin_control.jsp?action=productinsert">상품등록</a></li>
								</ul></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul class="nav navbar-nav navbar-right">
							<li><a
								href="${pageContext.request.contextPath}/view/control/shop_control.jsp?action=cartList&cid=${cid}">장바구니</a></li>
							<li><a
								href="${pageContext.request.contextPath}/view/control/shop_control.jsp?action=orderHis&cid=${cid}">주문내역</a></li>
						</ul>

					</c:otherwise>
				</c:choose>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>