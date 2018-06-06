package money2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		System.out.println("Tworzenie nowego paragonu");
		Receipt paragon = new Receipt("Biedra");
		System.out.println("Podaj nazwe produktu");
		paragon.addProduct("buleczki", "swieze buleczki pachnace jak ...");
		paragon.addProduct("piwko", "harnasik ...");
		paragon.addProduct("chlebek", "w razie jak bulek za malo ...");
		paragon.getProductList();
		//System.out.println(paragon.get);
		 * 
		 
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				//new ActionFrame();
				new MyFrame();
			}
		});
	}
}*/
		
		
		System.out.println("Start programu");
		System.out.println("Utworzenie produktow");
		Product produkt1 = new Product("Mars", "batonik czekoladowy", 1.50);
		Product produkt2 = new Product("Bulka", "buleczka pszenna", 0.50);
		Product produkt3 = new Product("Woda", "woda gazowana smerfetka", 2.50);

		
		Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od u¿ytkownika

		System.out.println("Podaj nazwe sklepu");
		String nazwaSklepu = odczyt.nextLine();
		System.out.println("podaj nazwe produktu");
		String nazwa = odczyt.nextLine();
		System.out.println("podaj opis");
		String opis = odczyt.nextLine();
		System.out.println("podaj cene");
		double cena = odczyt.nextDouble();
		
		Product mojProdukt = new Product(nazwa, opis, cena);
		
		List<Product> productList = new ArrayList();
		productList.add(produkt1);
		productList.add(produkt2);
		productList.add(produkt2);
		productList.add(produkt3);
		productList.add(mojProdukt);
		
		
		Receipt paragon = new Receipt(nazwaSklepu, productList);
		
		Product piwko = new Product("Piwko", "specjal schlodzony", 2.50);
		
		paragon.addProduct(piwko);
		
		System.out.println("Wyswietlanie");
		System.out.println(paragon.getShopName());
		//System.out.println(paragon.);
		//Object retrievedObject = productList.get(2);
		String blabla = productList.get(2).getProductName(); 
		//System.out.println(retrievedObject);
		System.out.println(blabla);
		System.out.println(productList.get(4).getProductName());
		//System.out.println(productList.get(5).getProductName());

		System.out.println("suma laczna: " + paragon.getTotal() + "zl");
		//brac od uzytkownika i zappisywyac potem liczyc total i potem pomyslec o wzorcach...
	}

}
