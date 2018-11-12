package ch07;

public class computerExam {
	public static void main(String[] args) {
		int r = 10;

		Calculator cal = new Calculator();
		System.out.println("circle area : " + cal.areaCircle(r));
		System.out.println();

		Computer comp = new Computer();
		System.out.println("circle area : " + comp.areaCircle(r));
	}
}
