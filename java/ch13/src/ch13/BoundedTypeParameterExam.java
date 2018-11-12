package ch13;

public class BoundedTypeParameterExam {
	public static void main(String[] args) {
//	String result1 = Util.compare2("", "");

		int result2 = Util.compare2(10, 20);
		System.out.println(result2);

		int result3 = Util.compare2(4.5, 3);
		System.out.println(result3);
	}
}
