/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2018-11-09 01:05:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import ezenMall.*;
import java.text.SimpleDateFormat;
import com.oreilly.servlet.MultipartRequest;

public final class admin_005fcontrol_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1539927709679L));
    _jspx_dependants.put("jar:file:/D:/Work%20Space/java/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/ezenMall/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("ezenMall");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.oreilly.servlet.MultipartRequest");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"../../error/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

	request.setCharacterEncoding("utf-8");

      out.write("\r\n");
      out.write("\r\n");
      ezenMall.ProductDO pdo = null;
      pdo = (ezenMall.ProductDO) _jspx_page_context.getAttribute("pdo", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (pdo == null){
        pdo = new ezenMall.ProductDO();
        _jspx_page_context.setAttribute("pdo", pdo, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      ezenMall.SaleDAO sdao = null;
      sdao = (ezenMall.SaleDAO) _jspx_page_context.getAttribute("sdao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (sdao == null){
        sdao = new ezenMall.SaleDAO();
        _jspx_page_context.setAttribute("sdao", sdao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("sdao"), request);
      out.write("\r\n");
      out.write("\r\n");
      ezenMall.MemberDAO memdao = null;
      memdao = (ezenMall.MemberDAO) _jspx_page_context.getAttribute("memdao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (memdao == null){
        memdao = new ezenMall.MemberDAO();
        _jspx_page_context.setAttribute("memdao", memdao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      ezenMall.MemberDO memdo = null;
      memdo = (ezenMall.MemberDO) _jspx_page_context.getAttribute("memdo", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (memdo == null){
        memdo = new ezenMall.MemberDO();
        _jspx_page_context.setAttribute("memdo", memdo, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("memdo"), request);
      out.write("\r\n");
      out.write("\r\n");
      ezenMall.OrderDO odo = null;
      odo = (ezenMall.OrderDO) _jspx_page_context.getAttribute("odo", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (odo == null){
        odo = new ezenMall.OrderDO();
        _jspx_page_context.setAttribute("odo", odo, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("odo"), request);
      out.write("\r\n");
      out.write("\r\n");

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

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
