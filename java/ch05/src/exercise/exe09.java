package exercise;

import java.util.Scanner;

public class exe09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int studentnum = 0;
		int[] scores = null;
		int sum = 0;
		double avg;

		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
			System.out.println("1.�л��� | 2.�����Է� | 3.��������Ʈ | 4.�м� | 5. ����");
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
			System.out.print("���� : ");

			int sel = scanner.nextInt();

			if (sel == 1) {
				System.out.print("�л��� : ");
				studentnum = scanner.nextInt();
				scores = new int[studentnum];
				System.out.println();
			} else if (sel == 2) {
				if (studentnum == 0) {
					System.out.println("�л����� ���� �Է��� �ּ���");
				} else {
					System.out.println("�����Է�");
					for (int i = 0; i < studentnum; i++) {
						System.out.print("score[" + i + "] : ");
						scores[i] = scanner.nextInt();
					}
				}
				System.out.println();
			} else if (sel == 3) {
				if (studentnum == 0) {
					System.out.println("�л����� ���� �Է��� �ּ���");
				} else if (scores == null) {
					System.out.println("��������Ʈ�� �����ϴ�.");
				} else {
					System.out.println("��������Ʈ");
					for (int i = 0; i < studentnum; i++) {
						System.out.println("score[" + i + "] : " + scores[i]);
					}
				}
				System.out.println();
			} else if (sel == 4) {
				if (studentnum == 0) {
					System.out.println("�л����� ���� �Է��� �ּ���");
				} else if (scores.length == 0) {
					System.out.println("��������Ʈ�� �����ϴ�.");
				} else {
					System.out.println("�м�");
					for (int i = 0; i < studentnum; i++) {
						sum += scores[i];
					}
					avg = (double) sum / studentnum;
					System.out.println("���� : " + sum);
					System.out.println("��� : " + avg);
					System.out.println();
				}
			} else if (sel == 5) {
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
