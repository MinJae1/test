package ch09;

public class Anonymous {
	Remote field = new Remote() {

		@Override
		public void turnOn() {
			// TODO Auto-generated method stub

		}

		@Override
		public void turnOff() {
			// TODO Auto-generated method stub

		}
	};

	private void method1() {
		// TODO Auto-generated method stub
		Remote localVar = new Remote() {

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub

			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub

			}
		};

		localVar.turnOn();
	}

}
