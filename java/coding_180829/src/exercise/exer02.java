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
		System.out.println("1부터 10000까지 8의 갯수는 " + cnt + "개 입니다.");
	}
}
