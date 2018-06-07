package money2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner odczyt = new Scanner(System.in);
		int option;
		double cena = 0;
		System.out.println("Start programu");
		System.out.println("Utworzenie nowego paragonu");
		
		System.out.println("Podaj nazwe sklepu");
		String nazwaSklepu = odczyt.nextLine();
		
		List<Product> productList = new ArrayList();
		Receipt paragon = new Receipt(nazwaSklepu, productList);
		Wallet wallet = new Wallet(100);
		ProductCategory category = new ProductCategory("jedzenie");
			
		
		
		while(true) {
			System.out.println("Wybierz: 1. Dodaj produkt do paragonu, 2. Wyswietl podsumowanie, 3. Wyswietl stan portfela");
			option= Integer.parseInt(odczyt.next());
			
			if(option == 1) {
				System.out.println("Dodawanie produktu");
				System.out.println("podaj cene produktu");
				//boolean czyPoprawne = false;
				//while(czyPoprawne != true) {
				// try {
			           cena = odczyt.nextDouble();
			            
			     //   } catch (InputMismatchException e) {
			   //         System.out.println("Podaj poprawna cene np: 1,50");
			   //     }
				//}
				odczyt.nextLine();
				System.out.println("podaj nazwe produktu");
				String nazwa = odczyt.nextLine();
				System.out.println("podaj opis");
				String opis = odczyt.nextLine();
				System.out.println("Podaj ilosc sztuk");
				Integer ilosc = odczyt.nextInt();
				System.out.println("");
				
				Product mojProdukt = new Product(nazwa, opis, cena, ilosc, category);//narazie na sztywno kategoria
				paragon.addProduct(mojProdukt);
				//productList.add(mojProdukt);
				
			}
			else if(option == 2) {
				System.out.println("Paragon ze sklepu " + paragon.getShopName());
				paragon.getProducts();
				//System.out.println(paragon.getProductList().get(0).getProductName());
				System.out.println("suma laczna: " + paragon.getTotal() + "zl");
				
				
				//wallet.spentMoney(2);
			}
			else if(option == 3) {
				wallet.spentMoney(paragon.getTotal());//poprawic
				System.out.println("kasa w portfelu wynosi: "+ wallet.getMoney());
			}
			else {
				break;
			}
		}
		odczyt.close();
	}

}
