<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>
<%@ page import="java.util.*,ezenMall.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memdao" class="ezenMall.MemberDAO" />
<jsp:useBean id="memdo" class="ezenMall.MemberDO" />
<jsp:setProperty property="*" name="memdo" />
<%
	String cPath = request.getContextPath();
	String action = request.getParameter("action");

	switch (action) {
	case "join":
		response.sendRedirect(cPath + "/view/user/new_user.jsp");
		break;

	case "new":
		String pw = request.getParameter("passwd");
		String pwcheck = request.getParameter("pwcheck");

		if (!pw.equals(pwcheck)) {
			out.println(
					"<script>alert('Password id not correct');history.go(-1);</script>");
		} else {
			if (memdao.addMember(memdo)) {
				out.println("<script>alert('Join is Success. Login Please!');"
						+ " document.location.href = '" + cPath
						+ "/view/control/shop_control.jsp?action=getall&cc=0&pageno=1' </script>");
				/* response.sendRedirect("shop_control.jsp?action=getall"); */
			} else {
				out.println(
						"<script>alert('Same ID exists!');history.go(-1);</script>");
			}
		}

		break;

	case "login":

		if (memdao.login(memdo.getUid(), memdo.getPasswd())) {
			session.setAttribute("uid", memdo.getUid());

			String nm = memdao.getName(memdo.getUid());
			session.setAttribute("name", nm);

			int code = memdao.getCode(memdo.getUid());
			session.setAttribute("code", code);

			int cid = memdao.getCid(memdo.getUid());
			session.setAttribute("cid", cid);

			response.sendRedirect(cPath+"/view/control/shop_control.jsp?action=getall&cc=0&pageno=1");
		} else {
			out.println(
					"<script>alert('ID or Password is not correct');history.go(-1);</script>");
		}

		break;

	case "logout":
		session.removeAttribute("uid");
		session.removeAttribute("name");
		session.removeAttribute("cid");
		session.setAttribute("code", 0);

		response.sendRedirect(cPath+"/view/control/shop_control.jsp?action=getall&cc=0&pageno=1");
		break;

	default:
		out.println("<script>alert('Check action parameter!!!')</script>");
		break;
	}
%>