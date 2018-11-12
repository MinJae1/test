package ch15;

import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExam3 {
	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("apple", new Integer(8));
		treeMap.put("coffee", new Integer(15));
		treeMap.put("tomorrow", new Integer(43));
		treeMap.put("sample", new Integer(39));
		treeMap.put("java", new Integer(25));
		treeMap.put("rabbit", new Integer(35));
		treeMap.put("name", new Integer(33));
		treeMap.put("zoo", new Integer(50));
		treeMap.put("eternity", new Integer(18));

		int cnt = 0;

		NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
		NavigableMap<String, Integer> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<String, Integer>> ascendingEntrySet = ascendingMap.entrySet();

		System.out.println("## word ##");
		for (Entry<String, Integer> entry : ascendingEntrySet) {
			String word = String.format("%-9s", entry.getKey());
			String page = String.format("%9s",
					"(page " + String.format("%2d", entry.getValue()) + ")");
			System.out.print(word + page + "\t");
			cnt++;
			if (cnt % 3 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n");

		NavigableMap<String, Integer> rangMap = treeMap.subMap("c", true, "o", true);

		System.out.println("*** Searching word between c and o ***");
		for (Entry<String, Integer> entry : rangMap.entrySet()) {
			String word = String.format("%-9s", entry.getKey());
			String page = String.format("%9s",
					"(page " + String.format("%2d", entry.getValue()) + ")");
			System.out.println(word + page);
		}

	}
}
