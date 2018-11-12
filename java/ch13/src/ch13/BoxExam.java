package ch13;

public class BoxExam {
	public static void main(String[] args) {
//		Box box = new Box();
//		box.setObj("name");
//		String name = (String) box.getObj();
//
//		box.setObj(new Apple());
//		Apple apple = (Apple) box.getObj();
		
		Box<String> box1 = new Box<String>();
		box1.setT("hello");
		String str = box1.getT();

		Box<Integer> box2 = new Box<Integer>();
		box2.setT(6);
		int value = box2.getT();
	}
}
