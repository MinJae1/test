package v;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VDAO {
	Connection con = null;

	public VDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/v?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(VDTO vdto) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "INSERT INTO album (album_id, name, issue_date, album_type) VALUES (?, ?, ?, CASE WHEN album_id<20000 && album_id>10000 THEN 'Single' WHEN album_id<30000 && album_id>20000 THEN 'Regularity' WHEN album_id<40000 && album_id>30000 THEN 'Mini' WHEN album_id<50000 && album_id>40000 THEN 'Repackage' else 'Special Package' end);";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, vdto.getAlbum_id());
			ps.setString(2, vdto.getName());
			ps.setString(3, vdto.getIssue_date());
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

	public void insertSong(VDTO vdto) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "INSERT INTO song (title) VALUES (?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vdto.getTitle());
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

	public void update(int id) {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;
		String sql = "		UPDATE song SET issue_date=( "
				+ "				SELECT ne.new_id " + "				FROM ( "
				+ "				SELECT a.issue_date new_id, "
				+ "				song_id " + "				FROM album AS a "
				+ "				JOIN song AS s ON album_id = song_album_id) ne "
				+ "				WHERE ne.song_id = " + id + ") "
				+ "				WHERE song_id = " + id + "; ";
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

}
