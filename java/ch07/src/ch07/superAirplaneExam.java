package ch07;

public class superAirplaneExam {
	public static void main(String[] args) {
		SuperAirplane superAir = new SuperAirplane();

		superAir.takeOff();
		superAir.fly();
		superAir.flyMode = SuperAirplane.SUPERSONIC;
		superAir.fly();
		superAir.flyMode = SuperAirplane.NORMAL;
		superAir.fly();
		superAir.land();
	}
}
