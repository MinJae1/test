package ex09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);

		String name = null;
		int maxScore = 0;
		int totalScore = 0;

		Set<String> keySet = map.keySet();
		Iterator<String> kIterator = keySet.iterator();
		while (kIterator.hasNext()) {
			String key = (String) kIterator.next();
			Integer score = map.get(key);
			totalScore += score;
			if (score > maxScore) {
				maxScore = score;
				name = key;
			}

		}

		System.out.println("<KeySet>");
		System.out.println("Average : " + totalScore / map.size());
		System.out.println("Total Score : " + maxScore);
		System.out.println("Max Score Id : " + name);

		System.out.println();

		totalScore = 0;

		Set<Map.Entry<String, Integer>> entryset = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entryset.iterator();

		while (entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) entryIterator
					.next();
			String key = entry.getKey();
			Integer score = entry.getValue();
			totalScore += score;
			if (score > maxScore) {
				maxScore = score;
				name = key;
			}
		}

		System.out.println("<Map Entry>");
		System.out.println("Average : " + (totalScore / map.size()));
		System.out.println("Total Score : " + maxScore);
		System.out.println("Max Score Id : " + name);

	}
}
