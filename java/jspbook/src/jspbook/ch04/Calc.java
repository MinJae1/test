package jspbook.ch04;

public class Calc {
	int result = 0;

	public Calc(int n1, int n2, String op) {
		// TODO Auto-generated constructor stub
		if (op.equals("+")) {
			result = n1 + n2;
		} else if (op.equals("-")) {
			result = n1 - n2;
		} else if (op.equals("*")) {
			result = n1 * n2;
		} else if (op.equals("/")) {
			result = n1 / n2;
		}

	}

	public int getResult() {
		return result;
	}
}
