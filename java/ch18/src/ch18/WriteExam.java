package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteExam {
	public static void main(String[] args) throws Exception {
		OutputStream outputStream = new FileOutputStream(
				"D:\\Work Space\\java\\ch18\\src\\ch18\\write_test.txt");
		byte[] data = "Sample Text".getBytes();
		for (int i = 0; i < data.length; i++) {
			outputStream.write(data[i]);
		}
		outputStream.flush();
		outputStream.close();

		InputStream inputStream = new FileInputStream(
				"D:\\Work Space\\java\\ch18\\src\\ch18\\write_test.txt");
		byte[] readByte = new byte[4];
		while (true) {
			int readLn = inputStream.read(readByte);
			if (readLn == -1) {
				break;
			}
			for (int i = 0; i < readLn; i++) {
				System.out.print((char) readByte[i]);
			}
		}
		System.out.println();
		inputStream.close();
	}
}
