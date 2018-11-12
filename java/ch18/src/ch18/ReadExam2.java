package ch18;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam2 {

	public static void main(String[] args) throws Exception {
		InputStream inputStream = new FileInputStream(
				"D:\\Work Space\\java\\ch18\\src\\ch18\\test.txt");
		byte[] readbyte = new byte[3];
		int num;
		String data = "";
		while (true) {
			num = inputStream.read(readbyte);
			System.out.println(num);
			if (num == -1) {
				break;
			}
			data += new String(readbyte, 0, num);
		}
		System.out.println(data);
		inputStream.close();
	}

}
