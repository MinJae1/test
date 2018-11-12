package addr_ans;

import java.util.ArrayList;
import java.util.List;

/**
 * File : AddrManager.java
 * Desc : �ּҷ� ���� Ŭ����
 * @author Ȳ����(dinfree@dinfree.com)
 */
public class AddrManager {
	// �ּҷ� ����� �����ϱ� ���� ArrayList
	List<AddrBean> addrlist = new ArrayList<AddrBean>();
	
	public void delete(String sname) {
		for (AddrBean addr : addrlist) {
			if (sname.equals(addr.getUsername())) {
				addrlist.remove(addr);
				return;
			}
		}
	}
	
	public void modify(AddrBean ab) {
		for (AddrBean addr : addrlist) {
			if (ab.equals(addr)) {
				addr.setTel(ab.getTel());
				addr.setEmail(ab.getEmail());
				addr.setSex(ab.getSex());
				return;
			}
		}
	}
	
	// �ּҷ� �߰� �޼���
	public void add(AddrBean ab) {
		if (!addrlist.contains(ab))
			addrlist.add(ab);
	}
	
	// �ּҷ� ��� ���� �޼���
	public List<AddrBean> getAddrList() {
		return addrlist;
	}
	
	// Ư�� ����ڸ� �ּҷ� ��Ͽ��� �˻��ϴ� �޼���
	public AddrBean getAddr(String username) {
		for(AddrBean ab : addrlist) {
			if(ab.getUsername().equals(username))
				return ab;
		}
		return null;
	}
}
