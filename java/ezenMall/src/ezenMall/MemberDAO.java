package ezenMall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ezenMall.util.DBManager;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Logger logger;
	private static final Logger LOG = LoggerFactory.getLogger(MemberDAO.class);

	/* 회원가입 */
	public boolean addMember(MemberDO memberDO) {
		// TODO Auto-generated method stub
		LOG.trace("addMember()");
		LOG.debug(memberDO.toString());
		conn = DBManager.getConnection();
		BCrypt bCrypt = new BCrypt();
		String sql = "INSERT INTO customers (c_uid,c_name,c_password,c_email,c_date) VALUES(?,?,?,?,now());";
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

	/* id중복체크 */
	public boolean check(String uid) {
		// TODO Auto-generated method stub
		LOG.trace("check()");
		LOG.debug(uid);

		conn = DBManager.getConnection();
		String sql = "SELECT c_uid FROM customers;";
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

	/* 로그인 */
	public boolean login(String uid, String passwd) {
		// TODO Auto-generated method stub
		LOG.trace("login()");
		LOG.debug(uid + ", " + passwd);

		conn = DBManager.getConnection();
		BCrypt bCrypt = new BCrypt();
		String sql = "select c_uid,c_password from customers where c_uid = '" + uid
				+ "';";
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

	/* 회원이름 가져오기 */
	public String getName(String uid) {
		// TODO Auto-generated method stub
		LOG.trace("getName()");
		LOG.debug(uid);

		conn = DBManager.getConnection();
		String sql = "select c_name from customers where c_uid = '" + uid + "';";
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

	/* 사용자/관리자 구분 */
	public int getCode(String uid) {
		// TODO Auto-generated method stub
		LOG.trace("getName()");
		LOG.debug(uid);

		conn = DBManager.getConnection();
		String sql = "select c_code from customers where c_uid = '" + uid + "';";
		int cd = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cd = rs.getInt(1);
			}
			return cd;
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

		return cd;
	}

	/* 회원구분 아이디 */
	public int getCid(String uid) {
		// TODO Auto-generated method stub
		LOG.trace("getName()");
		LOG.debug(uid);

		conn = DBManager.getConnection();
		String sql = "select c_id from customers where c_uid = '" + uid + "';";
		int cd = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cd = rs.getInt(1);
			}
			return cd;
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

		return cd;
	}

	/* 회원리스트 */
	public ArrayList<MemberDO> getCustomerList(int sno, int eno) {
		// TODO Auto-generated method stub

		ArrayList<MemberDO> cList = new ArrayList<MemberDO>();
		LOG.trace("getCustomerList()");
		LOG.debug(cList.toString());

		conn = DBManager.getConnection();
		String sql = "select * from customers where c_code = 2 " + "Limit " + sno + ","
				+ eno + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDO mDo = new MemberDO();
				mDo.setId(rs.getInt("c_id"));
				mDo.setUid(rs.getString("c_uid"));
				mDo.setName(rs.getString("c_name"));
				mDo.setEmail(rs.getString("c_email"));
				mDo.setDate(rs.getString("c_date"));
				cList.add(mDo);
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
		return cList;
	}

	/* 회원 수 */
	public int getCustomerListCnt() {
		// TODO Auto-generated method stub

		int cnt = 0;
		LOG.trace("getCustomerList()");

		conn = DBManager.getConnection();
		String sql = "select count(*) from customers where c_code = 2;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
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
		return cnt;
	}

}
