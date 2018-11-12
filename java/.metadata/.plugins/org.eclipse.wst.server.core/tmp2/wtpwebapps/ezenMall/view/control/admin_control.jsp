
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>
<%@ page import="java.util.*,ezenMall.*"%>
<%@ page
	import="java.text.SimpleDateFormat,com.oreilly.servlet.MultipartRequest"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="pdo" class="ezenMall.ProductDO" />
<jsp:useBean id="sdao" class="ezenMall.SaleDAO" />
<jsp:setProperty property="*" name="sdao" />

<jsp:useBean id="memdao" class="ezenMall.MemberDAO" />
<jsp:useBean id="memdo" class="ezenMall.MemberDO" />
<jsp:setProperty property="*" name="memdo" />

<jsp:useBean id="odo" class="ezenMall.OrderDO" />
<jsp:setProperty property="*" name="odo" />

<%
	String action = request.getParameter("action");

	SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

	String savePath = request.getServletContext().getRealPath("/img");

	switch (action) {

	//////////////////////////관리자

	case "userlist":
		int pageno1 = Integer.valueOf(request.getParameter("pageno"));
		int userCnt = memdao.getCustomerListCnt();

		int pageNo1[] = sdao.paging_fn(pageno1, userCnt, 10);

		ArrayList<MemberDO> clist = memdao.getCustomerList((pageNo1[5] - 1), 10);
		request.setAttribute("clist", clist);

		request.setAttribute("pageArray", pageNo1);

		pageContext.forward("../admin/user_list.jsp");
		break;

	case "orderlist":
		int pageno2 = Integer.valueOf(request.getParameter("pageno"));

		int lcode = Integer.valueOf(request.getParameter("listcode"));
		request.setAttribute("lcode", lcode);

		String date = request.getParameter("datepicker");

		if (date.equals("")) {
			date = dateform.format(new Date());
		}

		if (lcode == 1) {
			int dpCnt = sdao.dPerProductsCnt(date);
			if (dpCnt == 0) {
				dpCnt = 1;
			}
			int pageNo2[] = sdao.paging_fn(pageno2, dpCnt, 10);

			ArrayList<OrderDO> dpList = sdao.dPerProducts(date, (pageNo2[5] - 1),
					10);
			request.setAttribute("dplist", dpList);

			request.setAttribute("pageArray", pageNo2);
		} else {
			int odCnt = sdao.dPerProductsCnt(date);
			if (odCnt == 0) {
				odCnt = 1;
			}
			int pageNo3[] = sdao.paging_fn(pageno2, odCnt, 10);

			ArrayList<OrderDO> odList = sdao.dPerOrders(date, (pageNo3[5] - 1),
					10);
			request.setAttribute("odList", odList);

			request.setAttribute("pageArray", pageNo3);
		}

		request.setAttribute("dp", date);

		pageContext.forward("../admin/order_list.jsp");
		break;

	case "corderlist":
		int pageno3 = Integer.valueOf(request.getParameter("pageno"));
		int cid6 = Integer.valueOf(request.getParameter("cid"));
		int coCnt = sdao.customerOrdersCnt(cid6);
		int pageNo4[] = sdao.paging_fn(pageno3, coCnt, 10);

		ArrayList<OrderDO> ocList = sdao.customerOrders(cid6, (pageNo4[5] - 1),
				10);
		request.setAttribute("ocList", ocList);
		request.setAttribute("cid", cid6);
		request.setAttribute("pageArray", pageNo4);

		pageContext.forward("../admin/orderByc_list.jsp");
		break;

	case "productlist":

		int pageno = Integer.valueOf(request.getParameter("pageno"));
		int total = sdao.getitemCount(0);

		int pageNo[] = sdao.paging_fn(pageno, total, 6);

		ArrayList<ProductDO> plist = sdao.getItemList(0, (pageNo[5] - 1), 6);
		request.setAttribute("plist", plist);
		request.setAttribute("pageArray", pageNo);

		pageContext.forward("../admin/product_list.jsp");
		break;

	case "productinsert":

		pageContext.forward("../admin/insert_product.jsp");
		break;

	case "new":
		String filename1 = "";
		int maxSize = 1024 * 1024 * 5;

		ProductDO proDo = new ProductDO();

		try {
			MultipartRequest multi = new MultipartRequest(request, savePath,
					maxSize);

			Enumeration<?> files = multi.getFileNames();
			String file1 = (String) files.nextElement();
			if (multi.getFilesystemName(file1) == null
					|| multi.getFilesystemName(file1).equals("")) {
				filename1 = "";
			} else {
				filename1 = multi.getFilesystemName(file1);
			}
			filename1 = new String(filename1.getBytes("8859_1"), "UTF-8"); // 한글인코딩 - 브라우져에 출력
			String name = new String(
					multi.getParameter("name").getBytes("8859_1"), "UTF-8");
			int price = Integer.valueOf(multi.getParameter("price"));
			String detail = new String(
					multi.getParameter("detail").getBytes("8859_1"), "UTF-8");
			int code = Integer.valueOf(multi.getParameter("cat_code"));

			proDo.setpName(name);
			proDo.setpDetail(detail);
			proDo.setImg(filename1);
			proDo.setpPrice(price);
			proDo.setCode(code);

			sdao.addProduct(proDo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("message", "등록되었습니다.");
		request.setAttribute("returnUrl",
				"../control/admin_control.jsp?action=productlist&pageno=1");
		pageContext.forward("../alertjsp.jsp");
		break;

	case "productmod":
		int pid = Integer.valueOf(request.getParameter("pid"));
		ProductDO item = sdao.getItem(pid);
		request.setAttribute("item", item);

		pageContext.forward("../admin/product_modify.jsp");
		break;

	case "modify":
		String filename2 = "";
		int maxSize1 = 1024 * 1024 * 5;

		ProductDO proDo2 = new ProductDO();

		try {
			MultipartRequest multi = new MultipartRequest(request, savePath,
					maxSize1);

			Enumeration<?> files = multi.getFileNames();
			String file1 = (String) files.nextElement();
			if (multi.getFilesystemName(file1) == null
					|| multi.getFilesystemName(file1).equals("")) {
				filename2 = "";
			} else {
				filename2 = multi.getFilesystemName(file1);
			}
			filename2 = new String(filename2.getBytes("8859_1"), "UTF-8"); // 한글인코딩 - 브라우져에 출력
			int id = Integer.valueOf(multi.getParameter("pid"));
			String name = new String(
					multi.getParameter("name").getBytes("8859_1"), "UTF-8");
			int price = Integer.valueOf(multi.getParameter("price"));
			String detail = new String(
					multi.getParameter("detail").getBytes("8859_1"), "UTF-8");
			int code = Integer.valueOf(multi.getParameter("cat_code"));

			proDo2.setpId(id);
			proDo2.setpName(name);
			proDo2.setpDetail(detail);
			proDo2.setImg(filename2);
			proDo2.setpPrice(price);
			proDo2.setCode(code);

			sdao.modProduct(proDo2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("message", "수정되었습니다.");
		request.setAttribute("returnUrl",
				"../control/admin_control.jsp?action=productlist&pageno=1");
		pageContext.forward("../alertjsp.jsp");
		break;

	case "productdel":
		int pid2 = Integer.valueOf(request.getParameter("pid"));

		sdao.delProduct(pid2);

		request.setAttribute("message", "삭제되었습니다.");
		request.setAttribute("returnUrl",
				"../control/admin_control.jsp?action=productlist&pageno=1");
		pageContext.forward("../alertjsp.jsp");
		break;

	case "download":
		ArrayList<OrderDO> Test = sdao.Test();
		request.setAttribute("test", Test);

		pageContext.forward("../admin/exceld.jsp");
		break;

	//////////////////////////관리자

	default:
		out.println("<script>alert('Check action parameter!!!')</script>");
		break;
	}
%>