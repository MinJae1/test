package adbook;

import java.util.ArrayList;
import java.util.List;

public class AddrManager {
	List<AddrBean> addrlist = new ArrayList<AddrBean>();

	public void del(String name) {
		// TODO Auto-generated method stub
		for (AddrBean ad : addrlist) {
			if (name.equals(ad.getUsername())) {
				addrlist.remove(ad);
			}
		}
	}

	
	public void add(AddrBean ad) {
		// TODO Auto-generated method stub
		addrlist.add(ad);
	}

	public List<AddrBean> getAddrlist() {
		return addrlist;
	}

	public void mod(AddrBean ad) {
		// TODO Auto-generated method stub
		String nm = ad.getUsername();
		for (AddrBean addrBean : addrlist) {
			if (nm.equals(addrBean.getUsername())) {
				addrBean.setEmail(ad.getEmail());
				addrBean.setGender(ad.getGender());
				addrBean.setTel(ad.getTel());
			}
		}

	}

}
