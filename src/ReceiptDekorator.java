package money2;

public abstract class ReceiptDekorator implements ReceiptInterfaceDekorator {
	 protected ReceiptInterfaceDekorator dekorowanyParagon; // dekorowany paragon
	 private int nip;

	    public ReceiptDekorator(ReceiptInterfaceDekorator dekorowanyParagon) {
	        this.dekorowanyParagon = dekorowanyParagon;
	    }
	    private int getNip() {
			return nip;
	    }
}