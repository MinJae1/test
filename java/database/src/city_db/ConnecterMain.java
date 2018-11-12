package city_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnecterMain {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
//		PreparedStatement ps =  null;

		Scanner sc = new Scanner(System.in);
		System.out.println("select");
		System.out.print("Country Code >> ");
		String cc = sc.nextLine();
		sc.close();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

			st = con.createStatement();
//			String sql = "select * FROM city order by population desc limit 50;";
//			ResultSet rs = st.executeQuery(sql);
//			while (rs.next()) {
//				String Name = rs.getString(2);
//				String District = rs.getString(4);
//				int Population = rs.getInt(5);
//				System.out.printf("%-30s %-20s %,10d\n", Name, District, Population);
//			}

			String sql = "select * FROM city where CountryCode = '" + cc + "' ;";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String countryCode = rs.getString(3);
				String District = rs.getString(4);
				int Population = rs.getInt(5);
				System.out.printf("%8d %-30s %s %-20s %,10d\n", id, Name,
						countryCode, District, Population);
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
