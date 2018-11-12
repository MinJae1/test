package ch18;

import java.io.InputStream;

public class SysteInExam2 {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = System.in;

		byte[] data = new byte[100];

		System.out.print("name : ");
		int nameByte = inputStream.read(data);
		String name = new String(data, 0, nameByte - 2);

		System.out.print("message : ");
		int commmetByte = inputStream.read(data);
		String comment = new String(data, 0, commmetByte - 2);

		System.out.println("input name : " + name);
		System.out.println("input message : " + comment);

	}
}
