package shopping_mall;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopMain {
	static ShopDAO shopDAO = new ShopDAO();
	static ShopDTO shopDTO = new ShopDTO();
	static Scanner sc = new Scanner(System.in);
	static ArrayList<ShopDTO> bList = new ArrayList<ShopDTO>();

	public static void main(String[] args) {
		System.out.println("Select \n1.Seller 2.Customer 3.End");
		System.out.print(">> ");
		int key = sc.nextInt();
		switch (key) {
		case 1:
			sellerMain();
			break;

		case 2:
			login();
			break;

		case 3:
			System.out.println("END Program");
			break;

		default:
			System.out.println("You've entered something wrong.");
			main(null);
			break;
		}
	}

	private static void sellerMain() {
		// TODO Auto-generated method stub
		System.out.println("                                   * * * menu * * *");
		System.out.println(
				"1.Update Order Price 2.Revenue by Date List 3.Sales by customer 4.Sale by date 5.End");
		System.out.print(">> ");
		int key = sc.nextInt();

		switch (key) {
		case 1:
			updatePrice();
			break;

		case 2:
			RevenueList();
			break;

		case 3:
			SaleCusList();
			break;

		case 4:
			SaleList();
			break;

		case 5:
			System.out.println("END Seller Menu");
			main(null);
			break;

		default:
			System.out.println("You've entered something wrong.");
			sellerMain();
			break;
		}

	}

	private static void updatePrice() {
		// TODO Auto-generated method stub
		int min = shopDAO.getMinOID();
		int max = shopDAO.getMaxOID();
		for (int i = min; i <= max; i++) {
			shopDAO.check(i);
		}
		System.out.println("fin");
	}

	private static void SaleCusList() {
		// TODO Auto-generated method stub
		System.out.println("   ID     Name       Price");
		List<ShopDTO> sdLidt = shopDAO.saleByCustomer();
		for (ShopDTO shopDTO : sdLidt) {
			System.out
					.println(String.format(" %,6d %-4s %,-8d", shopDTO.getCustomID(),
							shopDTO.getName(), shopDTO.getAccountByMember()));
		}
		System.out.println();
		sellerMain();
	}

	private static void SaleList() {
		// TODO Auto-generated method stub
		System.out.print("Search Year >> ");
		int y = sc.nextInt();
		System.out.print("Month >> ");
		int m = sc.nextInt();
		System.out.printf("%6s %9s %11s %11s %9s%n", "ID", "Name", "UnitPrice",
				"Quantity", "Account");
		List<ShopDTO> sdLidt = shopDAO.salesByDateMon(y, m);
		for (ShopDTO shopDTO : sdLidt) {
			System.out.println(String.format("%,8d %11s %,10d %3d %,10d",
					shopDTO.getProductID(), shopDTO.getName(),
					shopDTO.getUnitPrice(), shopDTO.getQuantity(),
					shopDTO.getAccount()));
		}
		System.out.println();
		sellerMain();
	}

	private static void RevenueList() {
		// TODO Auto-generated method stub
		System.out.println("    Date         Amount");
		List<ShopDTO> sdLidt = shopDAO.saleByDate();
		for (ShopDTO shopDTO : sdLidt) {
			System.out.println(String.format(" %-14s %,7d ", shopDTO.getDate(),
					shopDTO.getSalesAccount()));
		}
		System.out.println();
		sellerMain();
	}

	public static void login() {
		// TODO Auto-generated method stub
		System.out.print("ID(Please enter numbers only.) >> ");
		int in_id = sc.nextInt();
		System.out.print("Password >> ");
		String in_pwd = sc.next();
		int new_id = shopDAO.login(in_id, in_pwd);

		if (new_id == 0) {
			login();
		} else {
			CustomMain(new_id);
		}

	}

	private static void CustomMain(int id) {
		// TODO Auto-generated method stub
		System.out.println("                         * * * menu * * *");
		System.out.println(
				"1.Products List 2.Order 3.Order List 4.Order Details 5.End");
		System.out.print(">> ");
		int key = sc.nextInt();

		switch (key) {
		case 1:
			productList(id);
			break;

		case 2:
			order(id);
			break;

		case 3:
			orderList(id);
			break;

		case 4:
			orderDetails(id);
			break;

		case 5:
			System.out.println("END Customer Menu");
			main(null);
			break;

		default:
			System.out.println("You've entered something wrong.");
			CustomMain(id);
			break;
		}

	}

	private static void orderList(int id) {
		// TODO Auto-generated method stub
		System.out.println("Order List");
		System.out.println("   ID        Date          Name            Account");
		List<ShopDTO> oList = shopDAO.orderList(id);

		for (ShopDTO shopDTO : oList) {
			if (shopDTO.getCnt() != 0) {
				System.out.printf("%,d | %s | %s 외 %d건 | %,d %n",
						shopDTO.getOrderID(), shopDTO.getDate(), shopDTO.getName(),
						shopDTO.getCnt(), shopDTO.getAccount());

			} else {
				System.out.printf("%,d | %s | %s | %,d %n", shopDTO.getOrderID(),
						shopDTO.getDate(), shopDTO.getName(), shopDTO.getAccount());

			}
		}
		System.out.println();
		CustomMain(id);

	}

	private static void orderDetails(int id) {
		// TODO Auto-generated method stub
		int allAc = 0;
		System.out.print("Order ID >> ");
		int oID = sc.nextInt();
		int chk = shopDAO.checkOrderID(id, oID);
		if (chk == 0) {
			System.out.println("Only your own order can be view.");
			CustomMain(id);
		} else {
			List<ShopDTO> oDetail = shopDAO.orderDetail(oID);
			for (ShopDTO shopDTO : oDetail) {
				System.out.printf("%s  %s  %d  %,d  %,d%n", shopDTO.getDate(),
						shopDTO.getName(), shopDTO.getQuantity(),
						shopDTO.getUnitPrice(), shopDTO.getAccount());
				allAc += shopDTO.getAccount();
			}
			System.out.println("Total : " + allAc);
			CustomMain(id);
		}

	}

	private static void order(int id) {
		// TODO Auto-generated method stub
		int allAc = 0;
		System.out.print("Products ID >> ");
		int pID = sc.nextInt();
		if (pID == 0) {
			for (ShopDTO shopDTO : bList) {
				System.out.printf("%d %s %d %d %d%n", shopDTO.getProductID(),
						shopDTO.getName(), shopDTO.getQuantity(),
						shopDTO.getUnitPrice(), shopDTO.getAccount());
				allAc += shopDTO.getAccount();
			}
			System.out.println("Total : " + allAc);
			System.out.print("Save Cart (Y/N)? ");
			String ans = sc.next();
			sc.nextLine();
			if (ans.equals("Y") || ans.equals("y")) {
				shopDAO.orderMake(id);
//				int max = shopDAO.getMaxOID();
				for (ShopDTO shopDTO : bList) {
					shopDAO.inOrder(shopDTO);
				}
				int orid = shopDAO.getOrderID(id);
				shopDAO.check(orid);
				bList.clear();
			} else {
				bList.clear();
			}
			System.out.println();
			CustomMain(id);
		} else {
			System.out.print("Quantity >> ");
			int quantity = sc.nextInt();

			shopDTO = new ShopDTO(pID, quantity);

			ShopDTO sDTO = shopDAO.basket(shopDTO);

			bList.add(sDTO);

			order(id);
		}

	}

	private static void productList(int id) {
		// TODO Auto-generated method stub
		System.out.printf("%6s %9s %11s%n", "ID", "Name", "UnitPrice");
		List<ShopDTO> sdLidt = shopDAO.productList();
		for (ShopDTO shopDTO : sdLidt) {
			System.out
					.println(String.format("%,8d %8s %,10d", shopDTO.getProductID(),
							shopDTO.getName(), shopDTO.getUnitPrice()));
		}
		System.out.println();
		CustomMain(id);
	}

}
