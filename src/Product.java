package money2;

public class Product {
	private String productName;
	private String productDescription;
	private double price;
	private Integer amount;
	private ProductCategory category;

	public Product(String productName, String productDescription, double price, Integer amount, ProductCategory category) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}
	
	public Product(String productName, String productDescription, double price, Integer amount) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.amount = amount;
		//defaultowa kategoria ustawic
	}

	public Product(String productName, String productDescription, double price) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.amount = 1;
	}

	public String getProductName() {
		return productName;
	}

	public void updateProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void updatePrice(double price) {
		this.price = price;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void updateProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getAmount() {
		return amount;
	}

	public void updateAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category.getCategoryName();
	}

	public void setCategory(String categoryName) {
		this.category = new ProductCategory(categoryName);
	}

}
