package ch13;

public class BoxingMethodeEx {
	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int val = box1.getT();

		Box<String> box2 = Util.boxing("name");
		String strV = box2.getT();
	}
}
