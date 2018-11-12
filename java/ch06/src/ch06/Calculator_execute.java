package ch06;

public class Calculator_execute {
	int plus(int x, int y) {
		return x + y;
	}

	double avg(int x, int y) {
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}

	void execute() {
		double result = avg(7, 10);
		print("실행결과 : " + result);
	}

	void print(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
}
