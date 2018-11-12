package app;
import java.util.Scanner;

public class UpdateAcc {
	private static Scanner scan = new Scanner(System.in);

	// 출금
	public static void withdraw(Account[] accArr) {
		// TODO Auto-generated method stub
		String pwd = "0000";
		System.out.println("*  *  *  *");
		System.out.println("   출금   ");
		System.out.println("*  *  *  *");
		System.out.print("계좌번호 : ");
		String input = scan.next();
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			System.out.print("비밀번호(초기 비밀번호는 0000) : ");
			String code = scan.next();
			if (code.equals(pwd)) {
				System.out.print("출금액 : ");
				int depos = scan.nextInt();
				int bal = newAcc.getBalance();
				if ((bal - depos) < 0) {
					System.out.println("잔액이 부족합니다.(잔액 : " + bal + " )");
				} else {
					newAcc.setBalance(bal - depos);
					System.out.println("출금후 잔액 : " + newAcc.getBalance());
				}
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("계좌번호가 틀렸습니다.");
		}
		System.out.println();
	}

	// 예금
	public static void deposit(Account[] accArr) {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println("   예금   ");
		System.out.println("*  *  *  *");
		System.out.print("계좌번호 : ");
		String input = scan.next();
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			System.out.print("입금액 : ");
			int depos = scan.nextInt();
			int bal = newAcc.getBalance();
			newAcc.setBalance(bal + depos);
			System.out.println("입금후 잔액 : " + newAcc.getBalance());
		} else {
			System.out.println("계좌번호가 틀렸습니다.");
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
