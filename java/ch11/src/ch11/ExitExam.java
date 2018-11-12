package ch11;

public class ExitExam {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			@Override
			public void checkExit(int status) {
				// TODO Auto-generated method stub
				if (status != 5) {
					throw new SecurityException();
				}
			}
		});

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				System.exit(i);
			} catch (SecurityException e) {
				// TODO: handle exception
			}
		}
	}
}
