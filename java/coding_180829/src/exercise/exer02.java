package exercise;

public class exer02 {
	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i <= 10000; i++) {
			String str_i = i + "";
			for (int j = 0; j < str_i.length(); j++) {
				if (str_i.charAt(j) == '8') {
					cnt++;
//					System.out.println(str_i.charAt(j));
				}
			}
		}
		System.out.println("1���� 10000���� 8�� ������ " + cnt + "�� �Դϴ�.");
	}
}
