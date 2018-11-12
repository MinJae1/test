package exam11;

public class Summation {
	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 7 == 0) {
				cnt += i;
			}
		}
		System.out.println("Between 1 ~ 1000, 7's multiple : " + cnt);
	}
}
