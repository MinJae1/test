package coding_180913;

import java.util.ArrayList;
import java.util.TreeSet;

public class Stringsplit {
	public static void main(String[] args) {
		String text = "������,���翵,����ǥ,���翵,�ڹ�ȣ,������,���翵,������,�ֽ���,�̼���,�ڿ���,�ڹ�ȣ,������,����ȯ,���缺,������,������";
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
			if (string.contains("��")) {
				cnt_k++;
			}
			if (string.contains("��")) {
				cnt_l++;
			}
			if (string.equals("���翵")) {
				cnt_jy++;
			}
		}

		TreeSet<String> str_Arr = new TreeSet<String>(new_str);

		ArrayList<String> new_arr = new ArrayList<String>(str_Arr);

		System.out.print("�达 : " + cnt_k + "��, �̾� : " + cnt_l + "�� \n");
		System.out.print("���翵 - " + cnt_jy + "�� \n");
		System.out.print("(���� 3,4)�ߺ����� & �������� : ");
		System.out.print(new_arr + " ");
	}
}
