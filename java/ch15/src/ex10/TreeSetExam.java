package ex10;

import java.util.TreeSet;

public class TreeSetExam {
	public static void main(String[] args) {
		TreeSet<Student> treeSet = new TreeSet<Student>();
		treeSet.add(new Student("blue", 96));
		treeSet.add(new Student("hong", 86));
		treeSet.add(new Student("white", 92));

		Student student = treeSet.last();
		System.out.println("Max Score : " + student.score);
		System.out.println("Max Score Id : " + student.id);
	}
}
