package ch07;

public abstract class Animal {
	public String kind;

	public void breathe() {
		System.out.println("breathing");
	}

	public abstract void sound();

}
