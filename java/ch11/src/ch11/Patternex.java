package ch11;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Patternex {
	public static void main(String[] args) {
		String tel_form = "(02|010)-\\d{3,4}-\\d{4}";
		String mail_form = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

		Scanner sc = new Scanner(System.in);

		System.out.print("Tel > ");
		String Tel = sc.nextLine();

		System.out.print("mail > ");
		String mail = sc.nextLine();

		if (!Pattern.matches(tel_form, Tel)) {
			System.out.println("tel is not correct");
		}
		if (!Pattern.matches(mail_form, mail)) {
			System.out.println("mail is not correct");
		}
		if (Pattern.matches(tel_form, Tel) && Pattern.matches(mail_form, mail)) {
			System.out.println("Tel : " + Tel + "\nMail : " + mail);
		}

	}
}
