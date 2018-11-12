package sec1;

public class matrixtrans {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		printmatrix(a);
		System.out.println("--------------------------------------");
		
		int row = a.length;
		int col = a[0].length;
		int trans[][] = new int [col][row];
		
		for (int i = 0; i < trans.length; i++) {
			for (int j = 0; j < trans[i].length; j++) {
				trans[i][j] = a[j][i];
			}
		}
		
		printmatrix(trans);
	}

	private static void printmatrix(int[][] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
