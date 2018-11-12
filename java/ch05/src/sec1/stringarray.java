package sec1;

public class stringarray {
	public static void main(String[] args) {
//		args = new String[] { "225", "442" };
		if (args.length != 2) {
			System.out.println("프로그램 사용법");
			System.out.println();
			System.exit(0);
		}

		String strNum1 = args[0];
		String strNum2 = args[1];

		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);

		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
}
