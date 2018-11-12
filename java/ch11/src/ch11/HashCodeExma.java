package ch11;

import java.util.Objects;

public class HashCodeExma {
	public static void main(String[] args) {
		Student s1 = new Student(1, "name1");
		Student s2 = new Student(1, "name2");

		System.out.println(s1.hashCode());
		System.out.println(Objects.hashCode(s2));
	}

	static class Student {
		int sno;
		String name;

		Student(int sno, String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.sno = sno;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(sno, name);
		}
	}

}
