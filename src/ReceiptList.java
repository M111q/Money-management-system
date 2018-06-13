package money2;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {

	private List<Receipt> listaParagonow;

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

	public void getReceiptsFromList() {
		for (Receipt element : listaParagonow) {
			System.out.println("###########Start#############");
			System.out.println("Paragon nr: " + element.getId());
			element.showReceipt();
			System.out.println();
		}
	}

	public Receipt getOneReceiptFromList(int numer) {
		return listaParagonow.get(numer - 1);
	}

}
