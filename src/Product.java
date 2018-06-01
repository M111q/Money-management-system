
public class Product {
	private String nameProduct;
	private Float priceProduct;
	private Integer quantityProduct;
	
	public Product(String name, Float price, Integer quantity) {
		this.nameProduct = name;
		this.priceProduct = price;
		this.quantityProduct = quantity;
	}
	
	public String getProductName() {
		return nameProduct;
	}
	
	public Float getProductPrice() {
		return priceProduct;
	}
	
	public Integer getProductQuantity() {
		return quantityProduct;
	}
}