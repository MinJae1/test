package mysns.member;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Password {
	private static final Logger LOG = LoggerFactory.getLogger(Password.class);
	BCrypt bCrypt = new BCrypt();

	public String hashPwd(String pwd) {
		// TODO Auto-generated method stub
		String hPwd = bCrypt.hashpw(pwd, bCrypt.gensalt(10));
		return hPwd;
	}

	public boolean checkPwd(String inpwd, String hashpwd) {
		// TODO Auto-generated method stub
		if (inpwd.equals(hashpwd)) {
			return true;
		} else {
			return false;
		}
	}
}
