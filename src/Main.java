package money2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//todo walidacja
//ulepsz menu
//edycja paragonu usuwanie/zmiana produktu
//jak edytuje ale nie dodam nic nowego nie powinno aktualizowac
//dodac indeksy do paragon1 paragon2...
public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner odczyt = new Scanner(System.in);
		int option;
		double cena = 0;
		int licznik = 0;
		System.out.println("Start programu");
		ReceiptList listaParagonow = new ReceiptList();

		// List<Product> productList = new ArrayList();


	        
		   
		   
		Wallet wallet = Wallet.getInstance();
		// ProductCategory category = new ProductCategory("jedzenie");

        
     
        
		while (true) {
			System.out.println(
					"Wybierz: 1. Dodaj nowy paragon, 2.  Wyswietl stan portfela, 3. Pokaz paragony, 4. Dodaj nowy paragon na podstawie zapisanego, 5. Edycja paragonu");
			option = Integer.parseInt(odczyt.next());
			odczyt.nextLine();
			if (option == 1) {
				// System.out.println("Utworzenie nowego paragonu");
				System.out.println("Podaj nazwe sklepu");
				String nazwaSklepu = odczyt.nextLine();
				Shop sklep = new Shop(nazwaSklepu);
				List<Product> productList = new ArrayList();
				licznik = licznik + 1;
				//Receipt paragon = new Receipt(sklep, productList, wallet);
				Receipt paragon = new Receipt(licznik, sklep, productList);
				
					System.out.println(
							"Wybierz: 1. Dodaj nowy zwykly paragon, 2.  Dodaj nowa fakture");
					option = Integer.parseInt(odczyt.next());
					odczyt.nextLine();
					switch(option) {
					case 2: System.out.println("Podaj NIP");
						int nip = Integer.parseInt(odczyt.next());
						odczyt.nextLine();

					//Receipt paragon = new Receipt(sklep, productList, wallet);
					//Receipt paragon = new Receipt(licznik, sklep, productList);
					
						ReceiptInterfaceDekorator dekorowanyParagon = new ReceiptFaktura(new Receipt(sklep, productList), nip);
					//dekorowanyParagon
						System.out.println(dekorowanyParagon.pobierzOpis());
						dekorowanyParagon.register(wallet);
						wallet.setSubject(dekorowanyParagon);
						//stworzyc liste faktur?
						//listaParagonow.addReceiptToList(dekorowanyParagon);
						//break;
						////////zmienic listaParagonow.addReceiptToList(dekorowanyParagon);
						//paragon = (Receipt) dekorowanyParagon;////////////////
					case 1: paragon.register(wallet);
					wallet.setSubject(paragon);
					//paragon.register(wallet);
					listaParagonow.addReceiptToList(paragon);
					break;
					/*
					if (option == 2) {
						
						System.out.println("Podaj NIP");
						int nip = Integer.parseInt(odczyt.next());
						odczyt.nextLine();
	
						//Receipt paragon = new Receipt(sklep, productList, wallet);
						//Receipt paragon = new Receipt(licznik, sklep, productList);
						
						ReceiptInterfaceDekorator dekorowanyParagon = new ReceiptFaktura(new Receipt(sklep, productList), nip);
						//dekorowanyParagon
						System.out.println(dekorowanyParagon.pobierzOpis());
						paragon = (Receipt) dekorowanyParagon;////////////////
						
					}else {
						
				paragon.register(wallet);
				wallet.setSubject(paragon);
				//paragon.register(wallet);
				listaParagonow.addReceiptToList(paragon);
				*/
				
					}
				
				
				
				//////////////////////////////////////////////////////////
				
				 
				 
				
				//paragon.postMessage();
				//wallet.update();
			//za kazdym razem jak tworze paragon musze go dodac do listy obserowanych subjectow
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				while (true) {
					System.out.println(
							"Wybierz: 1. Dodaj produkt do paragonu, 2. Wyswietl podsumowanie, 3. Zakoncz dodawanie nowego paragonu");
					option = Integer.parseInt(odczyt.next());

					if (option == 1) {
						System.out.println("Dodawanie produktu");
						System.out.println("podaj cene produktu");
						// boolean czyPoprawne = false;
						// while(czyPoprawne != true) {
						// try {
						cena = odczyt.nextDouble();

						// } catch (InputMismatchException e) {
						// System.out.println("Podaj poprawna cene np: 1,50");
						// }
						// }
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
						// productList.add(mojProdukt);

					} else if (option == 2) {
						paragon.showReceipt();
						// wallet.spentMoney(2);
					} else if (option == 3) {
						//paragon.postMessage();
						//System.out.println("napisz wiadomosc");
						//odczyt.nextLine();
						//String test = odczyt.nextLine();
						//paragon.postMessage(test);
						paragon.postMessage(paragon.getTotal());
						break;//(paragon.getTotal());
					}
				}

				/////////////////////////////////////////////////////////////////////

			} else if (option == 2) {
				// wallet.spentMoney(paragon.getTotal());//poprawic
				System.out.println("kasa w portfelu wynosi: " + wallet.getRealMoney());
			} else if (option == 3) {// wyswietlanie paragonow
				listaParagonow.getReceiptsFromList();
			} else if (option == 4) {// shallow copy

				System.out.println("Wybierz paragon do skopiowania wpisujac jego numer");// mozliwosc anulowania? jesli
																							// puste komunikat
				listaParagonow.getReceiptsFromList();// wysiwtla liste
				int wybranyNr = Integer.parseInt(odczyt.next());
				Receipt paragonClone = (Receipt) listaParagonow.getOneReceiptFromList(wybranyNr).clone();
				licznik = licznik + 1;
				paragonClone.setId(licznik);
				listaParagonow.addReceiptToList(paragonClone);
				wallet.setSubject(paragonClone);
				// paragonClone.showReceipt();

				// if(option == 1) {
				// }
				// System.out.println("wybrano " +
				// listaParagonow.getOneReceiptFromList(wybranyNr));
				while (true) {
					System.out.println(
							"Wybierz: 1. Dodaj produkt do skopiowanego paragonu, 2. Wyswietl podsumowanie, 3. Zakoncz dodawanie nowego paragonu");
					option = Integer.parseInt(odczyt.next());
					if (option == 1) {
						System.out.println("Dodawanie produktu");
						System.out.println("podaj cene produktu");
						// boolean czyPoprawne = false;
						// while(czyPoprawne != true) {
						// try {
						cena = odczyt.nextDouble();

						// } catch (InputMismatchException e) {
						// System.out.println("Podaj poprawna cene np: 1,50");
						// }
						// }
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
						paragonClone.addProduct(mojProdukt);
						// productList.add(mojProdukt);

					} else if (option == 2) {
						paragonClone.showReceipt();
						// wallet.spentMoney(2);
					} else if (option == 3) {
						paragonClone.postMessage(paragonClone.getTotal());
						break;
					}
				}
			} else if (option == 5) {
				System.out.println("Wybierz paragon do edycji wpisujac jego numer");// mozliwosc anulowania? jesli
																							// puste komunikat
				listaParagonow.getReceiptsFromList();// wysiwtla liste paragonow
				int wybranyNr = Integer.parseInt(odczyt.next());
				Receipt paragonToEdit = listaParagonow.getOneReceiptFromList(wybranyNr);
				
				while (true) {
					System.out.println(
							"Edycja Wybierz: 1. Dodaj produkt do wybranego paragonu, 2. Wyswietl podsumowanie, 3. Zakoncz edycje paragonu");
					option = Integer.parseInt(odczyt.next());
					if (option == 1) {
						System.out.println("Dodawanie produktu");
						System.out.println("podaj cene produktu");
						// boolean czyPoprawne = false;
						// while(czyPoprawne != true) {
						// try {
						cena = odczyt.nextDouble();

						// } catch (InputMismatchException e) {
						// System.out.println("Podaj poprawna cene np: 1,50");
						// }
						// }
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
						paragonToEdit.addProduct(mojProdukt);
						// productList.add(mojProdukt);

					} else if (option == 2) {
						paragonToEdit.showReceipt();//wychodzi z petli nie wiem czemu
						// wallet.spentMoney(2);
					} else if (option == 3) {
						paragonToEdit.postMessage(paragonToEdit.getTotal());
						break;
					}
				}
				
				
				
				
				
				
				
				
				//Receipt paragonClone = (Receipt) listaParagonow.getOneReceiptFromList(wybranyNr).clone();
				//listaParagonow.addReceiptToList(paragonClone);
			}

			else {
				break;
			}

		}
		odczyt.close();

		
		
	}
}