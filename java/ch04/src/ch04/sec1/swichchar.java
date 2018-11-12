package ch04.sec1;

public class swichchar {
	public static void main(String[] args) {
		int capital = (int) (Math.random() + 0.5);
		int ab = (int) (Math.random() * 2);
		char grade = (char) ('A' + capital * 32 + ab);

		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("우수회원");
			break;

		case 'B':
		case 'b':
			System.out.println("일반회원");
			break;

		default:
			System.out.println("손님");
			break;
		}
	}
}
