package money2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
	static Scanner in = new Scanner(System.in);
	static int option;
	static boolean quit = false;
	double cena = 0;
	static int licznik = 0;
	static Wallet wallet;
	static ReceiptList listaParagonow;
	
	public Menu() {
		super();
		wallet = Wallet.getInstance();
		listaParagonow = new ReceiptList();
	}
	public void display() throws CloneNotSupportedException {
		do {
			System.out.println(
					"Wybierz: 1. Dodaj nowy paragon, 2.  Wyswietl stan portfela, 3. Pokaz paragony, 4. Dodaj nowy paragon na podstawie zapisanego, 5. Edycja paragonu, 0. Wyjscie");
			option = Integer.parseInt(in.next());
			in.nextLine();
			switch (option) {
			case 1:// nowy paragon
				dodaj();
				break;
			case 2:// stan portfela
				System.out.println(wallet);
				break;
			case 3:// pokaz paragony
				listaParagonow.getReceiptsFromList();
				break;
			case 4:// klonowanie
				addCloneReceipt();
				break;
			case 5:// edycja
				editReceipt();
				break;
			case 0:
				this.exit();
				quit = true;
				break;
			default:
				System.out.println("Zle polecenie");
			}

		} while (!quit);

	}
	public Receipt chooseReceipt(String word) {
		System.out.println("Wybierz paragon do " + word + " wpisujac jego numer");
		listaParagonow.getReceiptsFromList();// wysiwtla liste paragonow
		int wybranyNr = Integer.parseInt(in.next());
		Receipt chReceipt = listaParagonow.getOneReceiptFromList(wybranyNr);
		return chReceipt;
	}
	
	private void editReceipt() {
		submenuReceiptActions(chooseReceipt("edycji"));
	}
	private void addCloneReceipt() throws CloneNotSupportedException {
		Receipt paragonClone = (Receipt) chooseReceipt("skopiowania").clone();
		licznik = licznik + 1;
		paragonClone.setId(licznik);
		listaParagonow.addReceiptToList(paragonClone);
		wallet.setSubject(paragonClone);
		submenuReceiptActions(paragonClone);
	}
	private static void dodaj() {
		System.out.println("Podaj nazwe sklepu");
		String nazwaSklepu = in.nextLine();
		Shop sklep = new Shop(nazwaSklepu);
		List<Product> productList = new ArrayList();
		licznik = licznik + 1;
		System.out.println("Wybierz: 1. Dodaj nowy zwykly paragon, 2.  Dodaj nowa fakture");
		submenuReceiptType(sklep,productList);
	}
	
	private static void submenuReceiptType(Shop sklep, List<Product> productList) {//mogloby przyjmowac jako argument metode do wywolania
		option = Integer.parseInt(in.next());
		in.nextLine();
		if (option == 1) {
			dodajParagon(sklep,productList);
		}else if(option ==2) {
			dodajFaktura(sklep,productList);
		}else {
			System.out.println("Zle polecenie");
			submenuReceiptType(sklep,productList);
		}
	}
	private static void dodajFaktura(Shop sklep, List<Product> productList) {
		System.out.println("Podaj NIP");
		int nip = Integer.parseInt(in.next());
		in.nextLine();
		//stworzyc paragon i potem go udekorowac
		Receipt paragonDoDekorowania = new Receipt(licznik, sklep, productList);
		paragonDoDekorowania.register(wallet);
		wallet.setSubject(paragonDoDekorowania);
		submenuReceiptActions(paragonDoDekorowania);
		ReceiptInterfaceDekorator dekorowanyParagon = new ReceiptFaktura(paragonDoDekorowania, nip);
		//dodac do listy paragonow/faktur
		//problem z obserwator 
		System.out.println(dekorowanyParagon.pobierzOpis());
		//System.out.println(dekorowanyParagon);
		
		
	}
	private static void dodajParagon(Shop sklep, List<Product> productList) {
		Receipt paragon = new Receipt(licznik, sklep, productList);
		paragon.register(wallet);
		wallet.setSubject(paragon);
		listaParagonow.addReceiptToList(paragon);
		submenuReceiptActions(paragon);
		
		
	}
	private static void submenuReceiptActions(Receipt paragon) {
		do {
			System.out.println("Wybierz: 1. Dodaj produkt do paragonu, 2. Wyswietl podsumowanie, 3. Zakoncz edycje paragonu");		
			option = Integer.parseInt(in.next());
			in.nextLine();
			if (option == 1) {
				addProductToReceipt(paragon);
			}else if(option ==2) {
				paragon.showReceipt();
			}else if(option ==3) {
				paragon.postMessage(paragon.getTotal());
				break;
			}else {
				System.out.println("Zle polecenie");
				submenuReceiptActions(paragon);
			}
		}while (true);
	}
	private static void addProductToReceipt(Receipt paragon) {
		System.out.println("Dodawanie produktu");
		System.out.println("podaj cene produktu");

		double cena = in.nextDouble();//////////////////////////////////////
		in.nextLine();
		System.out.println("podaj nazwe produktu");
		String nazwa = in.nextLine();
		System.out.println("podaj opis");
		String opis = in.nextLine();
		System.out.println("podaj kategorie");
		String kategoria = in.nextLine();
		ProductCategory category = new ProductCategory(kategoria);
		System.out.println("Podaj ilosc sztuk");
		Integer ilosc = in.nextInt();
		System.out.println("");

		Product mojProdukt = new Product(nazwa, opis, cena, ilosc, category);
		paragon.addProduct(mojProdukt);
	}
	private void exit() {
        System.out.println("Wyjscie...");
        System.exit(1); 
}
}
