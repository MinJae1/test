package codingstamp;

// http://codingdojang.com/scode/365?answer_mode=hide
public class selfnumber {
	public static void main(String[] args) {
		int max = 5000;
		int sum = 0;
		int[] arr = new int[max];

		for (int i = 0; i < max; i++) {
			arr[i] = i + 1;
		}

		for (int i = 1; i <= max; i++) {
			String str_i = i + "";
			sum += i;
			for (int j = 0; j < str_i.length(); j++) {
				sum += Character.getNumericValue(str_i.charAt(j));
			}
			if (sum <= max) {
				arr[sum - 1] = 0;
			}

			sum = 0;
		}

		int cnt = 0;
		int self_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			self_sum += arr[i];
			if (arr[i] == 0) {
				System.out.print("");
			} else {
				System.out.print(String.format("%4d", arr[i]) + "  ");
				cnt++;
				if (cnt % 13 == 0) {
					System.out.println();
				}
			}
		}
		
		System.out.println();
		System.out.println("0-5000 까지의 self number의 총합 : "+ self_sum);
	}
}
