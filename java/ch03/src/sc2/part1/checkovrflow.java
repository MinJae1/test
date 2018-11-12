package sc2.part1;

public class checkovrflow {
	public static void main(String[] args) {
		try {
			int result = safeAdd(2000000000, 2000000000);
			System.out.println(result);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("overflow");
//			e.printStackTrace();
		}
	}

	public static int safeAdd(int left, int right) {
		// TODO Auto-generated method stub
		if (right > 0) {
			if (left > (Integer.MAX_VALUE - right)) {
				throw new ArithmeticException("오버플로우 발생");
			}
		} else {
			if (left < (Integer.MIN_VALUE - right)) {
				throw new ArithmeticException("오버플로우 발생");
			}

		}
		return left + right;
	}
}
