package sec1;

public class arrayreference {
	public static void main(String[] args) {
		String[] strarray = new String[3];
		strarray[0] = "JAVA";
		strarray[1] = "JAVA";
		strarray[2] = new String("JAVA");
		
		System.out.println(strarray[0] == strarray[1]);
		System.out.println(strarray[0] == strarray[2]);
		System.out.println(strarray[0].equals(strarray[1]));
	}
}
