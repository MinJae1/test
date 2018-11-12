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
		String input = null;
		try {
			input = scan.next();
		} catch (Exception e) {
			// TODO: handle exception
			scan = new Scanner(System.in);
			System.out.println("잘못 입력하셨습니다.");
		}
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			System.out.print("비밀번호(초기 비밀번호는 0000) : ");
			String code = scan.next();
			if (code.equals(pwd)) {
				int depos = 0;
				while (true) {
					System.out.print("출금액 : ");
					try {
						depos = scan.nextInt();
						if (depos < 0) {
							System.out.println("음수는 출금 할 수 없습니다.");
							continue;
						}
						break;
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("숫자만 입력 할 수 있습니다.");
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
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			System.out.println("계좌번호가 틀렸습니다.");
		}
		System.out.println();
	}

	private static void new_withdraw(int depos, int bal, Account newacc) throws BalanceInsufficientException {
		// TODO Auto-generated method stub
		if (bal < depos) {
			throw new BalanceInsufficientException("잔액이 부족합니다.(잔액 : " + bal + " )");
		} else {
			newacc.setBalance(bal - depos);
			System.out.println("출금후 잔액 : " + newacc.getBalance());
		}
	}

	// 예금
	public static void deposit(Account[] accArr) {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println("   예금   ");
		System.out.println("*  *  *  *");
		System.out.print("계좌번호 : ");
		String input = null;
		try {
			input = scan.next();
		} catch (Exception e) {
			// TODO: handle exception
			scan = new Scanner(System.in);
			System.out.println("잘못 입력하셨습니다.");
		}
		Account newAcc = findAccount(input, accArr);
		if (newAcc != null) {
			while (true) {
				System.out.print("입금액 : ");
				int depos = 0;
				try {
					depos = scan.nextInt();
					if (depos < 0) {
						System.out.println("음수는 입금 할 수 없습니다.");
						continue;
					}
					break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("숫자만 입력 할 수 있습니다.");
				} finally {
					if (depos > 0) {
						int bal = newAcc.getBalance();
						newAcc.setBalance(bal + depos);
						System.out.println("입금후 잔액 : " + newAcc.getBalance());
					}
				}
			}

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
