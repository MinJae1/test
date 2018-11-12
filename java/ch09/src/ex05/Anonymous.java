package ex05;

public class Anonymous {
	Vehicle field = new Vehicle() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("bicycle");
		}
	};

	void method() {
		// TODO Auto-generated method stub
		Vehicle localVar = new Vehicle() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("car");
			}
		};

		localVar.run();
	}

	void method2(Vehicle v) {
		// TODO Auto-generated method stub
		v.run();
	}
}
