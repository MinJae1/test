package ch06;

public class personExam {
	public static void main(String[] args) {
		person p1 = new person("123456-1234567", "���");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		p1.name = "��������";
	}
}
