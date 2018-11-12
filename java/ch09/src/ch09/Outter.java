package ch09;

public class Outter {
	public void method1(final int arg) {
		// TODO Auto-generated method stub
		final int localVariable = 1;

		class Inner {
			public void metho() {
				// TODO Auto-generated method stub
				int result = arg + localVariable;
			}
		}
	}

	public void method2(int arg) {
		// TODO Auto-generated method stub
		int localVariable = 1;
		class Inner {
			public void metho() {
				// TODO Auto-generated method stub
				int result = arg + localVariable;
			}
		}
	}
}
