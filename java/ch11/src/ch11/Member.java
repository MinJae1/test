package ch11;

public class Member {
	public String id;

	public Member(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Member Class : \"" + id + "\"";
	}

	public boolean equal(Object obj) {

		if (obj instanceof Member) {
			Member member = (Member) obj;
			if (id.equals(member.id)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}

}
