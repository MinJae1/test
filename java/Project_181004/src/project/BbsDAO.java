package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDAO {
	Connection con = null;

	public BbsDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/project?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void check() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) cnt " + "FROM information_schema.tables"
				+ " WHERE table_schema = 'project' AND table_name = 'bbs';";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet test = ps.executeQuery();
			int chk = 0;
			while (test.next()) {
				chk = test.getInt(1);
			}
			if (chk != 1) {
				createTable();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			}
		}

	}

	private void createTable() {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE bbs (id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, "
				+ "memberid INT(6) UNSIGNED NOT NULL,"
				+ "title VARCHAR(50) NOT NULL, "
				+ "`date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, "
				+ "content VARCHAR(400), " + "FOREIGN KEY (memberid) "
				+ "REFERENCES member(id) ON DELETE CASCADE) CHARSET=utf8;";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.clearParameters();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			}
		}
	}

	public int login(int in_id, String in_pwd) {
		// TODO Auto-generated method stub
		int ret_id;
		PreparedStatement ps = null;
		String sql = "select id,password from member;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String pwd = rs.getString(2);
				if (id == in_id) {
					if (pwd.equals(in_pwd)) {
						System.out.println("Login Success\n");
						ret_id = in_id;
						return ret_id;
					} else {
						System.out.println("The password is incorrect.\n");
						return 0;
					}
				}
			}
			System.out.println("ID does not exist.\n");
			rs.close();
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return 0;

	}

	public void write(BbsDTO bdto) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "insert into bbs (memberid,title,content) values (?,?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bdto.getMemberId());
			ps.setString(2, bdto.getTitle());
			ps.setString(3, bdto.getContent());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
	}

	public List<BbsDTO> inqury() {
		// TODO Auto-generated method stub
		List<BbsDTO> bList = new ArrayList<BbsDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT " + "b.id, " + "b.title, " + "m.name, "
				+ "DATE_FORMAT(b.date,'%y-%m-%d %H:%i') " + "FROM " + "bbs AS b "
				+ "JOIN member AS m ON b.memberid = m.id " + "ORDER by b.date desc;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String nm = rs.getString(3);
				String date = rs.getString(4);

				BbsDTO bdto = new BbsDTO(id, title, nm, date);
				bList.add(bdto);
			}
			rs.close();
			return bList;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return null;

	}

	public BbsDTO Search(int id) {
		BbsDTO bbsDTO = new BbsDTO();
		PreparedStatement ps = null;
		String sql = "	SELECT" + "	b.title,"
				+ "	m.name, DATE_FORMAT(b.date,'%y-%m-%d %H:%i'),"
				+ "	b.content, b.id" + "	FROM" + "	bbs AS b"
				+ "	JOIN member AS m ON b.memberid = m.id" + "	WHERE b.id = " + id
				+ "	ORDER BY b.date DESC;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String nm = rs.getString(2);
				String date = rs.getString(3);
				String cont = rs.getString(4);
				bbsDTO = new BbsDTO(title, cont, nm, date);
			}
			rs.close();
			return bbsDTO;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return null;

	}

	public List<BbsDTO> Searchmem(int mId) {
		// TODO Auto-generated method stub
		List<BbsDTO> bList = new ArrayList<BbsDTO>();
		PreparedStatement ps = null;
		String sql = "	SELECT" + "	b.title,"
				+ "	m.name, DATE_FORMAT(b.date,'%y-%m-%d %H:%i'),"
				+ "	b.content, b.id" + "	FROM" + "	bbs AS b"
				+ "	JOIN member AS m ON b.memberid = m.id" + "	WHERE b.memberid = "
				+ mId + "	ORDER BY b.date DESC;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String nm = rs.getString(2);
				String date = rs.getString(3);
				String cont = rs.getString(4);

				BbsDTO bdto = new BbsDTO(title, cont, nm, date);
				bdto.setId(rs.getInt(5));
				bList.add(bdto);
			}
			rs.close();
			return bList;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return null;

	}

	public int chkmemId(int in_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int chk_id;
		String sql = "select memberid from bbs;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				if (id == in_id) {
					chk_id = in_id;
					return chk_id;
				}
			}
			rs.close();
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return 0;
	}

	public int chklistId(int in_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int chk_id;
		String sql = "select id from bbs;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				if (id == in_id) {
					chk_id = in_id;
					return chk_id;
				}
			}
			rs.close();
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return 0;
	}

	public int deleteChk(int id, int memid) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "SELECT memberid from bbs WHERE id = " + id + ";";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int chk_mem_id = rs.getInt(1);
				if (chk_mem_id == memid) {
					chk_mem_id = memid;
					return chk_mem_id;
				}
			}
			rs.close();
			return 0;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
		return 0;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "DELETE " + "FROM bbs " + "WHERE id = " + id + ";";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}
	}

	public void modify(int id, int memId, BbsDTO bdto) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "UPDATE bbs SET title = IF(memberid = " + memId + ",?,title), "
				+ "content = IF(memberid = " + memId + ",?,content)" + "WHERE id = "
				+ id + ";";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bdto.getTitle());
			ps.setString(2, bdto.getContent());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && !ps.isClosed())
					ps.close();
			} catch (SQLException se2) {
			}
		}

	}
}
