package app;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateAcc {
	public static void Create(Account[] accArr) {
		Scanner scan = new Scanner(System.in);
		System.out.println("*  *  *  *");
		System.out.println(" 계좌생성 ");
		System.out.println("*  *  *  *");

		System.out.print("계좌번호(000000-000000) : ");
		String accNum = scan.next();
		String accForm = "\\d+-\\d+";
		String new_Num = "";
		if (Pattern.matches(accForm, accNum)) {
			new_Num = accNum;
		} else {
			new_Num = "";
			System.out.println("형식에 맞게 입력해주세요.");
		}

		if (!new_Num.isEmpty()) {
			System.out.print("계좌주 : ");
			String accOwner = scan.next();
			int depos = 0;
			while (true) {
				System.out.print("초기입금액 : ");
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
				}
			}
			Account newAcc = new Account(new_Num, depos, accOwner);

			for (int i = 0; i < 3; i++) {
				try {
					if (accArr[i] == null) {

						accArr[i] = newAcc;
						System.out.println("계좌 생성");

						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO: handle exception
					System.out.println("배열을 초과하였습니다.");
				}
			}
		}

		System.out.println();

	}
}
