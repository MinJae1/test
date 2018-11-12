package ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExam1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("name1", 85);
		map.put("name2", 90);
		map.put("name3", 80);
		map.put("name2", 95);

		System.out.println("Entry size : " + map.size());

		System.out.println("\tname2 : " + map.get("name2"));
		System.out.println();

		Set<String> keySet = map.keySet();
		Iterator<String> kIterator = keySet.iterator();
		while (kIterator.hasNext()) {
			String key = (String) kIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();

		map.remove("name2");
		System.out.println("Entry size : " + map.size());

		map.put("name4", 75);
		System.out.println("Entry size : " + map.size());

		Set<Map.Entry<String, Integer>> entryset = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entryset
				.iterator();

		while (entryIterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.Integer> entry = (Map.Entry<java.lang.String, java.lang.Integer>) entryIterator
					.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();

		map.clear();
		System.out.println("Entry size : " + map.size());
	}
}
