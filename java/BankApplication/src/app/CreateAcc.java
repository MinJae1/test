package app;
import java.util.Scanner;

public class CreateAcc {
	public static void main(Account[] accArr) {
		Scanner scan = new Scanner(System.in);
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

			Account newAcc = new Account(new_Num, depos, accOwner);

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
}
