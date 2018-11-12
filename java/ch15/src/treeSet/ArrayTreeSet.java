package treeSet;

import java.util.TreeSet;

public class ArrayTreeSet {
	public static void main(String[] args) {

		String text = "������,���翵,����ǥ,���翵,�ڹ�ȣ,������,���翵,������,�ֽ���,�̼���,�ڿ���,�ڹ�ȣ,������,����ȯ,���缺,������,������";

		String[] split_text;
		int cnt_k = 0, cnt_l = 0, cnt_jy = 0;

		split_text = text.split(",");

		TreeSet<String> str_Arr = new TreeSet<String>();

		for (String name : split_text) {
			if (name.contains("��")) {
				cnt_k++;
			}
			if (name.contains("��")) {
				cnt_l++;
			}
			if (name.equals("���翵")) {
				cnt_jy++;
			}
			str_Arr.add(name);
		}

		System.out.print("�达 : " + cnt_k + "��, �̾� : " + cnt_l + "�� \n");
		System.out.print("���翵 - " + cnt_jy + "�� \n");
		System.out.print("�ߺ����� & �������� : ");
		System.out.print(str_Arr + " ");

	}
}
