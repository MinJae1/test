package ch04.sec1;

public class swichchar {
	public static void main(String[] args) {
		int capital = (int) (Math.random() + 0.5);
		int ab = (int) (Math.random() * 2);
		char grade = (char) ('A' + capital * 32 + ab);

		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("���ȸ��");
			break;

		case 'B':
		case 'b':
			System.out.println("�Ϲ�ȸ��");
			break;

		default:
			System.out.println("�մ�");
			break;
		}
	}
}
