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
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5. 종료");
			System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *");
			System.out.print("선택 : ");

			try {
				selNo = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				scan = new Scanner(System.in);
				System.out.println("잘못입력하셨습니다.");
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
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
		System.out.println("end");
	}

	// 생성
	private static void createAcc() {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println(" 계좌생성 ");
		System.out.println("*  *  *  *");

		System.out.print("계좌번호(000000-000000) : ");
		String accNum = scan.next();
		String new_Num = "";
		for (int i = 0; i < accNum.length(); i++) {
			if (48 <= accNum.charAt(i) && accNum.charAt(i) <= 57 || accNum.charAt(i) == 45) {
				new_Num = accNum;
			} else {
				new_Num = "";
				System.out.println("형식에 맞게 입력해주세요.");
				break;
			}
		}
		
		if (!new_Num.isEmpty()) {
			System.out.print("계좌주 : ");
			String accOwner = scan.next();

			System.out.print("초기입금액 : ");
			int depos = scan.nextInt();

			Account20 newAcc = new Account20(new_Num, depos, accOwner);

			for (int i = 0; i < accArr.length; i++) {
				if (accArr[i] == null) {
					accArr[i] = newAcc;
					System.out.println("계좌 생성");
					break;
				}
			}
		}

		System.out.println();
	}

	// 출금
	private static void withdraw() {
		// TODO Auto-generated method stub
		String pwd = "0000";
		System.out.println("*  *  *  *");
		System.out.println("   출금   ");
		System.out.println("*  *  *  *");
		System.out.print("계좌번호 : ");
		String input = scan.next();
		Account20 newAcc = findAccount(input);
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
	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("*  *  *  *");
		System.out.println("   예금   ");
		System.out.println("*  *  *  *");
		System.out.print("계좌번호 : ");
		String input = scan.next();
		Account20 newAcc = findAccount(input);
		if (newAcc != null) {
			System.out.print("입금액 : ");
			int depos = scan.nextInt();
			int bal = newAcc.getBalance();
			newAcc.setBalance(bal + depos);
		} else {
			System.out.println("계좌번호가 틀렸습니다.");
		}
		System.out.println();
	}

	// 목록
	private static void accList() {
		// TODO Auto-generated method stub
		int cnt = 0;
		System.out.println("*  *  *  *");
		System.out.println(" 계좌목록 ");
		System.out.println("*  *  *  *");
		System.out.println("계좌번호\t계좌주\t잔액");
		for (int i = 0; i < accArr.length; i++) {
			Account20 newAcc = accArr[i];
			if (accArr[i] != null) {
				System.out.println(accArr[i].getAno() + "\t" + accArr[i].getOwner() + "\t" + accArr[i].getBalance());
				cnt++;
			}
			if (cnt == 0) {
				System.out.println("계좌가 없습니다.");
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
