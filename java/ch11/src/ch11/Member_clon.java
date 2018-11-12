package ch11;

public class Member_clon implements Cloneable {
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;

	public Member_clon(String id, String name, String password, int age, boolean adult) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.adult = adult;
		this.age = age;
		this.name = name;
		this.password = password;
	}

	public Member_clon getMember_clon() {
		// TODO Auto-generated constructor stub
		Member_clon cloned = null;
		try {
			cloned = (Member_clon) clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
		return cloned;
	}
}
