package city_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Update");
		System.out.print("city name >> ");
		String ct_nm = sc.nextLine();
		System.out.print("Population >> ");
		int pp = sc.nextInt();
		sc.close();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

			String sql = "update city set Population=? where name = '" + ct_nm
					+ "';";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pp);
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
		System.out.println("Update finish");
	}
}
