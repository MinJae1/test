package ch12;

public class BeepPrint2 {
	public static void main(String[] args) {
		Thread thread = new BeepThread();

		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Beep");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}
