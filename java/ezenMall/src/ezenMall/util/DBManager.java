package ezenMall.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	Statement st;
	PreparedStatement pstmt;

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn;

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource db = (DataSource) envContext.lookup("jdbc/ezenmall");
			conn = db.getConnection();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;

		}
		return conn;

	}
}
