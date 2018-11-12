package excercise;

public class problem04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pencils = 534;
		int students = 30;

		// 인당 연필수
		int penperstudent = pencils / students;
		System.out.println(penperstudent);

		// 남은 연필
		int penleft = pencils - (penperstudent * students);
		System.out.println(penleft);

	}

}
