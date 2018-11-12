package codingstamp;

import java.util.Scanner;

//http://codingdojang.com/scode/409?answer_mode=hide
public class pro_3n1 {
	public static void main(String[] args) {
		int cnt = 0;
		int max = 0;
		int n_new = 0;
		Scanner scan = new Scanner(System.in);

		System.out.println("측정 범위를 입력해 주세요");
		String str = scan.nextLine();
		String[] str_arr = str.split(" ");
		int[] int_array = { Integer.parseInt(str_arr[0]), Integer.parseInt(str_arr[1]) };

		for (int n = int_array[0]; n <= int_array[1]; n++) {
			int m = n;
			if (n == 1) {
				cnt = 1;
			} else {
				Inner: while (true) {
					if (m % 2 == 0) {
						m = m / 2;
						cnt++;
					} else {
						cnt++;
						if (m == 1) {
							break Inner;
						} else {
							m = 3 * m + 1;
						}
					}
				}
			}
			if (max < cnt) {
				max = cnt;
				n_new = n;
			}
			cnt = 0;
		}

		int k = n_new;
		int i = 0;

		System.out.println("최대 사이클 길이 > " + max);
		System.out.println("사이클 > ");
//		System.out.print(k + " ");
		Cycle: while (true) {
			System.out.print(String.format("%4d", k) + " ");
			if (k % 2 == 0) {
				k = k / 2;
				i++;
			} else {
				if (k == 1) {
					break Cycle;
				} else {
					k = 3 * k + 1;
					i++;
				}
			}
			if (i % 10 == 0) {
				System.out.println();
				
			}
		}

		scan.close();
	}
}
