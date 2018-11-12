package ch06;

public class Car_out {
	int speed;

	int getSpeed() {
		return speed;
	}

	void keyOn() {
		// TODO Auto-generated method stub
		System.out.println("Key On");
	}

	void run() {
		// TODO Auto-generated method stub
		for (int i = 10; i <= 50; i += 10) {
			speed = i;
			System.out.println("run (" + speed + "km/h)");
		}
	}
}
