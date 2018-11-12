package ch15;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExam {
	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();

		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Login");
			System.out.print("Id >> ");
			String id = sc.nextLine();

			System.out.print("Password >> ");
			String pwd = sc.nextLine();
			System.out.println();

			if (map.containsKey(id)) {
				if (map.get(id).equals(pwd)) {
					System.out.println("Login Success");
					break;
				} else {
					System.out.println("Password is not correct");
				}
			} else {
				System.out.println("Entered ID does not exist.");
			}

		}
		sc.close();
	}
}
