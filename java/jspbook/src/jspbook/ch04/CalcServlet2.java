package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet2
 */
@WebServlet("/CalcServlet2")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet2() {
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
		int n1, n2;
		int res;
		String op;

		n1 = Integer.parseInt(request.getParameter("num1"));
		n2 = Integer.parseInt(request.getParameter("num2"));

		op = request.getParameter("operator");

		Calc calc = new Calc(n1, n2, op);
		res = calc.getResult();

		response.setContentType("text/html;charset=utf-8");

		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<head><title>Calculator</title></head>");
		printWriter.println("<body><h2>Answer</h2>");
		printWriter.println("<hr>");
		printWriter.println(n1 + " " + op + " " + n2 + " = " + res);
		printWriter.println("</body></html>");

	}

}
