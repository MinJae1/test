package ch04.sec1;

public class whilekeycontrol {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean run = true;
		int speed = 0;
		int keycode = 0;

		while (run) {
			if (keycode != 13 && keycode != 10) {
				System.out.println("*           *          *");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("*           *          *");
				System.out.print("선택 : ");
			}

			keycode = System.in.read();

			if (keycode == 49) {
				speed++;
				System.out.println("현재 속도 : " + speed);
				System.out.println();
			} else if (keycode == 50) {
				speed--;
				if (speed < 0) {
					speed = 0;
				}
				System.out.println("현재 속도 : " + speed);
				System.out.println();
			} else if (keycode == 51) {
				run = false;
			}

		}

		System.out.println("프로그램 종료");
	}

}
