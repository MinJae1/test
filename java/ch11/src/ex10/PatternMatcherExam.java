package ex10;

import java.util.regex.Pattern;

public class PatternMatcherExam {
	public static void main(String[] args) {
//		Scanner sc =  new Scanner(System.in);
		String id = "5Angel1004";
//		System.out.print("ID >> ");
//		String id = sc.nextLine();
		String regExp = "^[a-zA-Z]+[a-zA-Z0-9]*$";
		boolean isMatch = Pattern.matches(regExp, id);

		if (isMatch) {
			System.out.println("Can be used with ID");
		} else {
			System.out.println("Can't be used with ID");
		}
//		sc.close();
	}
}
