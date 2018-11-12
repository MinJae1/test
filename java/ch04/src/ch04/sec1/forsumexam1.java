package ch04.sec1;

public class forsumexam1 {
	public static void main(String[] args) {
		int sum = 0;

		int num = (int) (Math.random() * 100) + 100;

		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("1 ~ " + num + "±îÁö ÇÕ :" + sum);
	}
}
