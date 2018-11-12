package ch18;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam3 {
	public static void main(String[] args) throws Exception {
		InputStream inputStream = new FileInputStream(
				"D:\\Work Space\\java\\ch18\\src\\ch18\\test.txt");
		byte[] readbyte = new byte[8];
		int num;
		num = inputStream.read(readbyte, 2, 3);
		for (int i = 0; i < readbyte.length; i++) {
			System.out.println(readbyte[i]);
		}

		inputStream.close();
	}

}
