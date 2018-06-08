package money2;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {//moze singleton?
	//private Receipt paragon;
	private List<Receipt> listaParagonow;
	//public ReceiptList(List<Receipt> listaParagonow) {
	//	super();
	//	this.listaParagonow = listaParagonow;
	//}
	
	
	public void addReceiptToList(Receipt paragon) {
		listaParagonow.add(paragon);
		
	}
	public ReceiptList() {
		super();
		listaParagonow = new ArrayList();
	}
	public List<Receipt> getListaParagonow() {
		return listaParagonow;
	}
	public void getReceiptsFromList() {//dodac numeracje wyswietlanych par i jesli null
		//int licznik = 0;
		for (Receipt element : listaParagonow) {
			System.out.println("###########Start#############");
			System.out.println("Paragon nr: " + element.getId());
			element.showReceipt();//jakis toostring?
			//licznik = licznik + 1;
			System.out.println();
		}
	}
	public Receipt getOneReceiptFromList(int numer){
		return listaParagonow.get(numer-1);
	}
	
}
