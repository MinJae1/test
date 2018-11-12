package ex04;

public class Util {
	public static <K, V> V getValue(Pair<K, V> p1, K Key) {
		boolean keyCom = p1.getKey().equals(Key);
		V val = null;
		if (keyCom) {
			val = p1.getValue();
		}
		return val;
	}

}
