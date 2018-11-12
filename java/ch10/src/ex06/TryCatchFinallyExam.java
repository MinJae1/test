package ex06;

public class TryCatchFinallyExam {
	public static void main(String[] args) {
		String[] strArr = { "10", "2a" };
		int value = 0;

		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArr[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("Out of Index");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Can't Change Number Format");
			} finally {
				// TODO: handle finally clause
				System.out.println(value);
			}
		}

	}
}
