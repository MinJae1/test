package ch11;

import java.util.Scanner;

public class Palindrone {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);

		System.out.println("Palindrone check");
		System.out.print(">> ");
		String text = sc.nextLine();

		sb.append(text);

		String rev_txt = sb.reverse().toString();

		if (text.equals(rev_txt)) {
			System.out.println("Palindrone text");
		} else {
			System.out.println("Not Palindrone text");
		}
	}
}
