package ch11;

import java.io.IOException;

public class KeyboardToStringExam {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];

		System.out.print("insert : ");
		int readByteNo = System.in.read(bytes);

		String str = new String(bytes, 0, readByteNo - 2);
		System.out.println(str);
	}
}
