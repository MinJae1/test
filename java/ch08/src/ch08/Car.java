package ch08;

public class Car {
	Tire fLT = new HanKookTire();
	Tire fRT = new HanKookTire();
	Tire bLT = new HanKookTire();
	Tire bRT = new HanKookTire();

	void run() {
		// TODO Auto-generated method stub
		fLT.roll();
		fRT.roll();
		bLT.roll();
		bRT.roll();
	}
}
