package ex07;

public class FindAndReplaceExam {
	public static void main(String[] args) {
		String str = "All program is development by JAVA";

		int index = str.indexOf("JAVA");
		if (index == -1) {
			System.out.println("\"JAVA\" don't come under String");
		} else {
			System.out.println("\"JAVA\" come under String");
			str = str.replace("JAVA", "ÀÚ¹Ù");
			System.out.println("->" + str);
		}
	}
}
