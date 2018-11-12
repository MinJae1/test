package ch04.sec1;

public class if_construc {
	public static void main(String[] args) {
		int score = 93;

		if (score >= 90) {
			System.out.println("90점 이상");
			System.out.println("A");
		}
		if (score < 90) {
			System.out.println("90점 미만");
			System.out.println("B");
		}
	}
}
