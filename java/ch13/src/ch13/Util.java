package ch13;

public class Util {
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
	}

	public static <K, V> boolean compare1(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCom = p1.getKey().equals(p2.getKey());
		boolean valCom = p1.getValue().equals(p2.getValue());
		return keyCom && valCom;
	}
	
	public static <T extends Number> int compare2(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
}
