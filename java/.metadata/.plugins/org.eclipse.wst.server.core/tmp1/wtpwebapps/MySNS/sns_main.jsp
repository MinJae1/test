<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sns" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sns</title>
<link rel="stylesheet" href="css/sns_design.css" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	function newuser() {
		window
				.open(
						"new_user.jsp",
						"newuser",
						"titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=300,height=240")
	}
</script>
<script>
	$(function() {
		$("#accordion").accordion({
			heightStyle : "content"
		});
	});
</script>


</head>
<body>
	<header>
		<div class="container1">
			<h1>SNS Project</h1>
		</div>
	</header>
	<nav>
		<div class="menu">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="javascript:newuser()">New User</a></li>
				<li><a href="sns_control.jsp?action=getall">List</a></li>
				<li><sns:login></sns:login></li>

			</ul>
		</div>
	</nav>

	<div id="wrapper">
		<section id="main">
			<section id="content">
				<b>My news Update</b>
				<form class="m_form" method="post"
					action="sns_control.jsp?action=newmsg">
					<input type="hidden" name="uid" value="${uid}">
					<sns:write type="msg"></sns:write>
					<button class="submit" type="submit">submit</button>
				</form>
				<br>
				<br>
				<h3>New Social Data</h3>

				<div id="accordion">
					<c:forEach varStatus="mcnt" var="msgs" items="${datas}">
						<c:set var="m" value="${msgs.messageDO}" />
						<h3>[${m.name}] ${m.msg} :: [like ${m.favcount} | reply
							${m.replycount}]</h3>
						<div>
							<p></p>
							<p>
								<sns:smenu mid="${m.mid}" auid="${m.uid}" curmsg="${mcnt.index}" />
								/ write in ${m.date}
							</p>

							<ul class="reply">
								<c:forEach var="r" items="${msgs.rlist}">
									<li>${r.name}::${r.rmsg} - ${r.date} <sns:rmenu
											curmsg="${mcnt.index}" rid="${r.rid}" ruid="${r.uid}" /></li>
								</c:forEach>
							</ul>

							<form action="sns_control.jsp?action=newreply&cnt=${cnt}"
								method="post">
								<input type="hidden" name="mid" value="${m.mid}"> <input
									type="hidden" name="uid" value="${uid}"> <input
									type="hidden" name="suid" value="${suid}"> <input
									type="hidden" name="curmsg" value="${mcnt.index}">
								<sns:write type="rmsg" />
							</form>
						</div>
					</c:forEach>
				</div>
				<div align="center">
					<a href="sns_control.jsp?action=getall&cnt=${cnt+5} &suid=${suid}">more&gt;&gt;</a>
				</div>

			</section>
			<aside id="sidebar2">
				<!-- sidebar2 -->
				<h2>New Friends!!</h2>

				<c:forEach items="${nusers}" var="n">
					<ul>
						<li><a href="sns_control.jsp?action=getall&suid=${n.uid}">${n.name}</a></li>
					</ul>
				</c:forEach>
				<br>
				<br>
				<h3>We're Social Tool!!</h3>
				<img src="images/facebook_32.png"> <img
					src="images/twitter_32.png"> <img src="images/youtube_32.png">
				<br>
				<br>
				<br>
				<br>

				<h3>Links</h3>
				<ul>
					<li><a href="#">한빛미디어</a></li>
					<li><a href="#">가천대학교</a></li>
					<li><a href="#">가천대학교 길병원</a></li>
				</ul>

			</aside>
			<!-- end of sidebar -->
		</section>
	</div>
	<footer>

		<div class="container1">
			<section id="footer-area">

				<section id="footer-outer-block">
					<aside class="footer-segment">
						<h4>About</h4>
						<ul>
							<li><a href="#">About My Simple SNS</a></li>
							<li><a href="#">Copyright</a></li>
							<li><a href="#">Author</a></li>
						</ul>
					</aside>
					<!-- end of #first footer segment -->

					<aside class="footer-segment">
						<h4>Java Web Programming</h4>
						<ul>
							<li><a href="#">Book Information</a></li>
							<li><a href="#">Table of contents</a></li>
							<li><a href="#">Book History</a></li>
						</ul>
					</aside>
					<!-- end of #second footer segment -->

					<aside class="footer-segment">
						<h4>Contact Us</h4>
						<ul>
							<li><a href="#">Book Support</a></li>
							<li><a href="#">Publication</a></li>
							<li><a href="#">Investor Relations</a></li>
						</ul>
					</aside>
					<!-- end of #third footer segment -->

					<aside class="footer-segment">
						<h4></h4>
						<p>
							&copy; 2018 <a href="#"></a>
						</p>
					</aside>
					<!-- end of #fourth footer segment -->

				</section>
				<!-- end of footer-outer-block -->

			</section>
			<!-- end of footer-area -->
		</div>
	</footer>
</body>
</html>