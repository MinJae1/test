package ch07;

public class InstanceOfExam {
	public static void method1(Parent P) {
		// TODO Auto-generated method stub
		if (P instanceof Child) {
			Child C = (Child) P;
			System.out.println("method1 - child conversion");
		} else {
			System.out.println("method1 - not conversion");
		}
	}

	public static void method2(Parent P) {
		// TODO Auto-generated method stub
		Child C = (Child) P;
		System.out.println("method1 - child conversion");

	}

	public static void main(String[] args) {
		Parent pA = new Child();
		method1(pA);
		method2(pA);

		Parent pB = new Parent();
		method1(pB);
		method2(pB);
	}
}
