package ex09;

public class StringBuilderExam {
	public static void main(String[] args) {
		String str = "";
		for (int i = 1; i <= 100; i++) {
			str += i;
//			str += String.format("%3d", i);
//			if (i % 10 == 0) {
//				str += "\n";
//			}
		}
		System.out.println(str);

		System.out.println();

		StringBuilder sb = new StringBuilder();

		System.out.println("(StringBuilder)");

		for (int i = 1; i <= 100; i++) {
			sb.append(i);
//			sb.append(String.format("%3d", i));
//			if (i % 10 == 0) {
//				sb.append("\n");
//			}
		}

		System.out.println(sb.toString());
	}
}
