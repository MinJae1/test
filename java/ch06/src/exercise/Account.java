package exercise;

public class Account {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (balance < 0 || balance > 1000000) {
			balance = this.balance;
			this.balance = balance;
		} else {
			this.balance = balance;

		}
	}
}
