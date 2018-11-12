package ch11;

import java.util.Arrays;
import java.util.Random;

public class RandomExam {
	public static void main(String[] args) {
		int[] selectNum = new int[6];
		Random random = new Random(3);

		System.out.print("select number : ");
		for (int i = 0; i < 6; i++) {
			selectNum[i] = random.nextInt(45) + 1;
			System.out.print(selectNum[i] + " ");
		}
		System.out.println();

		int[] winNum = new int[6];
		random = new Random(5);

		System.out.print("winning number : ");
		for (int i = 0; i < 6; i++) {
			winNum[i] = random.nextInt(45) + 1;
			System.out.print(winNum[i] + " ");
		}
		System.out.println();

		Arrays.sort(selectNum);
		Arrays.sort(winNum);

		if (Arrays.equals(selectNum, winNum)) {
			System.out.println("You're Winning");
		} else {
			System.out.println("You're lose");
		}
	}
}
