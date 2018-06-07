package money2;

public class Shop {
	private String shopName;
	private String address;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Shop(String shopName, String address) {
		super();
		this.shopName = shopName;
		this.address = address;
	}
	
}
