package app;

public class AccList {
	public static void main(Account[] accArr) {
		int cnt = 0;
		System.out.println("*  *  *  *");
		System.out.println(" ���¸�� ");
		System.out.println("*  *  *  *");
/*		System.out.print("���¹�ȣ");
		System.out.print("\t");
		System.out.print("������");
		System.out.print("\t");
		System.out.print("�ܾ�");
*/		System.out.println("���¹�ȣ\t������\t�ܾ�");
		for (int i = 0; i < accArr.length; i++) {
			Account newAcc = accArr[i];
			if (accArr[i] != null) {
/*				System.out.print(accArr[i].getAno());
				System.out.print(" \t ");
				System.out.print(accArr[i].getOwner());
				System.out.print(" \t ");
				System.out.print(accArr[i].getBalance());
				System.out.println();
*/
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
