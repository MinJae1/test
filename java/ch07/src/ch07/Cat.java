package ch07;

public class Cat extends Animal {
	public Cat() {
		// TODO Auto-generated constructor stub
		this.kind = "Mammalia";
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Miaow");
	}
}
