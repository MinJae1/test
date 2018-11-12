<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>

<%@ include file="/view/shop_head.jsp"%>


<script type="text/javascript">
	function detail(pid, cid) {
		if (cid == null || cid == undefined) {
			cid = 0;
		}

		document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=detail&pid=" + pid
				+ "&cid=" + cid;
	}
	
	function userlist() {
		document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=userlist&pageno=1";
	}

	function dplist() {
		document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=orderlist&listcode=1&pageno=1&datepicker=";
	}

	function odList() {
		document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=orderlist&listcode=2&pageno=1&datepicker=";
	}
	
	function pList() {
		document.location.href = "<%=cPath%>/view/control/admin_control.jsp?action=productlist&pageno=0";
	}

	
	function goTo(code,pno) {
		document.location.href = "<%=cPath%>/view/control/shop_control.jsp?action=getall&cc="+code+"&pageno="+pno;
	}
	
</script>


<shop:list></shop:list>

<%@ include file="/view/shop_footer.jsp"%>
