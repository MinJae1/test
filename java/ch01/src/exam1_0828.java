
public class exam1_0828 {
	public static void main(String[] args) {
		int sum = 0;
		int multi = 1;

		for (int i = 10; i < 1001; i++) {
			String str_i = i + "";
			for (int j = 0; j < str_i.length(); j++) {
//				System.out.println("str_"+i+".charAt(" + j + ") >> " + str_i.charAt(j));
				multi *= Character.getNumericValue(str_i.charAt(j));
//				System.out.println("multi >> " + multi);
			}
			sum += multi;

			multi = 1;
		}

		System.out.println("sum >> " + sum);

	}
}
