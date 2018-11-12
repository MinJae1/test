package ch11;

public class StringIndexOfExam {
	public static void main(String[] args) {
		String subject = "Java Programing";

		int locate = subject.indexOf("Programing");
		System.out.println(locate);

		if (subject.indexOf("Programing") == -1) {
			System.out.println("Not a Java book");
		} else {
			System.out.println("a Java book");
		}
	}
}
