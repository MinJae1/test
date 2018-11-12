package ch18;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = new FileInputStream(
				"D:\\Work Space\\java\\ch18\\src\\ch18\\test.txt");
		int readbyte;

		while (true) {
			readbyte = inputStream.read();
			if (readbyte == -1) {
				break;
			}
			System.out.println((char) readbyte);
		}
		inputStream.close();
	}
}
