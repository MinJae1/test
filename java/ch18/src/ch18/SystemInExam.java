package ch18;

import java.io.InputStream;

public class SystemInExam {
	public static void main(String[] args) throws Exception {
		System.out.println("***Menu***");
		System.out.println("1. inquiry\n2. withdrawal\n3. deposit\n4. close");

		InputStream inputStream = System.in;

		char input = (char) inputStream.read();

		switch (input) {
		case '1':
			System.out.println("Select inquiry");
			break;
		case '2':
			System.out.println("Select withdrawal");
			break;
		case '3':
			System.out.println("Select deposit");
			break;
		case '4':
			System.out.println("Select close");
			break;
		}
	}
}
