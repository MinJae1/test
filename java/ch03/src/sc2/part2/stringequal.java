package sc2.part2;

public class stringequal {
	public static void main(String[] args) {
		String strVar1 = "같음";
		String strVar2 = "같음";
		String strVar3 = new String("같음");

		System.out.println(strVar1 == strVar2);
		System.out.println(strVar1 == strVar3);
		System.out.println();
		System.out.println(strVar1.equals(strVar2));
		System.out.println(strVar1.equals(strVar3));

	}
}
