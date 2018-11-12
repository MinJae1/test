package ch12;

public class BeepPrint {
	public static void main(String[] args) {
		Runnable beepT = new BeepTask();
		Thread thread = new Thread(beepT);

		/*
		 * Thread thread = new Thread(new Runnable() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * Toolkit tookit = Toolkit.getDefaultToolkit(); for (int i = 0; i < 5;
		 * i++) { tookit.beep(); try { Thread.sleep(500); } catch (Exception e)
		 * { // TODO: handle exception } } } });
		 */

		/*//¶÷´Ù½Ä
		 * Thread thread = new Thread(() -> { // TODO Auto-generated method stub
		 * Toolkit tookit = Toolkit.getDefaultToolkit(); for (int i = 0; i < 5;
		 * i++) { tookit.beep(); try { Thread.sleep(500); } catch (Exception e)
		 * { // TODO: handle exception } } });
		 */

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
