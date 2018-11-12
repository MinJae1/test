<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String inp_msg = request.getParameter("msg");

	Object username = session.getAttribute("user");

	ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

	if (msgs == null) {
		msgs = new ArrayList<String>();
		application.setAttribute("msgs", msgs);
	}

	msgs.add(username + " > " + inp_msg + " , " + new Date());

	application.log("add " + inp_msg);

	response.sendRedirect("twitter_list.jsp");
%>