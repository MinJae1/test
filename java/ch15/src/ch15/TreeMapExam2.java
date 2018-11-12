package ch15;

import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExam2 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<Integer, String>();
		scores.put(new Integer(87), "student1");
		scores.put(new Integer(98), "student2");
		scores.put(new Integer(75), "student3");
		scores.put(new Integer(95), "student4");
		scores.put(new Integer(80), "student5");

		NavigableMap<Integer, String> descendingMap = scores.descendingMap();
		Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap
				.entrySet();
		for (Entry<Integer, String> entry : descendingEntrySet) {
			System.out.print(entry.getKey() + " - " + entry.getValue() + " ");
		}
		System.out.println();

		NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
		for (Entry<Integer, String> entry : ascendingEntrySet) {
			System.out.print(entry.getKey() + " - " + entry.getValue() + " ");
		}

	}

}
