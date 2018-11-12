package mysns.sns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mysns.util.DBManager;

public class MessageDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Logger logger;
	Statement st;
	private static final Logger LOG = LoggerFactory.getLogger(MessageDAO.class);

	public boolean newMsg(MessageDO messageDO) {
		// TODO Auto-generated method stub
		LOG.trace("newMsg()");
		LOG.debug(messageDO.toString());

		conn = DBManager.getConnection();
		String sql = "insert into s_message(uid,msg,date) values (?,?,now());";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, messageDO.getUid());
			pstmt.setString(2, messageDO.getMsg());
			pstmt.executeUpdate();

			return true;

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

	public boolean delMsg(int mid) {
		// TODO Auto-generated method stub
		LOG.trace("delMsg()");
		LOG.debug(String.valueOf(mid));

		conn = DBManager.getConnection();

		String sql = "DELETE FROM s_message WHERE mid = ?;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getErrorCode());
			return false;
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception se2) {
			}
		}

		return true;
	}

	public boolean newReply(Reply reply) {
		// TODO Auto-generated method stub
		LOG.trace("newReply()");
		LOG.debug(reply.toString());

		conn = DBManager.getConnection();

		String sql = "insert into s_reply(mid,uid,rmsg,date) values (?,?,?,now());";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getMid());
			pstmt.setString(2, reply.getUid());
			pstmt.setString(3, reply.getRmsg());
			pstmt.executeUpdate();

			return true;

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

	public boolean delReply(int rid) {
		// TODO Auto-generated method stub
		LOG.trace("delReply()");
		LOG.debug(String.valueOf(rid));

		conn = DBManager.getConnection();
		String sql = "DELETE FROM s_reply WHERE rid = " + rid + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}

		return false;
	}

	public ArrayList<MessageSet> getAll(int cnt, String suid) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();
		ArrayList<MessageSet> datas = new ArrayList<MessageSet>();

		LOG.trace("delReply()");
		LOG.debug(datas.toString());

		String sql;
		try {
			if ((suid == null) || suid.equals("")) {
				sql = "select * from s_message AS ms JOIN s_member AS me ON ms.uid = me.uid order by ms.date desc limit 0,?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
			} else {
				sql = "select * from s_message AS ms JOIN s_member AS me ON ms.uid = me.uid where ms.uid = ? order by ms.date desc limit 0,?;";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, suid);
				pstmt.setInt(2, cnt);
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MessageSet messageSet = new MessageSet();
				MessageDO messageDO = new MessageDO();

				ArrayList<Reply> rlist = new ArrayList<Reply>();

			
				
				messageDO.setMid(rs.getInt("mid"));
				messageDO.setMsg(rs.getString("msg"));
				messageDO.setName(rs.getString("me.name"));
				messageDO.setDate(rs.getDate("ms.date") + " / " + rs.getTime("ms.date"));
				messageDO.setFavcount(rs.getInt("favcount"));
				messageDO.setUid(rs.getString("ms.uid"));
				messageDO.setReplycount(rs.getInt("replycount"));

				String rsql = "select * FROM s_reply AS r JOIN s_member AS m ON r.uid = m.uid where mid = ? order by r.date desc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1, rs.getInt("mid"));
				ResultSet rrs = pstmt.executeQuery();
				while (rrs.next()) {
					Reply reply = new Reply();
					reply.setRid(rrs.getInt("rid"));
					reply.setName(rrs.getString("m.name"));
					reply.setUid(rrs.getString("r.uid"));
					reply.setRmsg(rrs.getString("rmsg"));
					reply.setDate(rrs.getDate("r.date") + " / " + rrs.getTime("r.date"));
					rlist.add(reply);
				}
				rrs.last();
				messageDO.setReplycount(rrs.getRow());

				messageSet.setMessageDO(messageDO);
				messageSet.setRlist(rlist);
				datas.add(messageSet);
				rrs.close();
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
		return datas;
	}

	public void favorite(int mid) {
		// TODO Auto-generated method stub
		LOG.trace("favorite()");
		LOG.debug(String.valueOf(mid));

		conn = DBManager.getConnection();
		String sql = "UPDATE s_message SET favcount = ? WHERE mid = " + mid + ";";
		try {
			int fcnt = check(mid);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fcnt + 1);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
	}

	public int check(int mid) {
		// TODO Auto-generated method stub
		LOG.trace("favorite()");
		LOG.debug(String.valueOf(mid));

		conn = DBManager.getConnection();
		String sql = "select favcount from s_message  WHERE mid = " + mid + ";";
		int fcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fcnt = rs.getInt(1);
			}
			return fcnt;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return fcnt;
	}

}
