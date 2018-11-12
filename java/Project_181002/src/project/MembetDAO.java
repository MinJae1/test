package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembetDAO {
	Connection con = null;

	public MembetDAO() {
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
				+ " WHERE table_schema = 'project' AND table_name = 'member';";
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

	public void createTable() {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE member (id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT, "
				+ "`password` VARCHAR(10) NOT NULL, " + "name VARCHAR(10) NOT NULL, "
				+ "zipCode INT(6) UNSIGNED NOT NULL DEFAULT 0, "
				+ "address VARCHAR(50), CONSTRAINT member PRIMARY KEY(id)) CHARSET=utf8;";
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

	public void initializeId() {
		PreparedStatement ps = null;
		String sql_id = "ALTER TABLE member AUTO_INCREMENT=100001;";
		try {
			ps = con.prepareStatement(sql_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertMember(MemberDTO mDto) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "insert into member (password,name,zipCode,address) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mDto.getPassword());
			ps.setString(2, mDto.getName());
			ps.setString(4, mDto.getAddress());
			ps.setInt(3, mDto.getZipCode());
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

	public List<MemberDTO> inquiry() {
		PreparedStatement ps = null;
		List<MemberDTO> memList = new ArrayList<MemberDTO>();
		String sql = "select * from member order by id desc;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String pwd = rs.getString(2);
				String nm = rs.getString(3);
				int code = rs.getInt(4);
				String ad = rs.getString(5);

				MemberDTO mdto = new MemberDTO(id, pwd, nm, code, ad);
				memList.add(mdto);
			}
			rs.close();
			return memList;
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

	public void updateMember(MemberDTO mDto) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "update member set password=? , name = ?, address = ?,zipCode =? where id = "
				+ mDto.getId() + ";";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mDto.getPassword());
			ps.setString(2, mDto.getName());
			ps.setString(3, mDto.getAddress());
			ps.setInt(4, mDto.getZipCode());
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

	public void deleteMember(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "delete from member where id = " + id + ";";
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

	public List<MemberDTO> search(String name) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "select * from member where name = '" + name + "';";
		List<MemberDTO> memList = new ArrayList<MemberDTO>();
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String pwd = rs.getString(2);
				String nm = rs.getString(3);
				int code = rs.getInt(4);
				String ad = rs.getString(5);

				MemberDTO mdto = new MemberDTO(id, pwd, nm, code, ad);
				memList.add(mdto);
			}
			rs.close();
			return memList;
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

	public void login(int in_id, String in_pwd) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "select id,password from member;";
		Try: try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String pwd = rs.getString(2);
				if (id == in_id) {
					if (pwd.equals(in_pwd)) {
						System.out.println("Login Success");
						break Try;
					} else {
						System.out.println("The password is incorrect.");
						break Try;
					}
				}
			}
			System.out.println("ID does not exist.");
			rs.close();
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

	public int CheckIDLogin(int in_id, String in_pwd) {
		// TODO Auto-generated method stub
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
						System.out.println("Login Success");
						return 1;
					} else {
						System.out.println("The password is incorrect.");
						return 2;
					}
				}
			}
			System.out.println("ID does not exist.");
			rs.close();

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
		return 3;
	}

	public int chkId(int in_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int chk_id;
		String sql = "select id from member;";
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

	public String chkNm(String in_name) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String chk_nm;
		String sql = "select name from member;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				if (name.equals(in_name)) {
					chk_nm = in_name;
					return chk_nm;
				}
			}
			rs.close();
			return null;
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

}
