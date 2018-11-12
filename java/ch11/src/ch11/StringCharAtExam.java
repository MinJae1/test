package ch11;

public class StringCharAtExam {
	public static void main(String[] args) {
		String ssn = "010624-134562";
		char sex = ssn.charAt(7);
		switch (sex) {
		case '1':
		case '3':
			System.out.println("M");
			break;

		case '2':
		case '4':
			System.out.println("W");
			break;
		}
	}
}
