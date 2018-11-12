package ch11;

import java.util.HashMap;

public class KeyExam {
	public static void main(String[] args) {
		HashMap<Key, String> hashmap = new HashMap<Key, String>();
		hashmap.put(new Key(1), "name");

		String value = hashmap.get(new Key(1));
		System.out.println(value);
	}
}
