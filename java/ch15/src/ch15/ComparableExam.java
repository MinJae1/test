package ch15;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExam {
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();

		treeSet.add(new Person("person1", 45));
		treeSet.add(new Person("person2", 25));
		treeSet.add(new Person("person3", 31));

		Iterator<Person> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Person person = (Person) iterator.next();
			System.out.println(person.name + " : " + person.age);
		}
	}
}
