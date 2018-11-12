package sec1;

public class arrayint {
	public static void main(String[] args) {

		int[][] mathScore = new int[2][3];
		for (int i = 0; i < mathScore.length; i++) {
			for (int j = 0; j < mathScore[i].length; j++) {
				System.out.println("mathScore[" + i + "][" + j + "] = " + mathScore[i][j]);
			}
		}
		System.out.println();

		int[][] engScore = new int[2][];
		engScore[0] = new int[2];
		engScore[1] = new int[3];
		for (int i = 0; i < engScore.length; i++) {
			for (int j = 0; j < engScore[i].length; j++) {
				System.out.println("engScore[" + i + "][" + j + "] = " + engScore[i][j]);
			}
		}
		System.out.println();

		int[][] javaScore = { { 95, 80 }, { 92, 96, 80 } };
		for (int i = 0; i < javaScore.length; i++) {
			for (int j = 0; j < javaScore[i].length; j++) {
				System.out.println("javaScore[" + i + "][" + j + "] = " + javaScore[i][j]);
			}
		}
		System.out.println();

	}
}
