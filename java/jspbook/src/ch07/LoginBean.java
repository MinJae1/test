package ch07;

public class LoginBean {
	private String userid;
	private String passwd;

	final private String _userid = "testid";
	final private String _passwd = "1234";

	public boolean checkUser() {
		// TODO Auto-generated method stub
		if (userid.equals(_userid) && passwd.equals(_passwd)) {
			return true;
		} else {
			return false;
		}
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
