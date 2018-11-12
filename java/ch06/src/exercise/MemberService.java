package exercise;

public class MemberService {
	boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("12345")) {
			return true;
		}
		return false;

	}

	void logout(String id) {
		// TODO Auto-generated method stub
		if (id.equals("hong")) {
			System.out.println("logout");
		}
	}
}
