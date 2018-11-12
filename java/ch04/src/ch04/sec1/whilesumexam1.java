package ch04.sec1;

public class whilesumexam1 {
	public static void main(String[] args) {
		int sum = 0;

		int i = 1;
		while (i <= 100) {
			sum += i;
			i++;
		}
		System.out.println("1 ~ " + (i - 1) + "ÀÇ ÇÕ : " + sum);

	}
}
