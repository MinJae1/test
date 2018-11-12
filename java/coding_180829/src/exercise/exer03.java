package exercise;

public class exer03 {
	public static void main(String[] args) {
		String palindrome1 = "";
		String palindrome2 = "";
		int mul;
		int max = 0, temp;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				mul = i * j;
				palindrome1 = mul + "";
				palindrome2 = new StringBuffer(palindrome1).reverse().toString();
				if (palindrome1.equals(palindrome2)) {
					temp = Integer.parseInt(palindrome1);
					if (temp > max) {
						max = temp;
					}
				}
			}
		}

		System.out.println("세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 " + max + "입니다.");
	}
}
