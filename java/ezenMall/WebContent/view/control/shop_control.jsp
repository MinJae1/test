
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../../error/error.jsp"%>
<%@ page import="java.util.*,ezenMall.*,java.text.SimpleDateFormat"%>
<%@ page import="java.io.*"%>
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
	String cPath = request.getContextPath();

	String action = request.getParameter("action");

	SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

	String savePath = request.getServletContext().getRealPath("/img");

	switch (action) {

	case "detail": //상품상세페이지
		int cid5 = Integer.valueOf(request.getParameter("cid"));
		request.setAttribute("cid", cid5);
		int pid = Integer.valueOf(request.getParameter("pid"));
		ProductDO item = sdao.getItem(pid);
		request.setAttribute("item", item);
		request.setAttribute("root", savePath);

		pageContext.forward("../shop/product_detail.jsp");

		break;

	case "getall"://상품목록
		int cat_code = Integer.valueOf(request.getParameter("cc"));

		String img_name = sdao.getImgName();

		String path = "D:\\Work Space\\java\\ezenMall\\WebContent\\img";

		File file = new File(path + "\\" + img_name);

		if (!file.isFile()) {

			FileInputStream fis = null;
			FileOutputStream fos = null;

			try {
				fis = new FileInputStream(savePath + "\\" + img_name); // 원본파일
				fos = new FileOutputStream(path + "\\" + img_name); // 복사위치

				byte[] buffer = new byte[1024];
				int readcount = 0;

				while ((readcount = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, readcount); // 파일 복사 

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				fis.close();
				fos.close();

			}
		}
		int pageno = Integer.valueOf(request.getParameter("pageno"));
		int total = sdao.getitemCount(cat_code);

		int pageNo[] = sdao.paging_fn(pageno, total, 6);

		ArrayList<ProductDO> plist = sdao.getItemList(cat_code, (pageNo[5] - 1),
				6);
		request.setAttribute("plist", plist);

		request.setAttribute("pageArray", pageNo);
		request.setAttribute("cat", cat_code);

		pageContext.forward("../shop/shop_main.jsp");

		break;

	case "cart": //장바구니담기
		int cid = Integer.valueOf(request.getParameter("cid"));
		sdao.orderMake(cid);

		int pid2 = Integer.valueOf(request.getParameter("pid"));
		int quantity = Integer.valueOf(request.getParameter("q"));

		int chkQ = sdao.checkCart(pid2);

		if (chkQ != 0) {
			quantity = quantity + chkQ;
			sdao.updateQuantity(pid2, quantity);
		} else {
			ProductDO cartI = new ProductDO();

			cartI.setpId(pid2);
			cartI.setpQuantity(quantity);

			sdao.inCart(cartI);
		}

		pageContext.forward(
				"../control/shop_control.jsp?action=getall&cc=0&pageno=1");
		break;

	case "cartList"://장바구니리스트
		if (request.getParameter("cid").equals("")) {
			out.println("<script>alert('로그인 해주세요!');history.go(-1);</script>");
		} else {
			int cid2 = Integer.valueOf(request.getParameter("cid"));
			ArrayList<OrderDO> cartList = sdao.CartList(cid2);
			request.setAttribute("cartList", cartList);

			pageContext.forward("../shop/cart.jsp");
		}
		break;

	case "delete"://장바구니 상품 삭제

		String o = request.getParameter("oid");
		String[] temp = o.split(",");

		int[] oid_list = new int[temp.length];
		int i = 0;

		while (i < temp.length) {
			oid_list[i] = Integer.valueOf(temp[i]);
			i++;
		}

		for (int val_oid : oid_list) {
			sdao.deleteCart(val_oid);
		}
		//		out.println("<script>alert('삭제되었습니다.')</script>");
		//		pageContext.forward("shop_control.jsp?action=cartList");
		int cid2 = Integer.valueOf(request.getParameter("cid"));

		request.setAttribute("message", "삭제되었습니다.");
		request.setAttribute("returnUrl",
				"shop_control.jsp?action=cartList&cid=" + cid2 + "");
		pageContext.forward("../alertjsp.jsp");

		//out.println("<script>alert('삭제되었습니다.'); document.location.href = '../control/shop_control.jsp?action=cartList'; </script>");

		break;

	case "selOrder"://상품 주문
		String o2 = request.getParameter("oid");
		String[] temp2 = o2.split(",");

		int[] oid_list2 = new int[temp2.length];
		int j = 0;

		while (j < temp2.length) {
			oid_list2[j] = Integer.valueOf(temp2[j]);
			j++;
		}

		for (int val_oid : oid_list2) {
			sdao.update(val_oid, oid_list2[0]);
		}

		for (int val_oid : oid_list2) {
			sdao.updatePrice(val_oid);
		}
		sdao.arrageOrder();
		//pageContext.forward("../control/shop_control.jsp?action=getall");

		request.setAttribute("message", "주문되었습니다.");
		request.setAttribute("returnUrl",
				"../control/shop_control.jsp?action=getall&cc=0&pageno=1");
		pageContext.forward("../alertjsp.jsp");
		break;

	case "orderHis": //주문내역
		if (request.getParameter("cid").equals("")) {
			out.println("<script>alert('로그인 해주세요!');history.go(-1);</script>");
		} else {
			int cid3 = Integer.valueOf(request.getParameter("cid"));
			ArrayList<OrderDO> order = sdao.OrderHistory(cid3);
			request.setAttribute("order", order);

			pageContext.forward("../shop/order.jsp");
		}
		break;

	case "orderdetail"://주문상세페이지
		int oid = Integer.valueOf(request.getParameter("oid"));
		ArrayList<OrderDO> orderDetail = sdao.OrderDetail(oid);
		request.setAttribute("orderDetail", orderDetail);

		pageContext.forward("../shop/order_detail.jsp");
		break;

	case "order"://바로주문
		int cid4 = Integer.valueOf(request.getParameter("cid"));
		sdao.orderMake(cid4);

		int pid3 = Integer.valueOf(request.getParameter("pid"));
		int quantity2 = Integer.valueOf(request.getParameter("q"));

		ProductDO orderI = new ProductDO();

		orderI.setpId(pid3);
		orderI.setpQuantity(quantity2);
		sdao.inCart(orderI);

		int orderNo = sdao.getOrderNm();

		sdao.update(orderNo, orderNo);
		sdao.updatePrice(orderNo);

		pageContext.forward("../control/shop_control.jsp?action=orderHis");
		break;

	default:
		out.println("<script>alert('Check action parameter!!!')</script>");
		break;
	}
%>

