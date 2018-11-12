package exercise;

public class exer05 {
	public static void main(String[] args) {
		System.out.println("방정식 4x + 5y = 60 의 해");
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (4 * i + 5 * j == 60) {
					System.out.println("(" + i + ", " + j + ")");
				}
			}
		}
	}
}
