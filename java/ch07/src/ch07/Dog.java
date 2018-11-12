package ch07;

public class Dog extends Animal {
	public Dog() {
		// TODO Auto-generated constructor stub
		this.kind = "Mammalia";
	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Bow Wow");
	}

}
