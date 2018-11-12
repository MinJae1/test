package exercise;

public class exe7_1 {
	public static void main(String[] args) {
		int matlen = Integer.parseInt(args[0]);

		int max;
		int[] array = new int[matlen];
		max = array[0];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100 + 1);
			System.out.print(array[i] + " ");
		}
		System.out.println();

		int min = array[0];

		for (int j = 0; j < array.length; j++) {
			if (max < array[j]) {
				max = array[j];
			}
			if (min > array[j]) {
				min = array[j];
			}

		}

		System.out.println("max : " + max);
		System.out.println("min : " + min);
	}

}
