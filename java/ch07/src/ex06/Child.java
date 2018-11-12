package ex06;

public class Child {
	private String name;

	public Child() {
		// TODO Auto-generated constructor stub
		this("Child Name");
		System.out.println("Child() cell");
	}

	public Child(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		System.out.println("Child(String name) call");
	}

}
