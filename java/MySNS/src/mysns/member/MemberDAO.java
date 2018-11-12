package mysns.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mysns.util.DBManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Logger logger;
	private static final Logger LOG = LoggerFactory.getLogger(MemberDAO.class);

	public boolean addMember(MemberDO memberDO) {
		// TODO Auto-generated method stub
		LOG.trace("addMember()");
		LOG.debug(memberDO.toString());
		conn = DBManager.getConnection();
		BCrypt bCrypt = new BCrypt();
		String sql = "insert into s_member values (?,?,?,?,now());";
		try {
			if (check(memberDO.getUid())) {
				return false;
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberDO.getUid());
				pstmt.setString(2, memberDO.getName());
				pstmt.setString(3,
						bCrypt.hashpw(memberDO.getPasswd(), bCrypt.gensalt(10)));
				pstmt.setString(4, memberDO.getEmail());
				pstmt.executeUpdate();

				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return false;
	}

	public boolean check(String uid) {
		// TODO Auto-generated method stub
		LOG.trace("check()");
		LOG.debug(uid);

		conn = DBManager.getConnection();
		String sql = "select uid from s_member;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				if (id.equals(uid)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean login(String uid, String passwd) {
		// TODO Auto-generated method stub
		LOG.trace("check()");
		LOG.debug(uid + ", " + passwd);

		conn = DBManager.getConnection();
		BCrypt bCrypt = new BCrypt();
		String sql = "select uid,password from s_member where uid = '" + uid + "';";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String pwd = rs.getString(2);

				if (id.equals(uid)) {
					if (bCrypt.checkpw(passwd, pwd)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return false;
	}

	public String getName(String uid) {
		// TODO Auto-generated method stub
		LOG.trace("getName()");
		LOG.debug(uid);

		conn = DBManager.getConnection();
		String sql = "select name from s_member where uid = '" + uid + "';";
		String nm = "";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				nm = rs.getString(1);
			}
			return nm;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return nm;
	}

	public ArrayList<MemberDO> getNewMember() {
		// TODO Auto-generated method stub

		ArrayList<MemberDO> nmembers = new ArrayList<MemberDO>();
		LOG.trace("getNewMember()");
		LOG.debug(nmembers.toString());

		conn = DBManager.getConnection();
		String sql = "select * from s_member order by date desc limit 0,7;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDO mDo = new MemberDO();
				mDo.setUid(rs.getString("uid"));
				nmembers.add(mDo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return nmembers;
	}
}
