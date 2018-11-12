package ch04.sec1;

import java.util.Scanner;

public class doWhileex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num;
		
		System.out.println("메세지 입력 횟수를 정하시오");
		num = scanner.nextInt();
		
		System.out.println("메세지를 입력하세요(q는 프로그램 종료)("+num+"회 입력가능)");

		String inputstring;
		int cnt = 0;

		do {
			System.out.print("> ");
			inputstring = scanner.nextLine();
			System.out.println(inputstring);
			cnt++;
//			System.out.println(cnt);
		} while ((!inputstring.equals("q")) && cnt < num);

		System.out.println();
		System.out.println("종료");
		scanner.close();

	}
}
