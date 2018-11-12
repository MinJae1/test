package ch06;

public class CarExam_return {
	public static void main(String[] args) {
		Car_return carR = new Car_return();

		carR.setGas(5);

		boolean gasState = carR.isLeft();
		if (gasState) {
			System.out.println("start");
			carR.run();
		}

		if (carR.isLeft()) {
			System.out.println("gas left");
		} else {
			System.out.println("no gas");
		}
	}
}
