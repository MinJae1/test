package app;
import java.util.Scanner;

public class CreateAcc {
	public static void main(Account[] accArr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("*  *  *  *");
		System.out.println(" ���»��� ");
		System.out.println("*  *  *  *");

		System.out.print("���¹�ȣ(000000-000000) : ");
		String accNum = scan.next();
		String new_Num = "";
		for (int i = 0; i < accNum.length(); i++) {
			if (48 <= accNum.charAt(i) && accNum.charAt(i) <= 57 || accNum.charAt(i) == 45) {
				new_Num = accNum;
			} else {
				new_Num = "";
				System.out.println("���Ŀ� �°� �Է����ּ���.");
				break;
			}
		}

		if (!new_Num.isEmpty()) {
			System.out.print("������ : ");
			String accOwner = scan.next();

			System.out.print("�ʱ��Աݾ� : ");
			int depos = scan.nextInt();

			Account newAcc = new Account(new_Num, depos, accOwner);

			for (int i = 0; i < accArr.length; i++) {
				if (accArr[i] == null) {
					accArr[i] = newAcc;
					System.out.println("���� ����");
					break;
				}
			}
		}

		System.out.println();

	}
}
