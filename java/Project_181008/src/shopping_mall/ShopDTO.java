package shopping_mall;

public class ShopDTO {
	private int orderPrice;
	private int salesAccount;
	private int accountByMember;
	private int customID;
	private int productID;
	private int orderID;
	private int unitPrice;
	private int quantity;
	private int account;
	private int cnt;
	private String date;
	private String name;

	public ShopDTO() {
		// TODO Auto-generated constructor stub
	}

	public ShopDTO(int salesAccount, String date) {
		this.salesAccount = salesAccount;
		this.date = date;
	}

	public ShopDTO(int accountByMember, int customID, String name) {
		this.accountByMember = accountByMember;
		this.name = name;
		this.customID = customID;
	}

	public ShopDTO(int productID, int unitPrice, int quantity, int account,
			String name) {
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.account = account;
		this.name = name;
	}

	public ShopDTO(int productID, String name, int unitPrice) {
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.name = name;
	}

	public ShopDTO(int productID, int quantity) {
		this.productID = productID;
		this.quantity = quantity;
	}

	public ShopDTO(int orderID, String date, String name, int account) {
		this.orderID = orderID;
		this.account = account;
		this.date = date;
		this.name = name;
	}

	public ShopDTO(String date, String name, int quantity, int unitPrice,
			int account) {
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.account = account;
		this.date = date;
		this.name = name;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getSalesAccount() {
		return salesAccount;
	}

	public void setSalesAccount(int salesAccount) {
		this.salesAccount = salesAccount;
	}

	public int getAccountByMember() {
		return accountByMember;
	}

	public void setAccountByMember(int accountByMember) {
		this.accountByMember = accountByMember;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCustomID() {
		return customID;
	}

	public void setCustomID(int customID) {
		this.customID = customID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
