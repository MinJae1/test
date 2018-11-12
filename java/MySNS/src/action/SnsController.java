package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SnsController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			doProcess(request,response);
	}  	
		
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			doProcess(request,response);
	}   	  	      	   
		
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
		 	throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/")+1;
		
		String command = requestURI.substring(cmdIdx);
		
		// URI, command Ȯ��
		//System.out.println("requestURI : "+requestURI);
		//System.out.println("command : "+command);
		
		ActionForward forward = null;
		Action action = null;
		
		String form = "new_user.jsp?contentPage=member/";
		
		try {
			if(command.equals("MainForm.do")) // ����ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath("MainForm.jsp");
			}
			else if(command.equals("LoginForm.do"))	// �α���ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"LoginForm.jsp");
			}
			else if(command.equals("JoinForm.do"))	// ȸ������ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"JoinForm.jsp");
			}
			else if(command.equals("UserInfoForm.do"))	// ������ Ŭ�� - ȸ������ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"UserInfoForm.jsp");
			}
			else if(command.equals("ModifyFrom.do")) // ȸ������ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"ModifyFrom.jsp");
			}
			else if(command.equals("DeleteForm.do")) // ȸ������ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"DeleteForm.jsp");
			}
			else if(command.equals("Result.do")) // ���� ó����� ȭ�� �̵�
			{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form+"ResultForm.jsp");
			}

			if(forward != null){
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end doProcess
}
