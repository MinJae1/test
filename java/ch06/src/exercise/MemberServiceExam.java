package exercise;

import java.util.Scanner;

public class MemberServiceExam {
	public static void main(String[] args) {
		MemberService service = new MemberService();
		String id, pass;
		Scanner scan = new Scanner(System.in);
		System.out.println("아이디와 비밀번호를 입력하시오.");
		System.out.print("id > ");
		id = scan.nextLine();
		System.out.print("password > ");
		pass = scan.nextLine();

		boolean result = service.login(id, pass);

		if (result) {
			System.out.println("login");
			service.logout(id);
		} else {
			System.out.println("Invalid ID or password");
		}

		scan.close();
	}
}
