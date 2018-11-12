
public class formintexam {
	public static void main(String[] args) {
		int num1 = 123456780;
		int num2 = 123456780;

		float num3 = num2;
		num2 = (int) num3;

		int result = num1 - num2;
		System.out.println(result);

		int num2_2 =123456780;
	
		double num4 = num2_2;
		num2_2 = (int) num4;

		int result2 = num1 - num2_2;
		System.out.println(result2);
	}
}
