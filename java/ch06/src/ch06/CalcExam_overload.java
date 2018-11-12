package ch06;

public class CalcExam_overload {
	public static void main(String[] args) {
		Calculator_overload calOver = new Calculator_overload();

		double result1 = calOver.areaRect(10);
		double result2 = calOver.areaRect(10, 30);

		System.out.println("square : " + result1);
		System.out.println("rectangle : " + result2);
	}
}
