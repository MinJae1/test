package codingstamp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//http://codingdojang.com/scode/418?answer_mode=hide
public class howIn {
	public static void main(String[] args) {
		String input_time;
		int[] input_time_array2;
		int cnt = 0;

		System.out.println("시간을 입력해 주세요 (00:00:00 형식)");
		Scanner scan = new Scanner(System.in);
		input_time = scan.nextLine();
		String[] input_time_array = input_time.split(":");

		input_time_array2 = new int[input_time_array.length];

		for (int i = 0; i < input_time_array2.length; i++) {
			input_time_array2[i] = Integer.parseInt(input_time_array[i]);
		}

		try {
			BufferedReader in = new BufferedReader(
					new FileReader("D:\\Work Space\\java\\codingstamp\\src\\codingstamp\\log.txt"));
			String s;

			while ((s = in.readLine()) != null) {
				String[] str_arr = s.split(" ");

				String new_str = null;
				new_str = String.join(":", str_arr);

				String[] time_arr = new_str.split(":");

				int[] time_arr2 = new int[time_arr.length];

				for (int i = 0; i < time_arr.length; i++) {
					time_arr2[i] = Integer.parseInt(time_arr[i]);
				}
				// 출근시간 time_arr2[0] : time_arr2[1] : time_arr2[2]
				// 퇴근시간 time_arr2[3] : time_arr2[4] : time_arr2[5]
				// 입력시간 input_time_array2[0] : input_time_array2[1] : input_time_array2[2]
				if (time_arr2[0] < input_time_array2[0] && input_time_array2[0] < time_arr2[3]) {
					cnt++;
				} else if (time_arr2[0] == input_time_array2[0] && input_time_array2[1] - time_arr2[1] > 0
						|| input_time_array2[0] == time_arr2[3] && time_arr2[4] - input_time_array2[1] > 0) {
					cnt++;
				} else if (time_arr2[0] == input_time_array2[0] && input_time_array2[1] == time_arr2[1]
						&& input_time_array2[2] - time_arr2[2] > 0
						|| input_time_array2[0] == time_arr2[3] && time_arr2[4] == input_time_array2[1]
								&& time_arr2[5] - input_time_array2[2] > 0) {
					cnt++;
				}
			}

			in.close();
		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}
		System.out.println(cnt);

		scan.close();
	}
}
