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
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4. ����");
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *");
			System.out.print("���� : ");

			sel = scanner.nextInt();

			if (sel == 1) {
				System.out.print("���ݾ� : ");
				balance += scanner.nextInt();
				System.out.println();
			} else if (sel == 2) {
				System.out.print("��й�ȣ(�ʱ� ��й�ȣ�� 1234) : ");
				code = scanner.nextInt();
				if (code == pass) {
					System.out.print("��ݾ� : ");
					out = scanner.nextInt();
					if (balance < out) {
						System.out.println("�ܾ��� �����մϴ�.");
					} else {
						balance -= out;
					}
					System.out.println();
				} else {
					System.out.println("��й�ȣ�� Ʋ���ϴ�");
					System.out.println();
				}
			} else if (sel == 3) {
				System.out.println("�ܾ� : " + balance);
				System.out.println();
			} else if (sel == 4) {
				run = false;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

		}
		System.out.println();
		System.out.println("���α׷� ����");
		scanner.close();
	}

}
