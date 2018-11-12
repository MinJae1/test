package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryLanguageDAO {
	Connection con = null;
	Statement st = null;

	public CountryLanguageDAO() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<CountryLanguageDTO> selectconLan(String cc) {
		String sql = "select * FROM countrylanguage where CountryCode ='" + cc
				+ "';";
		PreparedStatement ps = null;
		List<CountryLanguageDTO> conLanlist = new ArrayList<CountryLanguageDTO>();
		try {
			ps = con.prepareStatement(sql);
//			ps.setInt(1, cc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String countryCode = rs.getString(1);
				String lan = rs.getString(2);
				float per = rs.getFloat(4);

//				conLan.setCc(countryCode);
//				conLan.setDst(District);
//				conLan.setId(id);
//				conLan.setName(Name);
//				conLan.setPp(Population);

				CountryLanguageDTO conLan = new CountryLanguageDTO(countryCode, lan,
						per);

				conLanlist.add(conLan);
			}
			rs.close();
			return conLanlist;
		} catch (Exception e) {
			// TODO: handle exception
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

	public CountryLanguageDTO selectOneconLan(CountryLanguageDTO conLan) {
		String sql = "select * FROM countrylanguage where (Language = ? and CountryCode =?);";
		PreparedStatement ps = null;
//		CountryLanguageDTO conLan = new CountryLanguageDTO();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, conLan.getLan());
			ps.setString(2, conLan.getCc());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String countryCode = rs.getString(1);
				String lan = rs.getString(2);
				String isoff = rs.getString(3);
				float per = rs.getFloat(4);

				conLan.setCc(countryCode);
				conLan.setIsof(isoff);
				conLan.setLan(lan);
				conLan.setPer(per);
			}
			rs.close();
			return conLan;
		} catch (Exception e) {
			// TODO: handle exception
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

	public void insertCountryLanguage(CountryLanguageDTO conLan) {
		// TODO Auto-generated method stub
		String sql = "insert into countrylanguage (CountryCode, Language, IsOfficial, Percentage) value (?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, conLan.getCc());
			ps.setString(2, conLan.getLan());
			ps.setString(3, conLan.getIsof());
			ps.setFloat(4, conLan.getPer());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			}
		}
	}

	public void updateconLan(CountryLanguageDTO conLan) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "update countrylanguage set Percentage=? where CountryCode = '"
				+ conLan.getCc() + "' and Language = '" + conLan.getLan() + "';";
		try {
//			System.out.println(sql + conLan.getPer());
			ps = con.prepareStatement(sql);
			ps.setFloat(1, conLan.getPer());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			}
		}

	}

	public void deleteconLan(CountryLanguageDTO conLan) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
//		System.out.println(conLan.getName());
		String sql = "delete FROM countrylanguage where CountryCode = '"
				+ conLan.getCc() + "' and Language = '" + conLan.getLan() + "';";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se2) {
			}
		}

	}

	public void close() {
		// TODO Auto-generated method stub
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
