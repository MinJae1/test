import java.util.Scanner;

public class exam2_0828 {
	public static void main(String[] args) {
		String equation;
		Scanner scan = new Scanner(System.in);
		equation = scan.nextLine();

		String new_equ;

		new_equ = DashInt(equation);

		System.out.println(new_equ);
		scan.close();

	}

	public static String DashInt(String str) {
		String new_str = "";
		int temp1, temp2;
//		System.out.println("str.length() >> " + str.length());
		for (int j = 0; j < str.length() - 1; j++) {
			for (int i = j + 1; i < str.length(); i++) {
				temp1 = Character.getNumericValue(str.charAt(j));
				temp2 = Character.getNumericValue(str.charAt(i));
				if (i - j == 1) {
					if (temp1 % 2 == 0 && temp2 % 2 == 0) {
//						System.out.println("str.charAt(" + j + ") + str.charAt(" + i + ") = ¦��+¦��");
						new_str += "*" + temp2;
					} else if (temp1 % 2 == 1 && temp2 % 2 == 1) {
//						System.out.println("str.charAt(" + j + ") + str.charAt(" + i + ") = Ȧ��+Ȧ��");
						if (j == 0) {
							new_str += temp1 + "-" + temp2;
						}
						else {
							new_str += "-" + temp2;
						}
					} else {
						if (j == 0) {
							new_str += temp1;
						} else {
							new_str += temp2;
						}
					}
				}

			}
		}

		return new_str;
	}
}
