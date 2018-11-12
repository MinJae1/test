package ex12;

public class StringConvertExam {
	public static void main(String[] args) {
		// 문자열 200 정수 변환, 숫자 150 문자열 변환
		String str = "200";
		int str_int = Integer.valueOf(str);

		int i = 150;
		String int_str = String.valueOf(i);

//		System.out.println("int test -> " + (str_int + i));
//
//		System.out.println("String test -> " + (int_str + str));
	}
}
