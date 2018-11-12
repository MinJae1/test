package sc2.part1;

public class accuracy2 {
	public static void main(String[] args) {
		int apple = 1;

		int totalpiece = apple * 10;
		int number = 7;
		int temp = totalpiece - number;

		double result = temp / 10.0;

		System.out.println("사과 한개에서 0.7조각을 빼면 " + result + "조각이 남는다");
	}

}
