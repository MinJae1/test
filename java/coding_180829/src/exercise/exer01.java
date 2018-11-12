package exercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class exer01 {
	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat(".##");

		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ������ ax^2 + bx + c = 0 �� ��� a,b,c�� ���ʷ� �Է��Ͻÿ�");
		double a, b, c;
		a = scanner.nextDouble();
		b = scanner.nextDouble();
		c = scanner.nextDouble();

		double ans1, ans2;

		ans1 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
		ans2 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;

		String str_ans1,str_ans2;
		
		str_ans1 = format.format(ans1);
		str_ans2 = format.format(ans2);
		
		if ((Math.pow(b, 2) - 4 * a * c) < 0) {
			System.out.println("�ذ� �������� �ʽ��ϴ�");
		} else if ((Math.pow(b, 2) - 4 * a * c) == 0) {
			System.out.println("������ (" + (int) a + ")x^2 + (" + (int) b + ")x + (" + (int) c + ") ��");
			System.out.println("�߱� " + str_ans1 + "�� �ط� ���´�.");
		} else {
			System.out.println("������ (" + (int) a + ")x^2 + (" + (int) b + ")x + (" + (int) c + ") ��");
			System.out.println(str_ans1 + ", " + str_ans2 + "�� �ط� ���´�.");
		}
		
		scanner.close();
	}
}
