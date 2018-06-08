package money2;

import java.util.List;

public class Wallet implements Observer {
	private double money;
	private Subject topic;//kilka subjec powinno byc?
	//private final Object MUTEX= new Object();
	//private List<Subject> subjects;
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
	
	@Override
	public void update() {
		double msg = (double) topic.getUpdate(this);
		if(msg == 0){
			System.out.println("Brak zmian w portfelu");
		}else
		this.spentMoney(msg);
		System.out.println("Uaktualniono portfel o: "+msg + "zl");
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;//u mnie musi byc lista
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
