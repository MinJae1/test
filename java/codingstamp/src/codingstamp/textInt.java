package codingstamp;

import java.util.Scanner;
//http://codingdojang.com/scode/598?answer_mode=hide
public class textInt {
	public static void main(String[] args) {
		String str;
		Scanner scan = new Scanner(System.in);

		str = scan.nextLine();
		System.out.println("�Է¹��� > " + str);

		System.out.print("���ڸ� > ");
		for (int j = 0; j < str.length(); j++) {
			if (48 <= str.charAt(j) && str.charAt(j) <= 57) {
				System.out.print(str.charAt(j));
			}
		}

		scan.close();
	}
}
