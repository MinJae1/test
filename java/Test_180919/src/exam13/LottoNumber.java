package exam13;

import java.util.Arrays;
import java.util.Random;

public class LottoNumber {
	public static void main(String[] args) {
		int[] lottoArray = gerLottoNumber();
		System.out.println(Arrays.toString(lottoArray));
	}

	static int[] gerLottoNumber() {
		// TODO Auto-generated method stub
		int[] lottoNumber = new int[6];
		Random random = new Random(3);

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < lottoNumber.length; k++) {
				lottoNumber[i] = random.nextInt(45) + 1;
				if (lottoNumber[i] == lottoNumber[k]) {
					lottoNumber[i] = random.nextInt(45) + 1;
				}
			}
		}

		return lottoNumber;
	}
}
