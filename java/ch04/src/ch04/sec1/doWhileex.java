package ch04.sec1;

import java.util.Scanner;

public class doWhileex {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num;
		
		System.out.println("�޼��� �Է� Ƚ���� ���Ͻÿ�");
		num = scanner.nextInt();
		
		System.out.println("�޼����� �Է��ϼ���(q�� ���α׷� ����)("+num+"ȸ �Է°���)");

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
		System.out.println("����");
		scanner.close();

	}
}
