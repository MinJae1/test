package ch07;

public class PhoneExam {
	public static void main(String[] args) {
//		Phone phone = new Phone();

		SmartPhone smartP = new SmartPhone("owner Name");

		smartP.turnOn();
		smartP.internetSearch();
		smartP.turnOff();
	}
}
