package project;

public class MemberDTO {
	private int id;
	private String password;
	private String name;
	private int zipCode;
	private String address;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String password, String name, int zipCode, String address) {
		this.password = password;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
	}

	public MemberDTO(int id, String password, String name, int zipCode,
			String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.zipCode = zipCode;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret = String.format("%6d %10s \t%5s \t%6d %13s", id, password, name,
				zipCode, address);
		return ret;
	}
}
