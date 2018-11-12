package exercise;

public class Account20 {
	private String ano;
	private String owner;
	private int balance;

	public Account20(String ano, int balance, String owner) {
		// TODO Auto-generated constructor stub
		this.ano = ano;
		this.balance = balance;
		this.owner = owner;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
