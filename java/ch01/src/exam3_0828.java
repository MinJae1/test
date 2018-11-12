import java.util.Scanner;

public class exam3_0828 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt();
		int a;
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			for (a = 1; a < i + 1; a++) {
				if ((i % a) == 0) {
//					System.out.println(i+"ÀÇ ¾à¼ö :"+ a);
//					System.out.println("if ((i % a) == 0)");
					if (a != i) {
//						System.out.println(sum + " += " + a);
						sum += a;
					}

				}
			}
			
			if (sum == i) {
				System.out.println(i);
			}

			sum = 0;
		}
		scan.close();

	}
}
