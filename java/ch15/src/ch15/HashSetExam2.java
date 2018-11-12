package ch15;

import java.util.HashSet;
import java.util.Set;

public class HashSetExam2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();

		set.add(new Member("name", 30));
		set.add(new Member("name", 30));

		System.out.println("size : " + set.size());
	}
}
