package ch06;

public class CarExam_out {
	public static void main(String[] args) {
		Car_out carO = new Car_out();
		carO.keyOn();
		carO.run();
		int speed = carO.getSpeed();
		System.out.println("rate : " + speed + "km/h");
	}
}
