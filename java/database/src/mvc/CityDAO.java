package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
	Connection con = null;
	Statement st = null;

	public CityDAO() {
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

	public List<CityDTO> selectCity(int num) {
		String sql = "select * FROM city where CountryCode = 'kor' limit ?;";
		PreparedStatement ps = null;
		List<CityDTO> citylist = new ArrayList<CityDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String countryCode = rs.getString(3);
				String District = rs.getString(4);
				int Population = rs.getInt(5);

//				city.setCc(countryCode);
//				city.setDst(District);
//				city.setId(id);
//				city.setName(Name);
//				city.setPp(Population);

				CityDTO city = new CityDTO(id, Name, countryCode, District,
						Population);

				citylist.add(city);
			}
			rs.close();
			return citylist;
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

	public CityDTO selectOneCity(int inp_id) {
		String sql = "select * FROM city where id = ?;";
		PreparedStatement ps = null;
		CityDTO city = new CityDTO();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, inp_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String Name = rs.getString(2);
				String countryCode = rs.getString(3);
				String District = rs.getString(4);
				int Population = rs.getInt(5);

				city.setCc(countryCode);
				city.setDst(District);
				city.setId(id);
				city.setName(Name);
				city.setPp(Population);
			}
			rs.close();
			return city;
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

	public void insertCity(CityDTO city) {
		// TODO Auto-generated method stub
		String sql = "insert into city (Name,countryCode, District, Population) value (?,?,?,?)";
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, city.getName());
			ps.setString(2, city.getCc());
			ps.setString(3, city.getDst());
			ps.setInt(4, city.getPp());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateCity(CityDTO city) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "update city set Population=? where name = '" + city.getName()
				+ "';";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, city.getPp());
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
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public void deleteCity(CityDTO city) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
//		System.out.println(city.getName());
		String sql = "delete FROM city where District = '" + city.getDst() + "';";
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
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
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
