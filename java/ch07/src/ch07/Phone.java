package ch07;

public abstract class Phone {
	public String owner;

	public Phone(String owner) {
		// TODO Auto-generated constructor stub
		this.owner = owner;
	}

	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Turn On");
	}

	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Turn Off");
	}
}
