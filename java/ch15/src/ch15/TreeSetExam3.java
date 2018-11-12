package ch15;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExam3 {
	public static void main(String[] args) {
		TreeSet<String> treeset = new TreeSet<String>();
		treeset.add("apple");
		treeset.add("coffee");
		treeset.add("tomorrow");
		treeset.add("sample");
		treeset.add("java");
		treeset.add("rabbit");
		treeset.add("name");
		treeset.add("zoo");
		treeset.add("eternity");

		NavigableSet<String> descendingSet = treeset.descendingSet();
		NavigableSet<String> ascendingSet = descendingSet.descendingSet();

		System.out.print("word : ");
		for (String word : ascendingSet) {
			System.out.print(word + " ");
		}
		System.out.println("\n");

		System.out.println("*** Searching word between c and o ***");

		NavigableSet<String> rangSet = treeset.subSet("c", true, "o", true);
		for (String word : rangSet) {
			System.out.println(word);
		}

	}
}
