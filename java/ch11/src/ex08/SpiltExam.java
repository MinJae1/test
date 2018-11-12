package ex08;

import java.util.StringTokenizer;

public class SpiltExam {
	public static void main(String[] args) {
		String str = "Id,Name,Password";

		String[] strArr = str.split(",");

		System.out.println("(split)");
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}

		System.out.println();

		StringTokenizer st = new StringTokenizer(str, ",");

		System.out.println("(StringTokenizer)");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
