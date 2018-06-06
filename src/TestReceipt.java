package money2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TestReceipt {

	@Test
	public void testNameShop() {
		String nazwaSklepu = "TestShop";
		List<Product> productList = new ArrayList();
		Receipt paragon = new Receipt(nazwaSklepu, productList);
		Assert.assertEquals("TestShop", paragon.getShopName());
	}

	@Test
	public void testAddProducts() {
		String nazwaSklepu = "TestShop";
		List<Product> productList = new ArrayList();
		Receipt testparagon = new Receipt(nazwaSklepu, productList);
		
		Product product1 = new Product("test product1", "test product description", 100,5);
		Product product2 = new Product("test product2", "test product description", 50,5);
		Product product3 = new Product("test product3", "test product description", 25);
		Product product4 = new Product("test product4", "test product description", 25);
		Product product5 = new Product("test product5", "test product description", 100);
		
		testparagon.addProduct(product1);
		testparagon.addProduct(product2);
		testparagon.addProduct(product3);
		testparagon.addProduct(product4);
		testparagon.addProduct(product5);
		Assert.assertEquals(301, testparagon.getTotal(),0);
	}

}
