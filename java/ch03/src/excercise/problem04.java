package excercise;

public class problem04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pencils = 534;
		int students = 30;

		// �δ� ���ʼ�
		int penperstudent = pencils / students;
		System.out.println(penperstudent);

		// ���� ����
		int penleft = pencils - (penperstudent * students);
		System.out.println(penleft);

	}

}
