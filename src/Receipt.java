package money2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Receipt implements Cloneable{
	private Shop shop;
	// private Date dateTime = new Date();
	//                     private Product product;

	private List<Product> productList;
	private double total;

	public Receipt(Shop shop, List<Product> productList) {
		super();
		this.shop = shop;
		this.productList = productList;
	}

	/*
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
	
}
