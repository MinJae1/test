package grep;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Grep {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("file path > ");
		String filePath = sc.nextLine();

		String searchpath = "C:/temp/Grep.txt";

		FileOutputStream searchStream = new FileOutputStream(searchpath);
		System.out.print("Search Word > ");
		String search_data = sc.nextLine();
		sc.close();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			BufferedOutputStream bo = new BufferedOutputStream(searchStream);

			String readLine;
			String search_line = "";

			while ((readLine = br.readLine()) != null) {
				if (readLine.contains(search_data)) {
					search_line += String.format("%s%n", readLine);
				}
			}

			if (search_line.equals("")) {
				search_line = "No search results";
			}

			byte[] searchB = search_line.getBytes();
			bo.write(searchB);

			br.close();
			bo.close();

			System.out.println("Search compelete");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
