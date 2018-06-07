package money2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
//todo walidacja
//ul menu

public class Main {

	public static void main(String[] args) {
		Scanner odczyt = new Scanner(System.in);
		int option;
		double cena = 0;
		System.out.println("Start programu");
		ReceiptList listaParagonow = new ReceiptList();
		
		//List<Product> productList = new ArrayList();
		
		Wallet wallet = new Wallet(100);
		//ProductCategory category = new ProductCategory("jedzenie");
			
		
		
		while(true) {
			System.out.println("Wybierz: 1. Dodaj nowy paragon, 2.  Wyswietl stan portfela, 3. Pokaz paragony 4. Dodaj nowy paragon na podstawie zapisanego");
			option= Integer.parseInt(odczyt.next());
			odczyt.nextLine();
			if(option == 1) {
//				System.out.println("Utworzenie nowego paragonu");
				
				System.out.println("Podaj nazwe sklepu");
				String nazwaSklepu = odczyt.nextLine();
				List<Product> productList = new ArrayList();
				Receipt paragon = new Receipt(nazwaSklepu, productList);
				listaParagonow.addReceiptToList(paragon);
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				while(true) {
					System.out.println("Wybierz: 1. Dodaj produkt do paragonu, 2. Wyswietl podsumowanie, 3. Zakoncz dodawanie nowego paragonu");
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
						System.out.println("podaj kategorie");
						String kategoria = odczyt.nextLine();
						////////
						ProductCategory category = new ProductCategory(kategoria);
						System.out.println("Podaj ilosc sztuk");
						Integer ilosc = odczyt.nextInt();
						System.out.println("");
						
						Product mojProdukt = new Product(nazwa, opis, cena, ilosc, category);
						paragon.addProduct(mojProdukt);
						//productList.add(mojProdukt);
						
					}
					else if(option == 2) {
						paragon.showReceipt();
						//wallet.spentMoney(2);
					}else if(option == 3)
						break;
				}
				
				/////////////////////////////////////////////////////////////////////
				
				
				
			}else if(option == 2) {
				//wallet.spentMoney(paragon.getTotal());//poprawic
				System.out.println("kasa w portfelu wynosi: "+ wallet.getMoney());
			}else if(option == 3) {//wyswietlanie paragonow
				listaParagonow.getReceiptsFromList();
			}else if(option == 4) {//
				while(true) {
					System.out.println("Wybierz paragon do skopiowania wpisujac jego numer");//mozliwosc anulowania? jesli puste komunikat
					listaParagonow.getReceiptsFromList();//wysiwtla liste
					option= Integer.parseInt(odczyt.next());
					if(option == 1) {
						
					}
				}
				
				
			}
			else {
				break;
			}
		
		
	}
	odczyt.close();

}
}