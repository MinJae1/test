package ch04.sec1;

public class multiTable {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i++) {
			System.out.println("****" + i + "´Ü****");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " X " + j + " = " + String.format("%2d", (i*j)));
			}
			System.out.println();
		}
	}
}
