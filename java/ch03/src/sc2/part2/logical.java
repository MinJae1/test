package sc2.part2;

public class logical {
	public static void main(String[] args) {
		int charCode = 'A';

		if ((charCode >= 65) & (charCode <= 90)) {
			System.out.println("대문자");
		}
		if ((charCode >= 97) && (charCode <= 122)) {
			System.out.println("소문자");
		}
		if ((charCode < 48) && (charCode > 57)) {
			System.out.println("0~9까지의 숫자");
		}

		int value = 6;

		if ((value % 2 == 0) | (value % 2 == 0)) {
			System.out.println("2또는 3의 배수");
		}
		if ((value % 2 == 0) || (value % 2 == 0)) {
			System.out.println("2또는 3의 배수");
		}
	}
}
