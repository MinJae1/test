package coding_180913;

import java.util.ArrayList;
import java.util.TreeSet;

public class Stringsplit {
	public static void main(String[] args) {
		String text = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
//		ArrayList<String> split_text = new ArrayList<String>();
		String[] split_text;
		int cnt_k = 0, cnt_l = 0;
		int cnt_jy = 0;

		System.out.println(text);

		split_text = text.split(",");
//		StringTokenizer st = new StringTokenizer(text, ",");

		ArrayList<String> new_str = new ArrayList<String>();

		for (String string : split_text) {
			new_str.add(string);
			if (string.contains("김")) {
				cnt_k++;
			}
			if (string.contains("이")) {
				cnt_l++;
			}
			if (string.equals("이재영")) {
				cnt_jy++;
			}
		}

		TreeSet<String> str_Arr = new TreeSet<String>(new_str);

		ArrayList<String> new_arr = new ArrayList<String>(str_Arr);

		System.out.print("김씨 : " + cnt_k + "명, 이씨 : " + cnt_l + "명 \n");
		System.out.print("이재영 - " + cnt_jy + "번 \n");
		System.out.print("(문제 3,4)중복제거 & 오름차순 : ");
		System.out.print(new_arr + " ");
	}
}
