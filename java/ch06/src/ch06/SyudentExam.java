package ch06;

public class SyudentExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		System.out.println("s1이 Student 참조");
		s1.name = "테스트1";
		System.out.println(s1.name);

		Student s2 = new Student();
		System.out.println("s2가 Student 참조");
		s2.name = "테스트2";
		System.out.println(s2.name);

	}

}
