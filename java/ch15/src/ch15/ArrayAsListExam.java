package ch15;

import java.util.Arrays;

public class ArrayAsListExam {
	public static void main(String[] args) {
		java.util.List<String> list1 = Arrays.asList("name1", "name2", "name3");
		for (String string : list1) {
			System.out.println(string);
		}

		java.util.List<Integer> list2 = Arrays.asList(1, 2, 3);
		for (Integer integer : list2) {
			System.out.println(integer);
		}
	}
}
