package exercise;

public class exe07 {
	public static void main(String[] args) {
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };
		max = array[0];

		for (int j = 0; j < array.length; j++) {
			if (max < array[j]) {
				max = array[j];
			}
		}

		System.out.println("max : " + max);
	}
}
