package ex07;

public class LoginExam {
	public static void main(String[] args) {
		try {
			login("white", "12345");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		try {
			login("blue", "54321");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	private static void login(String id, String password) throws NoExistIDException, WrongPasswordException {
		// TODO Auto-generated method stub
		if (!id.equals("blue")) {
			throw new NoExistIDException("ID Failed");
		}

		if (!password.equals("12345")) {
			throw new WrongPasswordException("Password is Wrong");
		}
	}
}
