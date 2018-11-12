package exercise;

import java.util.Scanner;

public class exer07 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean run = true;
		int balance = 0;
		int out;
		int sel, code;
		int pass = 1234;

		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4. 종료");
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *");
			System.out.print("선택 : ");

			sel = scanner.nextInt();

			if (sel == 1) {
				System.out.print("예금액 : ");
				balance += scanner.nextInt();
				System.out.println();
			} else if (sel == 2) {
				System.out.print("비밀번호(초기 비밀번호는 1234) : ");
				code = scanner.nextInt();
				if (code == pass) {
					System.out.print("출금액 : ");
					out = scanner.nextInt();
					if (balance < out) {
						System.out.println("잔액이 부족합니다.");
					} else {
						balance -= out;
					}
					System.out.println();
				} else {
					System.out.println("비밀번호가 틀립니다");
					System.out.println();
				}
			} else if (sel == 3) {
				System.out.println("잔액 : " + balance);
				System.out.println();
			} else if (sel == 4) {
				run = false;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

		}
		System.out.println();
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
