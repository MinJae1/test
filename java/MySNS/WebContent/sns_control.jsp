<%@page import="mysns.member.MemberDO"%>
<%@page import="mysns.member.MemberDAO"%>
<%@page import="mysns.sns.MessageSet"%>
<%@page import="mysns.sns.MessageDO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,mysns.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="msgdo" class="mysns.sns.MessageDO" />
<jsp:useBean id="msgdao" class="mysns.sns.MessageDAO" />
<jsp:setProperty property="*" name="msgdo" />
<jsp:useBean id="reply" class="mysns.sns.Reply"></jsp:useBean>
<jsp:setProperty name="reply" property="*" />
<%
	String action = request.getParameter("action");
	String cnt = request.getParameter("cnt");
	String suid = request.getParameter("suid");

	String home;

	int mcnt;

	if ((cnt != null) && (suid != null)) {
		home = "sns_control.jsp?action=getall&cnt=" + cnt + "&suid=" + suid;
		mcnt = Integer.parseInt(request.getParameter("cnt"));
	} else {
		home = "sns_control.jsp?action=getall";

		mcnt = 5;
	}

	request.setAttribute("curmsg", request.getParameter("curmsg"));

	switch (action) {
	case "newmsg":

		if (msgdao.newMsg(msgdo)) {
			response.sendRedirect(home);
		} else {
			throw new Exception("Message registration error(insert)");
		}

		break;

	case "delmsg":
		if (msgdao.delMsg(msgdo.getMid()))
			response.sendRedirect(home);
		else
			throw new Exception("Message registration error(delete)");
		break;

	case "newreply":
		if (msgdao.newReply(reply)) {
			response.sendRedirect(home);
		} else {
			throw new Exception("Reply registration error(insert)");
		}

		break;

	case "delreply":

		if (msgdao.delReply(reply.getRid())) {
			response.sendRedirect(home);
		} else {
			throw new Exception("Reply registration error(delete)");
		}

		break;

	case "getall":
		ArrayList<MessageSet> datas = msgdao.getAll(mcnt, suid);
		ArrayList<MemberDO> nusers = new MemberDAO().getNewMember();
		request.setAttribute("datas", datas);
		request.setAttribute("nusers", nusers);

		request.setAttribute("suid", suid);
		request.setAttribute("cnt", mcnt);

		pageContext.forward("sns_main.jsp");

		break;

	case "fav":
		msgdao.favorite(msgdo.getMid());
		pageContext.forward(home);
		break;

	default:
		out.println("<script>alert('Check action parameter!!!')</script>");
		break;
	}
%>