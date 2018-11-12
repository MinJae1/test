package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnecterMain {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
//		PreparedStatement ps =  null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

			st = con.createStatement();
			int id = 110;
			String sql = "select * FROM song where _id = " + id + ";";
//			ps = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int songId = rs.getInt(1);
				String title = rs.getString(2);
				String lyrics = rs.getString(3);
				System.out.printf("%8d %-15s\t%s\n", songId, title, lyrics);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
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
