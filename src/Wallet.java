package money2;

import java.util.ArrayList;
import java.util.List;

public class Wallet implements Observer {
	private static Wallet instance;
	private double money;
	private double expenses; // wydatki
	private List<Subject> subjects;
	private double realMoney;

	private Wallet(double money) {
		super();
		this.money = money;
		this.subjects = new ArrayList<>();
	}

	public static synchronized Wallet getInstance() {
		if (instance == null) {
			synchronized (Wallet.class) {
				if (instance == null) {
					instance = new Wallet(100);
				}
			}
		}
		return instance;
	}

	public double getRealMoney() {
		update();
		realMoney = money - expenses;
		return realMoney;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public void update() {
		expenses = 0;
		for (Subject sub : subjects) {

			double msg = (double) sub.getUpdate(this);
			if (msg == 0) {
				//System.out.println("Brak zmian w portfelu");
			} else {

				this.updateExpenses(msg);
				//System.out.println("Uaktualniono portfel o: " + msg + "zl");
			}
		}
	}

	public double getExpenses() {
		return expenses;
	}

	public void updateExpenses(double expenses) {
		this.expenses = this.expenses + expenses;
	}

	@Override
	public void setSubject(Subject sub) {
		this.subjects.add(sub);
	}

	@Override
	public String toString() {
		return "kasa w portfelu wynosi: " + getRealMoney() + "zl";
	}
	
	
}
