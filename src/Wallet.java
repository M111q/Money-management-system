package money2;

public class Wallet {
	private double money;

	public Wallet(double money) {
		super();
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	public void spentMoney(double money) {
		this.money = this.money - money;
	}

}
