package ch06;

public class carExam {
	public static void main(String[] args) {
		Car myCar = new Car();

		System.out.println("회사 : " + myCar.company);
		System.out.println("모델 : " + myCar.model);
		System.out.println("색 : " + myCar.color);
		System.out.println("최고속도 : " + myCar.maxSpeed);
		System.out.println("속도 : " + myCar.speed);

		myCar.speed = 60;
		System.out.println("속도 재설정 : " + myCar.speed);
	}
}
