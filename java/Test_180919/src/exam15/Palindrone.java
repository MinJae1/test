package exam15;

public class Palindrone {
	public static void main(String[] args) {

		int palind = 0;

		int big = 0;

		for (int i = 100; i < 1000; i++) {
			for (int k = 100; k < 1000; k++) {
				palind = i * k;
				if (isPalindrone(palind)) {
					if (palind > big) {
						big = palind;
					}
				}

			}
		}

		System.out.println(
				"Biggest Palindrone in treble figures double : " + big);
	}

	static boolean isPalindrone(int number) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

		String palind_str = "";
		String rev_palind_str = "";

		palind_str = Integer.toString(number);

		sb.append(palind_str);

		rev_palind_str = sb.reverse().toString();

		if (palind_str.equals(rev_palind_str)) {
			return true;

		}
		return false;

	}
}
