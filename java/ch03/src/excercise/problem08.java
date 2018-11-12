package excercise;

public class problem08 {
	public static void main(String[] args) {
		double x = 5.0;
		double y = 0.0;

		double z = x % y;

		if (Double.isNaN(z)) {
			System.out.println("0으로 나눌수없습니다.");
		} else {
			double result = z + 10;
			System.out.println("결과 : " + result);
		}
	}
}
