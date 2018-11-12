package shopping_mall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO {
	Connection con = null;

	public ShopDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ezen?verifyServerCertificate=false&useSSL=false",
					"java", "0000");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getOrderID(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT o_id " + "FROM orders "
				+ "WHERE o_price = 0 and o_customerId = " + id + ";";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet test = ps.executeQuery();
			int chk = 0;
			while (test.next()) {
				chk = test.getInt(1);
			}
			if (chk != 0) {
				update(id);
			}
			return chk;

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
		return 0;
	}

	public void check(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) " + "FROM sold_products as sp "
				+ "JOIN orders as o on sp.s_orderId = o.o_id  "
				+ "WHERE o.o_price = 0;";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet test = ps.executeQuery();
			int chk = 0;
			while (test.next()) {
				chk = test.getInt(1);
			}
			if (chk != 0) {
				update(id);
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

	public void update(int id) {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;
		String sql = "UPDATE orders SET o_price = ( "
				+ "SELECT SUM(p_unitPrice*s_quantity) " + "FROM sold_products "
				+ "JOIN products ON p_id = s_productId " + "WHERE s_orderId = " + id
				+ " " + "GROUP by s_orderId) " + "WHERE o_id = " + id + ";";
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

	public int getMaxOID() {
		// TODO Auto-generated method stub

		String sql = "SELECT MAX(o_id) from orders;";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet test = ps.executeQuery();
			int chk = 0;
			while (test.next()) {
				chk = test.getInt(1);
			}
			return chk;
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
		return 0;

	}

	public int getMinOID() {
		// TODO Auto-generated method stub

		String sql = "SELECT Min(o_id) from orders;";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet test = ps.executeQuery();
			int chk = 0;
			while (test.next()) {
				chk = test.getInt(1);
			}
			return chk;
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
		return 0;

	}

	public List<ShopDTO> saleByDate() {
		List<ShopDTO> sdList = new ArrayList<ShopDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT DATE_FORMAT(o_date,'%Y-%m-%d'),SUM(o_price) "
				+ "FROM orders " + "GROUP BY o_date;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String date = rs.getString(1);
				int price = rs.getInt(2);

				ShopDTO sdto = new ShopDTO(price, date);
				sdList.add(sdto);
			}
			rs.close();
			return sdList;

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

	public List<ShopDTO> saleByCustomer() {
		List<ShopDTO> sdList = new ArrayList<ShopDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT c.c_id, c.c_name, SUM(o.o_price)\r\n"
				+ "FROM customers AS c\r\n"
				+ "JOIN orders AS o ON c.c_id = o.o_customerId\r\n"
				+ "GROUP BY o.o_customerId;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int cID = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);

				ShopDTO sdto = new ShopDTO(price, cID, name);
				sdList.add(sdto);
			}
			rs.close();
			return sdList;

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

	public List<ShopDTO> salesByDateMon(int y, int m) {
		// TODO Auto-generated method stub
		List<ShopDTO> sdList = new ArrayList<ShopDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT p.p_id,p.p_name,p.p_unitPrice, SUM(sp.s_quantity), SUM(sp.s_quantity*p.p_unitPrice)\r\n"
				+ "FROM products AS p\r\n"
				+ "JOIN sold_products AS sp ON p.p_id =sp.s_productId\r\n"
				+ "JOIN orders AS o ON sp.s_orderId = o.o_id\r\n"
				+ "WHERE o.o_date BETWEEN DATE('" + y + "-" + m + "-01') AND DATE('"
				+ y + "-" + m + "-31')\r\n" + "GROUP BY p.p_id;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pID = rs.getInt(1);
				String pName = rs.getString(2);
				int unitPrice = rs.getInt(3);
				int Quantity = rs.getInt(4);
				int Account = rs.getInt(5);

				ShopDTO sdto = new ShopDTO(pID, unitPrice, Quantity, Account, pName);
				sdList.add(sdto);
			}
			rs.close();
			return sdList;

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

	public int login(int in_id, String in_pwd) {
		// TODO Auto-generated method stub
		int ret_id;
		PreparedStatement ps = null;
		String sql = "select c_id,c_password from customers;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String pwd = rs.getString(2);
				if (id == in_id) {
					if (pwd.equals(in_pwd)) {
						System.out.println("Login Success\n");
						ret_id = in_id;
						return ret_id;
					} else {
						System.out.println("The password is incorrect.\n");
						return 0;
					}
				}
			}
			System.out.println("ID does not exist.\n");
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

	public List<ShopDTO> productList() {
		List<ShopDTO> pList = new ArrayList<ShopDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT * FROM products;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pID = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);

				ShopDTO sdto = new ShopDTO(pID, name, price);
				pList.add(sdto);
			}
			rs.close();
			return pList;

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

	public void orderMake(int inp_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "insert into orders (o_customerId) values (" + inp_id + ");";
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

	public ShopDTO basket(ShopDTO shopDTO) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String sql = "SELECT * FROM products where p_id = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, shopDTO.getProductID());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int pID = rs.getInt(1);
				String pName = rs.getString(2);
				int unitPrice = rs.getInt(3);

				shopDTO = new ShopDTO(pID, unitPrice, shopDTO.getQuantity(),
						(shopDTO.getQuantity() * unitPrice), pName);
			}
			rs.close();
			return shopDTO;

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

	public void inOrder(ShopDTO shopDTO) {
		// TODO Auto-generated method stub
		int newOrder = getMaxOID();
//		System.out.println(newOrder);
		PreparedStatement ps = null;
		String sql = "insert into sold_products (s_orderId,s_productId,s_quantity) values ("
				+ newOrder + ",?,?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, shopDTO.getProductID());
			ps.setInt(2, shopDTO.getQuantity());
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

	public List<ShopDTO> orderList(int id) {
		// TODO Auto-generated method stub
		List<ShopDTO> pList = new ArrayList<ShopDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT \r\n" + "o.o_id, DATE_FORMAT(o.o_date,'%Y-%m-%d'),\r\n"
				+ "p.p_name, COUNT(sp.s_productId) - 1,\r\n" + "o.o_price\r\n"
				+ "FROM orders AS o\r\n"
				+ "JOIN sold_products AS sp ON o.o_id =sp.s_orderId\r\n"
				+ "JOIN products AS p ON sp.s_productId =p.p_id\r\n"
				+ "WHERE o_customerId = " + id + " " + "GROUP BY sp.s_orderId;";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int oID = rs.getInt(1);
				String date = rs.getString(2);
				String name = rs.getString(3);
				int cnt = rs.getInt(4);
				int price = rs.getInt(5);

				ShopDTO sdto = new ShopDTO(oID, date, name, price);
				sdto.setCnt(cnt);
				pList.add(sdto);
			}
			rs.close();
			return pList;

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

	public int checkOrderID(int id, int oid) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*)" + "FROM orders \r\n" + "WHERE o_customerId = "
				+ id + " and o_id = " + oid + ";";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet test = ps.executeQuery();
			int chk = 0;
			while (test.next()) {
				chk = test.getInt(1);
			}
			if (chk != 0) {
				orderDetail(oid);
			}
			return chk;

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
		return 0;
	}

	public List<ShopDTO> orderDetail(int id) {
		// TODO Auto-generated method stub
		List<ShopDTO> pList = new ArrayList<ShopDTO>();
		PreparedStatement ps = null;
		String sql = "SELECT DATE_FORMAT(o.o_date,'%Y-%m-%d'),\r\n"
				+ "p.p_name, sp.s_quantity, p.p_unitPrice, (sp.s_quantity* p.p_unitPrice)\r\n"
				+ "FROM orders AS o\r\n"
				+ "JOIN sold_products AS sp ON o.o_id =sp.s_orderId\r\n"
				+ "JOIN products AS p ON sp.s_productId =p.p_id\r\n"
				+ "WHERE o.o_id = " + id + ";";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String date = rs.getString(1);
				String name = rs.getString(2);
				int quan = rs.getInt(3);
				int uPrice = rs.getInt(4);
				int price = rs.getInt(5);

				ShopDTO sdto = new ShopDTO(date, name, quan, uPrice, price);
				pList.add(sdto);
			}
			rs.close();
			return pList;

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
