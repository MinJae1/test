package ch06;

public class CalcExam_static {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator_static.pi;
		int result2 = Calculator_static.plus(10, 5);
		int result3 = Calculator_static.subtract(10, 5);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
}
