package sec1;

public class arraycreatebyvalue {
	public static void main(String[] args) {
		int[] score = { 83, 90, 87 };

		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i + "] : " + score[i]);
		}

		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		System.out.println("ÃÑÇÕ : " + sum);
		double avg = (double) sum / score.length;
		System.out.println("Æò±Õ : " + avg);
	}
}
