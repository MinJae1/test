package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExam {
	public static void main(String[] args) throws Exception {
		String origin = "D:/Work Space/java/ch18/src/ch18/Lighthouse.jpg";
		String targetname = "C:/temp/Lighthouse.jpg";

		FileInputStream fileInputStream = new FileInputStream(origin);
		FileOutputStream fileOutputStream = new FileOutputStream(targetname);

		int byteNo;
		byte[] rebytes = new byte[100];

		while ((byteNo = fileInputStream.read(rebytes)) != -1) {
			fileOutputStream.write(rebytes, 0, byteNo);
		}

		fileOutputStream.flush();
		fileOutputStream.close();
		fileInputStream.close();

		System.out.println("copy compelete");
	}
}
