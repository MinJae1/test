package ch06;

public class ComputerExam {
	public static void main(String[] args) {
		Computer com = new Computer();

		int[] vals = { 1, 2, 3 };
		int result1 = com.sum1(vals);
		System.out.println("result : " + result1);

		int result2 = com.sum1(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("result : " + result2);

		int result3 = com.sum2(1, 2, 3);
		System.out.println("result : " + result3);

		int result4 = com.sum2(1, 2, 3, 4, 5);
		System.out.println("result : " + result4);
	}
}
