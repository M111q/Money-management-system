package money2;

import java.util.ArrayList;
import java.util.List;
//obiazenie konta
public class Wallet implements Observer {
	//private static Wallet wallet = new Wallet(100);
	private static Wallet instance;
	private double money;
	private double expenses; //wydatki
	/////////private Subject topic;//kilka subjec powinno byc?
	private List<Subject> subjects;
	private double realMoney;
	//private final Object MUTEX= new Object();
	//private List<Subject> subjects;
	private Wallet(double money) {
		super();
		this.money = money;
		this.subjects = new ArrayList<>();//przy tworzenie portfela tworzy lsite obserwowanych tematow
	}
	public static synchronized Wallet getInstance( ) {
		if(instance == null){
	        synchronized (Wallet.class) {
	            if(instance == null){
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
	//public void spentMoney(double money) {
	//	this.money = this.money - money;
	//}
	
	@Override
	public void update() {
		expenses = 0;
		for (Subject sub : subjects) {//petla przelatuje po wszystkich zapisanych paragonach i odczytuje total
			
			double msg = (double) sub.getUpdate(this);
			if(msg == 0){
				System.out.println("Brak zmian w portfelu");
			}else {
		//this.spentMoney(msg);
				this.updateExpenses(msg);
				System.out.println("Uaktualniono portfel o: "+msg + "zl");
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
		/////this.topic=sub;//u mnie musi byc lista
	}


/*
	@Override
	public void update() {
		double wydatek =  topic.getUpdate(this);
		if(wydatek == 0){
			System.out.println("==Wallet kasa bez zmian==");
		}else
		System.out.println("==Aktualizacja portfela==");
		this.spentMoney(wydatek);
	}

	@Override// jesli nie zawiera danego paragonu to dodaje do ;isty obserowawanych paragonow
	public void setSubject(Subject sub) {
		this.topic=sub;
		if(sub == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!subjects.contains(sub)) subjects.add(sub);
		}
	}*/

}
