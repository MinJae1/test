package ch11;

import java.util.StringTokenizer;

public class Stringtoken {
	public static void main(String[] args) {
		String text = "name1/name2/name3";

		StringTokenizer st = new StringTokenizer(text, "/");
		int cnt = st.countTokens();
		for (int i = 0; i < cnt; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}

		System.out.println();

		st = new StringTokenizer(text, "/");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
