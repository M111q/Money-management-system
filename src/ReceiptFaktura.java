package money2;

import java.util.ArrayList;
import java.util.List;

public class ReceiptFaktura extends ReceiptDekorator implements Subject{
	private int nip;
	private List<Observer> observers;
	private double message;
	private boolean changed;
	private final Object MUTEX= new Object();
	public ReceiptFaktura(ReceiptInterfaceDekorator dekorowanyParagon, int nip) {
		super(dekorowanyParagon);
		this.nip = nip;
		this.observers=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String pobierzOpis() {
		// TODO Auto-generated method stub
		return dekorowanyParagon.pobierzOpis() + ", Dodano NIP " + getNip();
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	@Override
	public void postMessage(double msg) {
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public void unregister(Observer obj) {
		// TODO Auto-generated method stub
		
	}

}
