package sec1;

public class arrayvalue2 {
	public static void main(String[] args) {
		int[] score;
		score = new int[] { 83, 90, 87 };
		
		int sum1 = 0;
		for (int i = 0; i < score.length; i++) {
			sum1 += score[i];
		}
		System.out.println("รัวี : " + sum1);

		
		int sum2 = add(new int[] { 83, 90, 87 });
		System.out.println("รัวี : " + sum2);

	}

	public static int add(int[] score) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}

		return sum;
	}

}
