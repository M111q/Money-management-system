import java.util.Date;

public class Receipt {
	private Shop receiptShop;
	private Float total; //suma do zaplaty za rachunek
	private Date date;
	private Product product;
	private ReceiptOwner owner; //kto kupowal
	
	public Receipt(Shop shop) {
		this.receiptShop = shop;
	}
	
}