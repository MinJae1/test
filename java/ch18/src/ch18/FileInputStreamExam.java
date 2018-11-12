package ch18;

import java.io.FileInputStream;

public class FileInputStreamExam {
	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream(
					"D:\\Work Space\\java\\ch18\\src\\ch18\\FileInputStreamExam.java");
			int data;
			while ((data = fileInputStream.read()) != -1) {
				System.out.write(data);
			}
			fileInputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
