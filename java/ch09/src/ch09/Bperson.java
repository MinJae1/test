package ch09;

public class Bperson extends Person{
	void walk() {
		// TODO Auto-generated method stub
		System.out.println("walk");
	}

	void wake() {
		// TODO Auto-generated method stub
		System.out.println("wake up in 7");
		walk();
	}
}
