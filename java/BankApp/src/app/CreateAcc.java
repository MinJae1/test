package app;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateAcc {
	public static void Create(Account[] accArr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("*  *  *  *");
		System.out.println(" ���»��� ");
		System.out.println("*  *  *  *");

		System.out.print("���¹�ȣ(000000-000000) : ");
		String accNum = scan.next();
		String accForm = "\\d+-\\d+";
		String new_Num = "";
		if (Pattern.matches(accForm, accNum)) {
			new_Num = accNum;
		} else {
			new_Num = "";
			System.out.println("���Ŀ� �°� �Է����ּ���.");
		}

		if (!new_Num.isEmpty()) {
			System.out.print("������ : ");
			String accOwner = scan.next();
			int depos = 0;
			while (true) {
				System.out.print("�ʱ��Աݾ� : ");
				try {
					depos = scan.nextInt();
					if (depos < 0) {
						System.out.println("������ �Ա� �� �� �����ϴ�.");
						continue;
					}
					break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("���ڸ� �Է� �� �� �ֽ��ϴ�.");
				}
			}
			Account newAcc = new Account(new_Num, depos, accOwner);

			for (int i = 0; i < 3; i++) {
				try {
					if (accArr[i] == null) {

						accArr[i] = newAcc;
						System.out.println("���� ����");

						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO: handle exception
					System.out.println("�迭�� �ʰ��Ͽ����ϴ�.");
				}
			}
		}

		System.out.println();

	}
}
