package addr_ans;

import java.util.Objects;

/**
 * Desc : �ּҷ� ���� Ŭ����
 * @author Ȳ����(dinfree@dinfree.com)
 */
public class AddrBean {
	//������� ����
	private String username;
	private String tel;
	private String email;
	private String sex;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AddrBean) {
			AddrBean ab = (AddrBean) obj;
			return ab.getUsername().equals(username);
		} else {
			return false;
		}	
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(username);
	}
}
