package project;

import java.util.Scanner;

public class LoginApp {
	static MembetDAO mDAO = new MembetDAO();

	public void login() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>Login Test<<<<<<<<<<<<<<<<<<<");
		System.out.print("ID(Please enter numbers only.) >> ");
		int in_id = sc.nextInt();
		System.out.print("Password >> ");
		String in_pwd = sc.next();
		sc.close();

		mDAO.login(in_id, in_pwd);
		
	}
}
