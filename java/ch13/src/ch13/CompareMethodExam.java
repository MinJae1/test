package ch13;

public class CompareMethodExam {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "apple");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "apple");
		boolean result1 = Util.<Integer, String>compare1(p1, p2);

		if (result1) {
			System.out.println("Logically equivalent objects.");
		} else {
			System.out.println("Logically unequal object.");
		}

		Pair<String, String> p3 = new Pair<String, String>("user1", "name");
		Pair<String, String> p4 = new Pair<String, String>("user2", "name");
		boolean result2 = Util.compare1(p3, p4);

		if (result2) {
			System.out.println("Logically equivalent objects.");
		} else {
			System.out.println("Logically unequal object.");
		}

	}
}
