package ch07;

public class studentExam {
	public static void main(String[] args) {
		Student student = new Student("ÀÌ¸§", "1234-1234", 1);

		System.out.println("name : " + student.name);
		System.out.println("ssn : " + student.ssn);
		System.out.println("studentNo : " + student.stNo);
	}
}
