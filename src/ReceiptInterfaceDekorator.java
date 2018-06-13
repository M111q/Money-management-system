package money2;

public interface ReceiptInterfaceDekorator extends Subject {
	public String pobierzOpis(); // zwraca opis

	public void register(Observer obj);

	public Object getUpdate(Observer obj);

	public void postMessage(double msg);

	public void notifyObservers();
	
	public Shop getShop();
}
