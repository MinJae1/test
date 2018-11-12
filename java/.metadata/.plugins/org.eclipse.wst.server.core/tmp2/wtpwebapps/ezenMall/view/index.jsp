<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String cPath = request.getContextPath();

	response.sendRedirect("control/shop_control.jsp?action=getall&cc=0&pageno=1");
%>