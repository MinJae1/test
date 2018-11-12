package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputServlet() {
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
		int score1 = Integer.parseInt(request.getParameter("sc1"));
		int score2 = Integer.parseInt(request.getParameter("sc2"));
		int score3 = Integer.parseInt(request.getParameter("sc3"));
		int total = score1 + score2 + score3;
		double avg = (double) total / 3.0;

		response.setContentType("text/html;charset=utf-8");

		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<head><title>Calculator</title></head>");
		printWriter.println("<body><h2>Answer</h2>");
		printWriter.println("<hr>");
		printWriter.println(
				"<table><thead><tr><th>score1</th><th>score2</th><th>score3</th><th>Total</th><th>Average</th></tr></thead>");
		printWriter.println("<tbody><tr><td>" + score1 + "</td><td>" + score2
				+ "</td><td>" + score3 + "</td><td>" + total + "</td><td>" + avg
				+ "</td></tr></tbody></table>");
		printWriter.println("</body></html>");

	}

}
