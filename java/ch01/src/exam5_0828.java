import java.util.Scanner;

public class exam5_0828 {
	public static void main(String[] args) {
		String str;
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("암호화 할 문장을 입력해주세요.");
		str = scan.nextLine();
		System.out.println("암호화 숫자를 입력해 주세요.");
		num = scan.nextInt();

		String new_str;

		new_str = caesar(str, num);

		System.out.println(new_str);

		scan.close();

	}

	public static String caesar(String get_str, int n) {
		// TODO Auto-generated method stub
		String caesar_str = "";
		int new_code;
		int val = n % 26;
		int get_code;
		for (int i = 0; i < get_str.length(); i++) {
			get_code = get_str.charAt(i);
			new_code = get_code + val;

			if (get_code > 64 && get_code < 90) {
				if (new_code <= 64 || new_code >= 91) {
					new_code = 64 + (new_code - 91);
				}
			}
			if (get_code > 96 && get_code < 122) {
				if (new_code <= 96 || new_code >= 123) {
					new_code = 97 + (new_code - 122);
				}
			}
			caesar_str += (char) new_code;
		}

		return caesar_str;
	}

}
