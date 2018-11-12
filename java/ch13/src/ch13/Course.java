package ch13;

public class Course<T> {
	private String name;
	private T[] students;

	public Course(String name, int capacity) {
		// TODO Auto-generated constructor stub
		this.name = name;
		students = (T[]) (new Object[capacity]);
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}

	public void add(T t) {
		// TODO Auto-generated method stub
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}

}
