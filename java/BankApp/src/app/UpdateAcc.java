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
		String input = null;
		try {
			input = scan.next();
		} catch (Exception e) {
			// TODO: handle exception
			scan = new Scanner(System.in);
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			System.out.print("��й�ȣ(�ʱ� ��й�ȣ�� 0000) : ");
			String code = scan.next();
			if (code.equals(pwd)) {
				int depos = 0;
				while (true) {
					System.out.print("��ݾ� : ");
					try {
						depos = scan.nextInt();
						if (depos < 0) {
							System.out.println("������ ��� �� �� �����ϴ�.");
							continue;
						}
						break;
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("���ڸ� �Է� �� �� �ֽ��ϴ�.");
					}
				}
				int bal = newAcc.getBalance();
				try {
					new_withdraw(depos, bal, newAcc);
				} catch (BalanceInsufficientException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			}
		} else {
			System.out.println("���¹�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		System.out.println();
	}

	private static void new_withdraw(int depos, int bal, Account newacc) throws BalanceInsufficientException {
		// TODO Auto-generated method stub
		if (bal < depos) {
			throw new BalanceInsufficientException("�ܾ��� �����մϴ�.(�ܾ� : " + bal + " )");
		} else {
			newacc.setBalance(bal - depos);
			System.out.println("����� �ܾ� : " + newacc.getBalance());
		}
	}

	// ����
	public static void deposit(Account[] accArr) {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println("   ����   ");
		System.out.println("*  *  *  *");
		System.out.print("���¹�ȣ : ");
		String input = null;
		try {
			input = scan.next();
		} catch (Exception e) {
			// TODO: handle exception
			scan = new Scanner(System.in);
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			while (true) {
				System.out.print("�Աݾ� : ");
				int depos = 0;
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
				} finally {
					if (depos > 0) {
						int bal = newAcc.getBalance();
						newAcc.setBalance(bal + depos);
						System.out.println("�Ա��� �ܾ� : " + newAcc.getBalance());
					}
				}
			}

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
