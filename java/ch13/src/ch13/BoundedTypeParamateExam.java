package ch13;

public class BoundedTypeParamateExam {
	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intVals = box1.getT();
		System.out.println("intVals : " + intVals);

		Box<String> box2 = Util.boxing("name");
		String strVal = box2.getT();
		System.out.println("strVal : " + strVal);
	}
}
