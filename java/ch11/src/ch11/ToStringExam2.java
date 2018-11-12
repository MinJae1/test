package ch11;

import java.util.Objects;

public class ToStringExam2 {
	public static void main(String[] args) {
		String str1 = "name";
		String str2 = null;

		System.out.println(Objects.toString(str1));
		System.out.println(str1.toString());
		System.out.println(Objects.toString(str2));
		System.out.println(Objects.toString(str2, "no name"));
	}
}
