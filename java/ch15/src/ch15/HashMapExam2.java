package ch15;

import java.util.HashMap;
import java.util.Map;

public class HashMapExam2 {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();

		map.put(new Student(1, "name"), 95);
		map.put(new Student(1, "name"), 95);

		System.out.println("Entry size : " + map.size());
	}
}
