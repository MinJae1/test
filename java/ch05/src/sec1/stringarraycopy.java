package sec1;

public class stringarraycopy {
	public static void main(String[] args) {
		String[] oldarray = {"java","array","copy"};
		String[] newArray = new String[5];
		
		for (int i = 0; i < oldarray.length; i++) {
			newArray[i] = oldarray[i];
		}
		for (int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i]+" ");
		}
	}

}
