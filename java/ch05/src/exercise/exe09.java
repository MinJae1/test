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
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5. 종료");
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
			System.out.print("선택 : ");

			int sel = scanner.nextInt();

			if (sel == 1) {
				System.out.print("학생수 : ");
				studentnum = scanner.nextInt();
				scores = new int[studentnum];
				System.out.println();
			} else if (sel == 2) {
				if (studentnum == 0) {
					System.out.println("학생수를 먼저 입력해 주세요");
				} else {
					System.out.println("점수입력");
					for (int i = 0; i < studentnum; i++) {
						System.out.print("score[" + i + "] : ");
						scores[i] = scanner.nextInt();
					}
				}
				System.out.println();
			} else if (sel == 3) {
				if (studentnum == 0) {
					System.out.println("학생수를 먼저 입력해 주세요");
				} else if (scores == null) {
					System.out.println("점수리스트가 없습니다.");
				} else {
					System.out.println("점수리스트");
					for (int i = 0; i < studentnum; i++) {
						System.out.println("score[" + i + "] : " + scores[i]);
					}
				}
				System.out.println();
			} else if (sel == 4) {
				if (studentnum == 0) {
					System.out.println("학생수를 먼저 입력해 주세요");
				} else if (scores.length == 0) {
					System.out.println("점수리스트가 없습니다.");
				} else {
					System.out.println("분석");
					for (int i = 0; i < studentnum; i++) {
						sum += scores[i];
					}
					avg = (double) sum / studentnum;
					System.out.println("총합 : " + sum);
					System.out.println("평균 : " + avg);
					System.out.println();
				}
			} else if (sel == 5) {
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
