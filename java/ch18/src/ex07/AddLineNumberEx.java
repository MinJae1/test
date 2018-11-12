package ex07;

import java.io.BufferedReader;
import java.io.FileReader;

public class AddLineNumberEx {
	public static void main(String[] args) throws Exception {
		String filePath = "D:/Work Space/java/ch18/src/ch18/BufferedReaderEx.java";

		int num = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			String data;

			while ((data = br.readLine()) != null) {
				System.out.printf("%2d : %s\n", num, data);
				num++;
			}
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
