package ch06;

public class Service {
	@PrintAnnotation
	public void methode1() {
		System.out.println("실행내용1");
	}

	@PrintAnnotation("*")
	public void methode2() {
		System.out.println("실행내용2");
	}

	@PrintAnnotation(value = "#", number = 20)
	public void methode3() {
		System.out.println("실행내용3");
	}
}
