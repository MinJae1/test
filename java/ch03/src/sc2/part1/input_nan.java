package sc2.part1;

public class input_nan {
	public static void main(String[] args) {
		String userinput = "NaN";
		double val = Double.valueOf(userinput);

		double currentbalance = 10000.0;

		currentbalance += val;
		System.out.println(currentbalance);
	}
}
