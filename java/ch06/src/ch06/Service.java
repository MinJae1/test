package ch06;

public class Service {
	@PrintAnnotation
	public void methode1() {
		System.out.println("���೻��1");
	}

	@PrintAnnotation("*")
	public void methode2() {
		System.out.println("���೻��2");
	}

	@PrintAnnotation(value = "#", number = 20)
	public void methode3() {
		System.out.println("���೻��3");
	}
}
