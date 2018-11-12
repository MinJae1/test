package ch06;

public class Car_instance {
	String model;
	int speed;

	Car_instance(String model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 10; i <= 50; i += 10) {
			this.setSpeed(i);
			System.out.println(this.model + " run (SpH : " + this.speed + "km/h)");
		}
	}
}
