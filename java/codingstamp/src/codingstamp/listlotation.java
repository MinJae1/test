package codingstamp;

import java.util.Scanner;

public class listlotation {
	public static void main(String[] args) {
		String str;
		Scanner scan = new Scanner(System.in);

		System.out.println("����� �����Ͽ� Ƚ���� �̵� ���ڿ��� �Է��ϼ���");
		str = scan.nextLine();

		String[] lot = str.split(" ");

		String[] lot_str = null;

		int num = Integer.parseInt(lot[0]);

		lot_str = new String[lot.length-1];
		
		for (int i = 1; i < lot.length; i++) {
			if ((i + num) >= lot_str.length) {
				if (i + num == lot_str.length) {
					lot_str[lot_str.length-1] = lot[i];	
				} else {
					lot_str[i + num - lot_str.length-1] = lot[i];
				}
			} else {
				lot_str[i + num-1] = lot[i];
			}
		}

		for (int i = 0; i < lot_str.length; i++) {
			System.out.print(lot_str[i] + " ");
		}

		scan.close();
	}
}
