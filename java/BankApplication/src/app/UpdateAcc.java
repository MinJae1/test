package app;
import java.util.Scanner;

public class UpdateAcc {
	private static Scanner scan = new Scanner(System.in);

	// ���
	public static void withdraw(Account[] accArr) {
		// TODO Auto-generated method stub
		String pwd = "0000";
		System.out.println("*  *  *  *");
		System.out.println("   ���   ");
		System.out.println("*  *  *  *");
		System.out.print("���¹�ȣ : ");
		String input = scan.next();
		Account newAcc = findAccount(input, accArr);
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
					System.out.println("����� �ܾ� : " + newAcc.getBalance());
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
	public static void deposit(Account[] accArr) {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println("   ����   ");
		System.out.println("*  *  *  *");
		System.out.print("���¹�ȣ : ");
		String input = scan.next();
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			System.out.print("�Աݾ� : ");
			int depos = scan.nextInt();
			int bal = newAcc.getBalance();
			newAcc.setBalance(bal + depos);
			System.out.println("�Ա��� �ܾ� : " + newAcc.getBalance());
		} else {
			System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		System.out.println();
	}

	private static Account findAccount(String ano, Account[] accArr) {
		Account acc = null;
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
