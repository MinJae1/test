package ch15;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparetorExam {
	public static void main(String[] args) {
/*
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>();

		treeSet.add(new Fruit("grape", 3000));
		treeSet.add(new Fruit("strawberry", 6000));
		treeSet.add(new Fruit("watermelon", 10000));
*/
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator());

		treeSet.add(new Fruit("grape", 3000));
		treeSet.add(new Fruit("strawberry", 6000));
		treeSet.add(new Fruit("watermelon", 10000));

		Iterator<Fruit> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Fruit fruit = (Fruit) iterator.next();
			System.out.println(fruit.name + " : " + fruit.price);
		}
	}
}
