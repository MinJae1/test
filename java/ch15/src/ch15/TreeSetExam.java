package ch15;

import java.util.TreeSet;

public class TreeSetExam {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));

		Integer score = null;

		score = scores.first();
		System.out.println("Lowest Score : " + score);

		score = scores.last();
		System.out.println("Highest Score : " + score);
		System.out.println();

		score = scores.lower(new Integer(95));
		System.out.println("Score under 95 : " + score);

		score = scores.higher(new Integer(95));
		System.out.println("Score upper 95 : " + score);
		System.out.println();

		score = scores.floor(new Integer(95));
		System.out.println("Score near 95(low) : " + score);

		score = scores.ceiling(new Integer(85));
		System.out.println("Score near 85(high) : " + score);
		System.out.println();

		while (!scores.isEmpty()) {
			score = scores.pollFirst();
			System.out.println(score + " (Number of Objects Remaining : "
					+ scores.size() + ")");
		}

	}
}
