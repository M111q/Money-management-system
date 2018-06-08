package money2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Receipt implements Cloneable, Subject{
	private Shop shop;
	// private Date dateTime = new Date();
	//                     private Product product;

	private List<Product> productList;
	
	private double total;
	//private List<Observer> observers;
	private List<Observer> observers;
	private double message;
	private boolean changed;
	private final Object MUTEX= new Object();
/*
	public Receipt(Shop shop, List<Product> productList, Observer observer) {
		super();
		this.shop = shop;
		this.productList = productList;
		this.observer = observer;
	}*/
	public Receipt(Shop shop, List<Product> productList) {
		super();
		this.shop = shop;
		this.productList = productList;
		this.observers=new ArrayList<>();
	}
	/* the object that watch on the state of another object are called Observer and the object that is being watched is called Subject.
	 * public Date getDateTime() { return dateTime; } public void setDateTime(Date
	 * dateTime) { this.dateTime = dateTime; }
	 */

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public List<Product> getProductList() {
		return productList;
	}
	
	public void getProducts() {
		for (Product element : productList) {
			System.out.println(element.getProductName() +" - "+ element.getProductDescription() +" -  "+ element.getPrice() + "zl ilosc sztuk: " + element.getAmount() + ", kategoria: " + element.getCategory());//jakis toostring?
		}
	}
	//smiglo
	public double getTotal() {
		total = 0;
		for (Product element : productList) {
		    //System.out.println(element.getPrice());
		    total = total + element.getPrice() * element.getAmount();
		}
		return total;
	}

	public void showReceipt() {
		System.out.println("Paragon ze sklepu " + shop.getShopName());
		this.getProducts();
		//System.out.println(paragon.getProductList().get(0).getProductName());
		System.out.println("suma laczna: " + this.getTotal() + "zl");
		
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException {
		Shop shop = (Shop) this.getShop().clone();
		List<Product> temp = new ArrayList();
		for(Product element : this.getProductList()){
			temp.add(element);
		}
		
    	Receipt paragon = new Receipt(shop, temp);
    	
       
       // Odcinek odcinekC = (Odcinek) this.getC().clone();
        paragon.setShop(shop);
        //trojkat.setB(odcinekB);

        return paragon;
    }
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
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
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(double msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

}
