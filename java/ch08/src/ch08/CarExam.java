package ch08;

public class CarExam {
	public static void main(String[] args) {
		Car myC = new Car();

		myC.run();

		myC.fLT = new KumhoTire();
		myC.fRT = new KumhoTire();

		myC.run();
	}
}
