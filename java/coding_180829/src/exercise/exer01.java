package exercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class exer01 {
	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat(".##");

		Scanner scanner = new Scanner(System.in);
		System.out.println("이차 방정식 ax^2 + bx + c = 0 의 계수 a,b,c를 차례로 입력하시오");
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
			System.out.println("해가 존재하지 않습니다");
		} else if ((Math.pow(b, 2) - 4 * a * c) == 0) {
			System.out.println("방정식 (" + (int) a + ")x^2 + (" + (int) b + ")x + (" + (int) c + ") 은");
			System.out.println("중근 " + str_ans1 + "을 해로 갖는다.");
		} else {
			System.out.println("방정식 (" + (int) a + ")x^2 + (" + (int) b + ")x + (" + (int) c + ") 은");
			System.out.println(str_ans1 + ", " + str_ans2 + "을 해로 갖는다.");
		}
		
		scanner.close();
	}
}
