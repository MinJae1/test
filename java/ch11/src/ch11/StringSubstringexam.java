package ch11;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringSubstringexam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print(">> ");
		String ssn = sc.nextLine();
		String comp = "^\\d{6}-[1-4]+\\d{5}";

		String first = ssn.substring(0, 6);
		String second = ssn.substring(7);
		if (ssn.length() != 13) {
			System.out.println("Not Ssn");
		} else {
			if (Pattern.matches(comp, ssn)) {
				System.out.println(
						first.substring(0, 2) + "³â " + first.substring(2, 4) + "¿ù " + first.substring(4, 6) + "ÀÏ");
				if (second.substring(0, 1).equals("1") || second.substring(0, 1).equals("3")) {
					System.out.println("sex : M");
				} else {
					System.out.println("sex : W");
				}
			} else {
				System.out.println("Not Ssn formate");
			}
		}

	}
}
