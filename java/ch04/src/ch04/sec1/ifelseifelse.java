package ch04.sec1;

public class ifelseifelse {
	public static void main(String[] args) {
		int score = 75;

		if (score >= 90) {
			System.out.println("90점 이상");
			System.out.println("A");

		} else if (score >= 80) {
			System.out.println("90점 미만");
			System.out.println("B");

		} else if (score >= 70) {
			System.out.println("80점 미만");
			System.out.println("C");

		} else {
			System.out.println("70점 미만");
			System.out.println("D");

		}

	}
}
