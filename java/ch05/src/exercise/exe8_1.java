package exercise;

public class exe8_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		int sum = 0;
		double avg = 0.0;
		int cnt = 0;
		double var = 0.0;
		double sdev = 0.0;
		System.out.print("array : ");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
				cnt++;
				sum += array[i][j];
			}
		}
		System.out.println();

		avg = (double) sum / cnt;

		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

		double temp;
		double var_sum = 0.0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				temp = array[i][j] - avg;
				var_sum += Math.pow(temp, 2);
			}
		}

		var = var_sum / cnt;
		sdev = Math.sqrt(var);

		System.out.println("variance : " + String.format("%.2f", var));
		System.out.println("standard deviation : " + String.format("%.2f", sdev));
	}

}
