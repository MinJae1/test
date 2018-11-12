package ch13;

import java.util.Arrays;

public class WildCardExam {
	public static void registerC(Course<?> course) {
		// TODO Auto-generated method stub
		System.out.println(course.getName() + " Student : "
				+ Arrays.toString(course.getStudents()));
	}

	public static void registerCStudents(Course<? extends Student> course) {
		// TODO Auto-generated method stub
		System.out.println(course.getName() + " Student : "
				+ Arrays.toString(course.getStudents()));
	}

	public static void registerCWorker(Course<? super Worker> course) {
		// TODO Auto-generated method stub
		System.out.println(course.getName() + " Student : "
				+ Arrays.toString(course.getStudents()));
	}

	public static void main(String[] args) {
		Course<Person> personC = new Course<Person>("Ordinary person Course",
				5);
		personC.add(new Person("Ordinary person"));
		personC.add(new Worker("Worker"));
		personC.add(new Student("Student"));
		personC.add(new HighStudent("HighSchool Student"));

		Course<Worker> workerC = new Course<Worker>("Worker Course", 5);
		workerC.add(new Worker("Worker"));

		Course<Student> studentC = new Course<Student>("Student Course", 5);
		studentC.add(new Student("Student"));
		studentC.add(new HighStudent("HighSchool Student"));

		Course<HighStudent> highStudentC = new Course<HighStudent>(
				"Student Course", 5);
		highStudentC.add(new HighStudent("HighSchool Student"));

		registerC(personC);
		registerC(workerC);
		registerC(studentC);
		registerC(highStudentC);
		System.out.println();

//		registerCStudents(personC);
//		registerCStudents(workerC);
		registerCStudents(studentC);
		registerCStudents(highStudentC);
		System.out.println();

		registerCWorker(personC);
		registerCWorker(workerC);
//		registerCWorker(studentC);
//		registerCWorker(highStudentC);
	}
}
