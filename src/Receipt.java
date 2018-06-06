package money2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Receipt {
	private String shopName;
	// private Date dateTime = new Date();
	//                     private Product product;

	private List<Product> productList;
	private double total;

	public Receipt(String shopName, List<Product> productList) {
		super();
		this.shopName = shopName;
		this.productList = productList;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/*
	 * public Date getDateTime() { return dateTime; } public void setDateTime(Date
	 * dateTime) { this.dateTime = dateTime; }
	 */

	public void addProduct(Product product) {
		productList.add(product);
	}

	public List<Product> getProductList() {
		return productList;
	}
	
	public void getProducts() {
		for (Product element : productList) {
			System.out.println(element.getProductName() +" - "+ element.getProductDescription() +" -  "+ element.getPrice() + "zl ilosc sztuk: " + element.getAmount());
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
}
