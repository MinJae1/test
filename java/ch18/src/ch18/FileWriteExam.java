package ch18;

import java.io.File;
import java.io.FileWriter;

public class FileWriteExam {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\temp/file.txt");
		FileWriter fw = new FileWriter(file, true);

		fw.write("�ѱ� ���� �Է� �׽�Ʈ");
		fw.flush();
		fw.close();

		System.out.println("file save");

	}
}
