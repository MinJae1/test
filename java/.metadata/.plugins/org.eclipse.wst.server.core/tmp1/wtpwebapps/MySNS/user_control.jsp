<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,mysns.*,java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memdao" class="mysns.member.MemberDAO" />
<jsp:useBean id="memdo" class="mysns.member.MemberDO" />
<jsp:setProperty property="*" name="memdo" />
<%
	String action = request.getParameter("action");

	switch (action) {
	case "new":
		if (memdao.addMember(memdo)) {
			out.println(
					"<script>alert('Join is Success. Login Please!');window.close();</script>");
		} else {
			out.println(
					"<script>alert('Same ID exists!');history.go(-1);</script>");
		}

		break;

	case "login":

		if (memdao.login(memdo.getUid(), memdo.getPasswd())) {
			session.setAttribute("uid", memdo.getUid());
			String nm = memdao.getName(memdo.getUid());
			session.setAttribute("name", nm);
			response.sendRedirect("sns_control.jsp?action=getall");
		} else {
			out.println(
					"<script>alert('ID or Password is not correct');history.go(-1);</script>");
		}

		break;

	case "logout":
		session.removeAttribute("uid");
		response.sendRedirect("sns_control.jsp?action=getall");
		break;

	default:
		out.println("<script>alert('Check action parameter!!!')</script>");
		break;
	}
%>