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
		for (Receipt element : listaParagonow) {
			element.showReceipt();//jakis toostring?
		}
	}
	
}
