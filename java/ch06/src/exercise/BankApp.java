package exercise;

import java.util.Scanner;

public class BankApp {
	private static Account20[] accArr = new Account20[100];
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
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}

			switch (selNo) {
			case 1:
				createAcc();
				break;
			case 2:
				accList();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
		System.out.println("end");
	}

	// ����
	private static void createAcc() {
		// TODO Auto-generated method stub
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

			Account20 newAcc = new Account20(new_Num, depos, accOwner);

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

	// ���
	private static void withdraw() {
		// TODO Auto-generated method stub
		String pwd = "0000";
		System.out.println("*  *  *  *");
		System.out.println("   ���   ");
		System.out.println("*  *  *  *");
		System.out.print("���¹�ȣ : ");
		String input = scan.next();
		Account20 newAcc = findAccount(input);
		if (newAcc != null) {
			System.out.print("��й�ȣ(�ʱ� ��й�ȣ�� 0000) : ");
			String code = scan.next();
			if (code.equals(pwd)) {
				System.out.print("��ݾ� : ");
				int depos = scan.nextInt();
				int bal = newAcc.getBalance();
				if ((bal - depos) < 0) {
					System.out.println("�ܾ��� �����մϴ�.(�ܾ� : " + bal + " )");
				} else {
					newAcc.setBalance(bal - depos);
				}
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		} else {
			System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		System.out.println();
	}

	// ����
	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println("   ����   ");
		System.out.println("*  *  *  *");
		System.out.print("���¹�ȣ : ");
		String input = scan.next();
		Account20 newAcc = findAccount(input);
		if (newAcc != null) {
			System.out.print("�Աݾ� : ");
			int depos = scan.nextInt();
			int bal = newAcc.getBalance();
			newAcc.setBalance(bal + depos);
		} else {
			System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		System.out.println();
	}

	// ���
	private static void accList() {
		// TODO Auto-generated method stub
		int cnt = 0;
		System.out.println("*  *  *  *");
		System.out.println(" ���¸�� ");
		System.out.println("*  *  *  *");
		System.out.println("���¹�ȣ\t������\t�ܾ�");
		for (int i = 0; i < accArr.length; i++) {
			Account20 newAcc = accArr[i];
			if (accArr[i] != null) {
				System.out.println(accArr[i].getAno() + "\t" + accArr[i].getOwner() + "\t" + accArr[i].getBalance());
				cnt++;
			}
			if (cnt == 0) {
				System.out.println("���°� �����ϴ�.");
				break;
			}
		}

		System.out.println();
	}

	private static Account20 findAccount(String ano) {
		Account20 acc = null;
		for (int i = 0; i < accArr.length; i++) {
			if (accArr[i] != null) {
				String getNum = accArr[i].getAno();
				if (getNum.equals(ano)) {
					acc = accArr[i];
					break;
				}
			}
		}
		return acc;

	}
}
