package city_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("insert");
		System.out.print("city name >> ");
		String ct_nm = sc.nextLine();
		System.out.print("Country Code >> ");
		String cc = sc.nextLine();
		System.out.print("District >> ");
		String dt = sc.nextLine();
		System.out.print("Population >> ");
		int pp = sc.nextInt();
		sc.close();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

			String sql = "insert into city (Name,countryCode, District, Population) value (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ct_nm);
			ps.setString(2, cc);
			ps.setString(3, dt);
			ps.setInt(4, pp);
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

		System.out.println("insert finish");
	}
}
