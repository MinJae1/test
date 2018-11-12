package ch08;

public class DefaultExam {
	public static void main(String[] args) {
		ChildIF ci1 = new ChildIF() {

			@Override
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF-method1");
			}

			@Override
			public void method3() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF-method3");
			}
		};

		ci1.method1();
		ci1.method2();
		ci1.method3();

		// ====================================================

		ChildIF2 ci2 = new ChildIF2() {

			@Override
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF2-method1");
			}

			@Override
			public void method3() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF2-method3");
			}
		};

		ci2.method1();
		ci2.method2();
		ci2.method3();

		// ====================================================

		ChildIF3 ci3 = new ChildIF3() {

			@Override
			public void method1() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF3-method1");
			}

			@Override
			public void method3() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF3-method3");
			}

			@Override
			public void method2() {
				// TODO Auto-generated method stub
				System.out.println("ChildIF3-method2");
			}
		};

		ci3.method1();
		ci3.method2();
		ci3.method3();

	}
}
