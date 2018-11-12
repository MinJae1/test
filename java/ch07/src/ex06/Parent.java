package ex06;

public class Parent {
	public String nation;

	public Parent() {
		// TODO Auto-generated constructor stub
		this("korea");
		System.out.println("Parent() cell");
	}

	public Parent(String nation) {
		// TODO Auto-generated constructor stub
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
