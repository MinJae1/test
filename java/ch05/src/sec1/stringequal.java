package sec1;

public class stringequal {
	public static void main(String[] args) {
		String strVar1 = "신민철";
		String strVar2 = "신민철";

		if (strVar1 == strVar2) {
			System.out.println("같은참조");
		} else {
			System.out.println("다른참조");
		}
		
		if (strVar1.equals(strVar2)) {
			System.out.println("같은 문자열");
		}


		String strVar3 = new String("신민철");
		String strVar4 = new String("신민철");

		if (strVar3 == strVar4) {
			System.out.println("같은참조");
		} else {
			System.out.println("다른참조");
		}

		if (strVar3.equals(strVar4)) {
			System.out.println("같은 문자열");
		}

	}
}
