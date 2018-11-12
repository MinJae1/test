package sc2.part1;

public class input_nan2 {
	public static void main(String[] args) {
		String userinput = "NaN";
		double val = Double.valueOf(userinput);

		double currentbalance = 10000.0;

		if (Double.isNaN(val)) {
			System.out.println("nan ют╥б");
			val = 0.0;
		}

		currentbalance += val;
		System.out.println(currentbalance);
	}

}
