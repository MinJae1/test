package sec1;

public class arraycopyexam {
	public static void main(String[] args) {
		int[] oldarray = { 1, 2, 3 };
		int[] newArray = new int[5];

		for (int i = 0; i < oldarray.length; i++) {
			newArray[i] = oldarray[i];
		}
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
	}
}
