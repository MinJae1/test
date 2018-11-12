package addressBook_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddrController
 */
@WebServlet("/AddrController")
public class AddrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddrDAO ab;
	AddrDTO addrbook;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddrController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action");
		RequestDispatcher rd;

		switch (action) {
		case "list":
			ArrayList<AddrDTO> datas = ab.getDBList();
			request.setAttribute("datas", datas);
			rd = request.getRequestDispatcher("addrbook_list.jsp");
			rd.forward(request, response);
//			pageContext.forward("addrbook_list.jsp");
			break;

		case "insert":
			if (ab.insertDB(addrbook)) {
				response.sendRedirect("addrbook_control.jsp?action=list");
			} else
				try {
					throw new Exception("DB 입력오류");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		case "edit":
			AddrDTO abook_e = ab.getDB(addrbook.getAb_id());
			if (!request.getParameter("upasswd").equals("1234")) {
				out.println("<script>alert('비밀번호가 틀렸습니다.!!');history.go(-1);</script>");
			} else {
				request.setAttribute("ab", abook_e);
				rd = request.getRequestDispatcher("addrbook_modify.jsp");
				rd.forward(request, response);
//				pageContext.forward("addrbook_edit_form.jsp");
			}
			break;

		case "update":
			if (ab.updateDB(addrbook)) {
				response.sendRedirect("addrbook_control.jsp?action=list");
			} else
				try {
					throw new Exception("DB 갱신오류");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;

		case "delete":
			AddrDTO abook_d = ab.getDB(addrbook.getAb_id());
			if (!request.getParameter("upasswd").equals("1234")) {
				out.println("<script>alert('비밀번호가 틀렸습니다.!!');history.go(-1);</script>");
			} else {
				if (ab.deleteDB(addrbook.getAb_id())) {
					response.sendRedirect("addrbook_control.jsp?action=list");
				} else
					try {
						throw new Exception("DB 삭제 오류");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			break;

		case "view":
			AddrDTO abook_v = ab.getDB(addrbook.getAb_id());
			request.setAttribute("ab", abook_v);
			rd = request.getRequestDispatcher("addrbook_view.jsp");
			rd.forward(request, response);
//			pageContext.forward("addrbook_view.jsp");
			break;

		case "search":
			String s = request.getParameter("sname");
			addrbook.setAb_name(s);
			ArrayList<AddrDTO> sdatas = ab.searchDBList(addrbook.getAb_name());
			request.setAttribute("sdatas", sdatas);
			rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
//			pageContext.forward("search.jsp");
			break;

		default:
			out.println("<script>alert('action 파라미터를 확인해 주세요!!!')</script>");
			break;
		}
	}

}
