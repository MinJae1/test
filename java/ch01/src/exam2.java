import java.util.Arrays;

public class exam2 {
	public static void main(String[] args) {
		int intarray[] = { -1, 3, 5, -6, 4 };
		int temp;

		
		for (int i = 0; i < intarray.length-1; i++) {
			for (int j = i+1; j < intarray.length; j++) {
				if (intarray[j]<0 && intarray[i]>0) {
					temp = intarray[i];
					intarray[i] = intarray[j];
					intarray[j] = temp;
				} 
			}
//			System.out.println(intarray[i]);
		}
		
//		for (int i = 0; i < intarray.length; i++) {
			System.out.println(Arrays.toString(intarray));
//		}
	}
}
