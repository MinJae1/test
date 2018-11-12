package app;

import java.util.Scanner;

public class BankApp {
	private static Account[] accArr = new Account[100];
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		int selNo = 0;
		while (run) {
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5. ����");
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
			System.out.print("���� : ");

			try {
				selNo = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				scan = new Scanner(System.in);
//				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}

			switch (selNo) {
			case 1:
				CreateAcc create = new CreateAcc();
				create.main(accArr);
				break;
			case 2:
				AccList list = new AccList();
				list.main(accArr);
				break;
			case 3:
				UpdateAcc update_des = new UpdateAcc();
				update_des.deposit(accArr);
				break;
			case 4:
				UpdateAcc update_with = new UpdateAcc();
				update_with.withdraw(accArr);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				System.out.println();
				break;
			}
		}
		System.out.println("end");
	}
}
