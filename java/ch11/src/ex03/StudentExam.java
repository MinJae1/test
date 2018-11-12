package ex03;

import java.util.HashMap;

public class StudentExam {
	public static void main(String[] args) {
		HashMap<Student, String> hashmap = new HashMap<Student, String>();
		hashmap.put(new Student("1"), "95");

		String score = hashmap.get(new Student("1"));
		System.out.println("score : " + score);

	}
}
