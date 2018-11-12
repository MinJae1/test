package ezenMall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ezenMall.util.DBManager;

public class SaleDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Logger logger;
	private static final Logger LOG = LoggerFactory.getLogger(SaleDAO.class);

	/* 페이징 */
	public int[] paging_fn(int pageno, int total_record, int page_per_record_cnt) {

		if (pageno < 1) {// 현재 페이지
			pageno = 1;
		}

		int group_per_page_cnt = 3; // 페이지 당 보여줄 번호 수

		int record_end_no = pageno * page_per_record_cnt;
		int record_start_no = record_end_no - (page_per_record_cnt - 1);
		if (record_end_no > total_record) {
			record_end_no = total_record;
		}

		int total_page = total_record / page_per_record_cnt
				+ (total_record % page_per_record_cnt > 0 ? 1 : 0);
		if (pageno > total_page) {
			pageno = total_page;
		}

//	 	현재 페이지(정수) / 한페이지 당 보여줄 페지 번호 수(정수) + (그룹 번호는 현제 페이지(정수) % 한페이지 당 보여줄 페지 번호 수(정수)>0 ? 1 : 0)
		int group_no = pageno / group_per_page_cnt
				+ (pageno % group_per_page_cnt > 0 ? 1 : 0);
//			현재 그룹번호 = 현재페이지 / 페이지당 보여줄 번호수 (현재 페이지 % 페이지당 보여줄 번호 수 >0 ? 1:0)	

		int page_eno = group_no * group_per_page_cnt;
//			현재 그룹 끝 번호 = 현재 그룹번호 * 페이지당 보여줄 번호 

		int page_sno = page_eno - (group_per_page_cnt - 1);
//	 		현재 그룹 시작 번호 = 현재 그룹 끝 번호 - (페이지당 보여줄 번호 수 -1)

		if (page_eno > total_page) {
//		   현재 그룹 끝 번호가 전체페이지 수 보다 클 경우		
			page_eno = total_page;
//		   현재 그룹 끝 번호와 = 전체페이지 수를 같게
		}

		int prev_pageno = page_sno - group_per_page_cnt;
//			이전 페이지 번호	= 현재 그룹 시작 번호 - 페이지당 보여줄 번호수	

		int next_pageno = page_sno + group_per_page_cnt;
//			다음 페이지 번호 = 현재 그룹 시작 번호 + 페이지당 보여줄 번호수

		if (prev_pageno < 1) {
//			이전 페이지 번호가 1보다 작을 경우		
			prev_pageno = 1;
//			이전 페이지를 1로
		}
		if (next_pageno > total_page) {
//			다음 페이지보다 전체페이지 수보가 클경우		
			next_pageno = total_page / group_per_page_cnt * group_per_page_cnt + 1;
//			next_pageno=total_page
//			다음 페이지 = 전체페이지수 / 페이지당 보여줄 번호수 * 페이지당 보여줄 번호수 + 1 

		}

		int pageArray[] = { prev_pageno, page_sno, page_eno, next_pageno, total_page,
				record_start_no, record_end_no, group_no };

		return pageArray;
	}

	/* 품목 리스트 */
	public ArrayList<ProductDO> getItemList(int cat, int sno, int eno) {
		ArrayList<ProductDO> pList = new ArrayList<ProductDO>();
		LOG.trace("getItemList()");
		LOG.debug(pList.toString());

		conn = DBManager.getConnection();
		String sql = "select * from products";
		if (cat != 0) {
			sql += " where p_code = " + cat;
		}
		sql += " LIMIT " + sno + "," + eno;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDO pDo = new ProductDO();
				pDo.setpId(rs.getInt("p_id"));
				pDo.setpName(rs.getString("p_name"));
				pDo.setpPrice(rs.getInt("p_unitPrice"));
				pDo.setImg(rs.getString("p_img"));
				pDo.setCode(rs.getInt("p_code"));
				pList.add(pDo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return pList;
	}

	/* 품목 상세페이지 */
	public ProductDO getItem(int pid) {
		// TODO Auto-generated method stub
		ProductDO pDo = new ProductDO();
		LOG.trace("getItem()");
		LOG.debug(pDo.toString());

		conn = DBManager.getConnection();
		String sql = "select * from products where p_id = " + pid + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pDo.setpId(rs.getInt("p_id"));
				pDo.setpName(rs.getString("p_name"));
				pDo.setpPrice(rs.getInt("p_unitPrice"));
				pDo.setpDetail(rs.getString("p_detail"));
				pDo.setImg(rs.getString("p_img"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return pDo;

	}

	/* 품목입력 */
	public void addProduct(ProductDO productDO) {
		// TODO Auto-generated method stub
		LOG.trace("addProduct()");
		LOG.debug(productDO.toString());
		conn = DBManager.getConnection();
		String sql = "";
		if (!productDO.getImg().equals("")) {
			sql = "INSERT INTO products (p_name,p_unitPrice,p_detail,p_code,p_img) VALUES(?,?,?,?,?);";
		} else {
			sql = "INSERT INTO products (p_name,p_unitPrice,p_detail,p_code) VALUES(?,?,?,?);";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDO.getpName());
			pstmt.setInt(2, productDO.getpPrice());
			pstmt.setString(3, productDO.getpDetail());
			pstmt.setInt(4, productDO.getCode());
			if (!productDO.getImg().equals("")) {
				pstmt.setString(5, productDO.getImg());
			}
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	/* 품목수정 */
	public void modProduct(ProductDO productDO) {
		// TODO Auto-generated method stub
		LOG.trace("modProduct()");
		LOG.debug(productDO.toString());
		conn = DBManager.getConnection();
		String sql = "";
		if (!productDO.getImg().equals("")) {
			sql = "UPDATE products SET p_name=?,p_unitPrice=?,p_detail=?,p_code=?,p_img=? WHERE p_id="
					+ productDO.getpId() + ";";
		} else {
			sql = "UPDATE products SET p_name=?,p_unitPrice=?,p_detail=?,p_code=? WHERE p_id="
					+ productDO.getpId() + ";";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productDO.getpName());
			pstmt.setInt(2, productDO.getpPrice());
			pstmt.setString(3, productDO.getpDetail());
			pstmt.setInt(4, productDO.getCode());
			if (!productDO.getImg().equals("")) {
				pstmt.setString(5, productDO.getImg());
			}
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	/* 품목삭제 */
	public void delProduct(int pid) {
		// TODO Auto-generated method stub
		LOG.trace("modProduct()");
		conn = DBManager.getConnection();
		String sql = "DELETE FROM products WHERE p_id=" + pid + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	/* 품목갯수 */
	public int getitemCount(int cat) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();
		String sql = "SELECT COUNT(*) FROM products ";
		if (cat != 0) {
			sql += "where p_code = " + cat + ";";
		}

		int no = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				no = rs.getInt(1);
			}
			return no;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
		return no;
	}

	/* 이미지체크 */
	public String getImgName() {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();
		String sql = "select p_img from products order by p_id desc limit 1;";
		String chk = "";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				chk = rs.getString(1);
			}
			return chk;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
		return chk;
	}

	///////////////////////////////////// 장바구니페이지////////////////////////////////////////

	/* 가장 큰 orderId */
	public int getMaxOID() {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "SELECT MAX(o_id) from orders;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int chk = 0;
			while (rs.next()) {
				chk = rs.getInt(1);
			}
			return chk;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
		return 0;

	}

	/* 새 주문 추가 */
	public void orderMake(int inp_id) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "insert into orders (o_customerId) values (" + inp_id + ");";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
	}

	/* 가장 최근 주문번호가져오기 */
	public int getOrderNm() {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();
		String sql = "select o_id from orders order by o_date desc limit 1;";
		int no = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				no = rs.getInt(1);
			}
			return no;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
		return no;
	}

	/* 장바구니 담기 */
	public void inCart(ProductDO pDo) {
		// TODO Auto-generated method stub
		int newOrder = getMaxOID();
		conn = DBManager.getConnection();

		String sql = "insert into sold_products (s_orderId,s_productId,s_quantity) values ("
				+ newOrder + ",?,?);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pDo.getpId());
			pstmt.setInt(2, pDo.getpQuantity());
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();

				}
			} catch (SQLException se2) {
			}
		}
	}

	/* 장바구니에서 같은 물건 체크 */
	public int checkCart(int id) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();
		String sql = "select s_quantity from sold_products WHERE s_productId = " + id
				+ " and s_code = 1;";
		int no = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				no = rs.getInt(1);
			}
			return no;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
		return no;
	}

	/* 장바구니 물건 갯수 + */
	public void updateQuantity(int id, int quan) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "UPDATE sold_products SET s_quantity = " + quan
				+ " WHERE s_productId = " + id + " and s_code = 1;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();

				}
			} catch (SQLException se2) {
			}
		}
	}

	/* order 테이플 가격 설정 */
	public void updatePrice(int id) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "UPDATE orders SET o_price = ( "
				+ "SELECT SUM(p_unitPrice*s_quantity) " + "FROM sold_products "
				+ "JOIN products ON p_id = s_productId " + "WHERE s_orderId = " + id + " "
				+ "GROUP by s_orderId), o_date = now() WHERE o_id = " + id + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
	}

	/* 결제 */
	public void update(int id, int setid) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "UPDATE sold_products SET s_orderId=" + setid
				+ ", s_code = 2 WHERE s_orderId = " + id + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
	}

	/* 장바구니 리스트 */
	public ArrayList<OrderDO> CartList(int id) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		ArrayList<OrderDO> oList = new ArrayList<OrderDO>();
		String sql = "SELECT o.o_id, DATE_FORMAT(o.o_date,'%Y-%m-%d') as d ,p.p_name, "
				+ "COUNT(sp.s_productId) - 1 AS cnt, p.p_unitPrice, sp.s_quantity, p.p_img "
				+ "FROM orders AS o "
				+ "JOIN sold_products AS sp ON o.o_id =sp.s_orderId "
				+ "JOIN products AS p ON sp.s_productId =p.p_id "
				+ "WHERE o_customerId = " + id
				+ " and sp.s_code = 1 GROUP BY sp.s_orderId;";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO oDo = new OrderDO();
				oDo.setoId(rs.getInt("o.o_id"));
				oDo.setDate(rs.getString("d"));
				oDo.setpName(rs.getString("p.p_name"));
				oDo.setpPrice(rs.getInt("p.p_unitPrice"));
				oDo.setpQuantity(rs.getInt("sp.s_quantity"));
				oDo.setImg(rs.getString("p.p_img"));

				oList.add(oDo);
			}
			rs.close();
			return oList;

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}

		return null;
	}

	/* 장바구니 지우기 */
	public void deleteCart(int oid) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "DELETE FROM orders WHERE o_id = " + oid + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
	}

	/* order 테이블 정리 */
	public void arrageOrder() {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		String sql = "DELETE FROM orders WHERE o_id = any( " + "SELECT sel_id " + "FROM( "
				+ "SELECT o.o_id sel_id " + "FROM sold_products s " + "RIGHT OUTER "
				+ "JOIN orders o ON s.s_orderId =o.o_id "
				+ "WHERE s.s_orderId IS NULL) temp);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}
	}

	/* 주문내역 */
	public ArrayList<OrderDO> OrderHistory(int id) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		ArrayList<OrderDO> oList = new ArrayList<OrderDO>();
		String sql = "SELECT o.o_id, DATE_FORMAT(o.o_date,'%Y-%m-%d') AS d,p.p_name, "
				+ "COUNT(sp.s_productId) - 1 AS cnt, o.o_price, p.p_img "
				+ "FROM orders AS o "
				+ "JOIN sold_products AS sp ON o.o_id =sp.s_orderId "
				+ "JOIN products AS p ON sp.s_productId =p.p_id "
				+ "WHERE o_customerId = " + id + " AND sp.s_code = 2 "
				+ "GROUP BY sp.s_orderId ORDER BY o.o_date desc;";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO oDo = new OrderDO();
				oDo.setoId(rs.getInt("o.o_id"));
				oDo.setDate(rs.getString("d"));
				oDo.setpName(rs.getString("p.p_name"));
				oDo.setCnt(rs.getInt("cnt"));
				oDo.setoPrice(rs.getInt("o.o_price"));
				oDo.setImg(rs.getString("p.p_img"));

				oList.add(oDo);
			}
			rs.close();
			return oList;

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}

		return null;
	}

	/* 주문 상세페이지 */
	public ArrayList<OrderDO> OrderDetail(int id) {
		// TODO Auto-generated method stub
		conn = DBManager.getConnection();

		ArrayList<OrderDO> oList = new ArrayList<OrderDO>();
		String sql = "SELECT o.o_id, DATE_FORMAT(o.o_date,'%Y-%m-%d') AS d,"
				+ " p.p_name, p.p_unitPrice, sp.s_quantity, p.p_img "
				+ "FROM orders AS o "
				+ "JOIN sold_products AS sp ON o.o_id =sp.s_orderId "
				+ "JOIN products AS p ON sp.s_productId =p.p_id WHERE o.o_id = " + id
				+ ";";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO oDo = new OrderDO();
				oDo.setoId(rs.getInt("o.o_id"));
				oDo.setDate(rs.getString("d"));
				oDo.setpName(rs.getString("p.p_name"));
				oDo.setpPrice(rs.getInt("p.p_unitPrice"));
				oDo.setpQuantity(rs.getInt("sp.s_quantity"));
				oDo.setImg(rs.getString("p.p_img"));

				oList.add(oDo);
			}
			rs.close();
			return oList;

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException se2) {
			}
		}

		return null;
	}

	/////////////////////////////////////// 관리자 페이지
	/////////////////////////////////////// //////////////////////////////////////

	/* 일별 품목당 판매 리스트 */
	public ArrayList<OrderDO> dPerProducts(String oDate, int sno, int eno) {
		ArrayList<OrderDO> dPro = new ArrayList<OrderDO>();
		conn = DBManager.getConnection();

		String sql = "SELECT DATE(o.o_date) AS d, p.p_name, p.p_unitPrice, SUM(s.s_quantity) AS q "
				+ "FROM orders AS o " + "JOIN sold_products AS s ON s.s_orderId=o.o_id "
				+ "JOIN products AS p ON p.p_id= s.s_productId "
				+ "where DATE(o.o_date) = ? AND s.s_code = 2 " + "GROUP BY p.p_id "
				+ "Limit " + sno + "," + eno + ";";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oDate);// pstmt.setDate(1, (java.sql.Date) oDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO odo = new OrderDO();
				odo.setDate(rs.getString("d"));
				odo.setpName(rs.getString("p.p_name"));
				odo.setpPrice(rs.getInt("p.p_unitPrice"));
				odo.setpQuantity(rs.getInt("q"));

				dPro.add(odo);
			}
			return dPro;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dPro;
	}

	/* 일별 품목당 판매 리스트 수 */
	public int dPerProductsCnt(String oDate) {
		conn = DBManager.getConnection();

		int cnt = 0;

		String sql = "SELECT count(*) " + "FROM orders AS o "
				+ "JOIN sold_products AS s ON s.s_orderId=o.o_id "
				+ "JOIN products AS p ON p.p_id= s.s_productId "
				+ "where DATE(o.o_date) = ? AND s.s_code = 2;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oDate);// pstmt.setDate(1, (java.sql.Date) oDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	/* 고객별 구매 리스트 */
	public ArrayList<OrderDO> customerOrders(int cId, int sno, int eno) {
		conn = DBManager.getConnection();
		ArrayList<OrderDO> orderC = new ArrayList<OrderDO>();

		String sql = "SELECT DATE(o.o_date) as d, p.p_name, p.p_unitPrice, s.s_quantity "
				+ "FROM orders AS o " + "JOIN sold_products AS s on o.o_id=s.s_orderId "
				+ "JOIN customers as c on c.c_id=o.o_customerId "
				+ "JOIN products AS p on s.s_productId=p.p_id " + "where c.c_id = " + cId
				+ " AND s.s_code = 2 " + "ORDER BY o.o_date DESC " + "Limit " + sno + ","
				+ eno + ";";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO odo = new OrderDO();
				odo.setDate(rs.getString("d"));
				odo.setpName(rs.getString("p.p_name"));
				odo.setpPrice(rs.getInt("p.p_unitPrice"));
				odo.setpQuantity(rs.getInt("s.s_quantity"));

				orderC.add(odo);
			}
			return orderC;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderC;
	}

	/* 고객별 구매 리스트 수 */
	public int customerOrdersCnt(int cId) {
		conn = DBManager.getConnection();
		int cnt = 0;

		String sql = "SELECT count(*) " + "FROM orders AS o "
				+ "JOIN sold_products AS s on o.o_id=s.s_orderId "
				+ "JOIN customers as c on c.c_id=o.o_customerId "
				+ "JOIN products AS p on s.s_productId=p.p_id " + "where c.c_id = " + cId
				+ " AND s.s_code = 2 " + "ORDER BY o.o_date DESC;";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	/* 일별 고객단위 주문 리스트 */
	public ArrayList<OrderDO> dPerOrders(String oDate, int sno, int eno) {
		ArrayList<OrderDO> dCus = new ArrayList<OrderDO>();
		conn = DBManager.getConnection();

		String sql = "SELECT DATE(o.o_date) AS d, c.c_name, p.p_name, p.p_unitPrice, s.s_quantity "
				+ "FROM orders AS o " + "JOIN sold_products AS s ON o.o_id=s.s_orderId "
				+ "JOIN customers AS c ON c.c_id=o.o_customerId "
				+ "JOIN products AS p ON s.s_productId=p.p_id "
				+ "WHERE DATE(o.o_date)=? AND s.s_code = 2 " + "Limit " + sno + "," + eno
				+ ";";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO odo = new OrderDO();
				odo.setDate(rs.getString("d"));
				odo.setcName(rs.getString("c.c_name"));
				odo.setpName(rs.getString("p.p_name"));
				odo.setpPrice(rs.getInt("p.p_unitPrice"));
				odo.setpQuantity(rs.getInt("s.s_quantity"));

				dCus.add(odo);
			}
			return dCus;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dCus;
	}

	/* 일별 고객단위 주문 리스트 갯수 */
	public int dPerOrdersCnt(String oDate) {
		conn = DBManager.getConnection();
		int cnt = 0;

		String sql = "SELECT count(*) " + "FROM orders AS o "
				+ "JOIN sold_products AS s ON o.o_id=s.s_orderId "
				+ "JOIN customers AS c ON c.c_id=o.o_customerId "
				+ "JOIN products AS p ON s.s_productId=p.p_id "
				+ "WHERE DATE(o.o_date)=? AND s.s_code = 2;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, oDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	/* 테스트 */
	public ArrayList<OrderDO> Test() {
		ArrayList<OrderDO> dPro = new ArrayList<OrderDO>();
		conn = DBManager.getConnection();

		String sql = "SELECT DATE(o.o_date) AS d, p.p_name, p.p_unitPrice, SUM(s.s_quantity) AS q "
				+ "FROM orders AS o " + "JOIN sold_products AS s ON s.s_orderId=o.o_id "
				+ "JOIN products AS p ON p.p_id= s.s_productId " + "where s.s_code = 2 "
				+ "GROUP BY p.p_id ORDER by o.o_date;";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDO odo = new OrderDO();
				odo.setDate(rs.getString("d"));
				odo.setpName(rs.getString("p.p_name"));
				odo.setpPrice(rs.getInt("p.p_unitPrice"));
				odo.setpQuantity(rs.getInt("q"));

				dPro.add(odo);
			}
			return dPro;
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.info("Error Code : {}", e.getErrorCode());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dPro;
	}

}
