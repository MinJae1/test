package filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.Scanner;

public class Filecopy {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("file path > ");
		String filePath = sc.nextLine();

		sc.close();

		File file = new File(filePath);
		String fileName = file.getName();

		File filename = new File("filenamecopy_" + fileName);
		File dirpath = new File("C:/temp/copy");
		File targetpath = new File(new URI("file:///C:/temp/copy_" + fileName));

		if (filename.exists() == false) {
			filename.createNewFile();
		}
		if (dirpath.exists() == false) {
			dirpath.mkdirs();
		}
		if (targetpath.exists() == false) {
			targetpath.createNewFile();
		}

		byte b[] = new byte[64];
		try {
			FileInputStream fis = new FileInputStream(filePath);

			FileOutputStream fos1 = new FileOutputStream(filename);
			FileOutputStream fos2 = new FileOutputStream(targetpath);

			int i = 0;
			while ((i = fis.read(b)) != -1) {
				fos1.write(b, 0, i);
				fos2.write(b, 0, i);
			}
			fos1.flush();
			fos2.flush();
			fos1.close();
			fos2.close();
			System.out.println("\n>> COPY COMPLETE");
		} catch (Exception e) {
		}

	}
}
