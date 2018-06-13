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
		
		
		double cena = 0;
		int licznik = 0;
		System.out.println("Start programu");
		ReceiptList listaParagonow = new ReceiptList();

		Wallet wallet = Wallet.getInstance();

		

		Menu menu = new Menu();
		  while (true)
		    menu.display();
		}

		

		// odczyt.close();

	}

	
