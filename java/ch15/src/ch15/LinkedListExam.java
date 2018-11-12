package ch15;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListExam {
	public static void main(String[] args) {
		java.util.List<String> list1 = new ArrayList<String>();
		java.util.List<String> list2 = new LinkedList<String>();

		long startT;
		long endT;

		startT = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}

		endT = System.nanoTime();
		System.out.println("ArraList Time : " + (endT - startT) + "ns");

		startT = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}

		endT = System.nanoTime();
		System.out.println("LinkedList Time : " + (endT - startT) + "ns");

	}
}
