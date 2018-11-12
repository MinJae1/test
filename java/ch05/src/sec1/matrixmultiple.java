package sec1;

public class matrixmultiple {
	public static void main(String[] args) {
		int row = Integer.parseInt(args[0]);
		int col = Integer.parseInt(args[1]);

		int[][] a = new int[row][col];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 20 + 1);
			}
		}
		printmatrix(a);
		System.out.println("-----------------------------");

		int row2 = a.length;
		int col2 = a[0].length;
		int trans[][] = new int[col2][row2];

		for (int i = 0; i < trans.length; i++) {
			for (int j = 0; j < trans[i].length; j++) {
				trans[i][j] = a[j][i];
			}
		}

		printmatrix(trans);
		System.out.println("---------------------------");

		int[][] multimatrix = matrixMulti(a, trans);
		printmatrix(multimatrix);
	}

	private static int[][] matrixMulti(int[][] a, int[][] trans) {
		// TODO Auto-generated method stub
		int sum = 0;
		int[][] result = new int[a.length][trans[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				for (int k = 0; k < trans.length; k++) {
					result[i][j] += a[i][k] * trans[k][i];
				}
			}
		}
		return result;
	}

	private static void printmatrix(int[][] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(String.format("%4d", a[i][j]) + "  ");
			}
			System.out.println();
		}
	}

}
