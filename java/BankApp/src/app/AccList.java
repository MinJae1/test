package app;

public class AccList {
	public static void List(Account[] accArr) {
		int cnt = 0;
		System.out.println("*  *  *  *");
		System.out.println(" ���¸�� ");
		System.out.println("*  *  *  *");
		System.out.println("���¹�ȣ\t������\t�ܾ�");
		for (int i = 0; i < accArr.length; i++) {
			Account newAcc = accArr[i];
			if (accArr[i] != null) {
				System.out
						.println(accArr[i].getAno() + " \t " + accArr[i].getOwner() + " \t " + accArr[i].getBalance());
				cnt++;
			}
			if (cnt == 0) {
				System.out.println("���°� �����ϴ�.");
				break;
			}
		}

		System.out.println();
	}
}
