package ex08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashExam {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();

		set.add(new Student(1, "name1"));
		set.add(new Student(2, "name2"));
		set.add(new Student(1, "name3"));

		Iterator<Student> iterator = set.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.Stno + ". " + student.name);
		}

	}
}
