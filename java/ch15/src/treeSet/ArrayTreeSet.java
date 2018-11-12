package treeSet;

import java.util.TreeSet;

public class ArrayTreeSet {
	public static void main(String[] args) {

		String text = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";

		String[] split_text;
		int cnt_k = 0, cnt_l = 0, cnt_jy = 0;

		split_text = text.split(",");

		TreeSet<String> str_Arr = new TreeSet<String>();

		for (String name : split_text) {
			if (name.contains("김")) {
				cnt_k++;
			}
			if (name.contains("이")) {
				cnt_l++;
			}
			if (name.equals("이재영")) {
				cnt_jy++;
			}
			str_Arr.add(name);
		}

		System.out.print("김씨 : " + cnt_k + "명, 이씨 : " + cnt_l + "명 \n");
		System.out.print("이재영 - " + cnt_jy + "번 \n");
		System.out.print("중복제거 & 오름차순 : ");
		System.out.print(str_Arr + " ");

	}
}
