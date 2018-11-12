package ch18;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferInputStreamExam {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;

		FileInputStream fis = new FileInputStream(
				"D:/Work Space/java/ch18/src/ch18/Lighthouse.jpg");
		start = System.currentTimeMillis();
		while (fis.read() != -1) {
		}
		end = System.currentTimeMillis();
		System.out.println("not use buffer : " + (end - start) + "ms");
		fis.close();

		FileInputStream fis2 = new FileInputStream(
				"D:/Work Space/java/ch18/src/ch18/Lighthouse.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while (bis.read() != -1) {
		}
		end = System.currentTimeMillis();
		System.out.println("use buffer : " + (end - start) + "ms");
		bis.close();

	}
}
