package ch15;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExam1 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<Integer, String>();
		scores.put(new Integer(87), "student1");
		scores.put(new Integer(98), "student2");
		scores.put(new Integer(75), "student3");
		scores.put(new Integer(95), "student4");
		scores.put(new Integer(80), "student5");

		Map.Entry<Integer, String> entry = null;

		entry = scores.firstEntry();
		System.out.println(
				"Lowest Score  : " + entry.getKey() + " - " + entry.getValue());

		entry = scores.lastEntry();
		System.out.println(
				"Highest Score : " + entry.getKey() + " - " + entry.getValue());
		System.out.println();

		entry = scores.lowerEntry(new Integer(95));
		System.out.println(
				"Score under 95 : " + entry.getKey() + " - " + entry.getValue());

		entry = scores.higherEntry(new Integer(95));
		System.out.println(
				"Score upper 95 : " + entry.getKey() + " - " + entry.getValue());
		System.out.println();

		entry = scores.floorEntry(new Integer(95));
		System.out.println("Score near 95(low)  : " + entry.getKey() + " - "
				+ entry.getValue());

		entry = scores.ceilingEntry(new Integer(85));
		System.out.println("Score near 85(high) : " + entry.getKey() + " - "
				+ entry.getValue());
		System.out.println();

		while (!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey() + " - " + entry.getValue()
					+ " (Number of Objects Remaining : " + scores.size() + ")");
		}

	}
}
