package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

			String sql = "insert into song (title, lyrics) value (?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "�Ҳɳ���");
			ps.setString(2, "test");
			ps.executeUpdate();

			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
