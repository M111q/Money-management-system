package money2;

public class SingletonTest {

	public static void main(String[] args) {
		Thread test1 = new Thread(new Runnable() {
	        public void run() {
	        	Wallet object = Wallet.getInstance();
	        }
	    });

	    Thread test2 = new Thread(new Runnable() {
	        public void run() {
	        	Wallet object = Wallet.getInstance();
	        }
	    });

	    Thread test3 = new Thread(new Runnable() {
	        public void run() {
	        	Wallet object = Wallet.getInstance();
	        }
	    });


	    test1.start();
	    test2.start();
	    test3.start();
		Wallet probaNr1 = Wallet.getInstance();
		Wallet probaNr2 = Wallet.getInstance();
		Wallet probaNr3 = Wallet.getInstance();
		   if (probaNr1 == probaNr2 && probaNr2 == probaNr3) {
	            System.out.println("Te same instancje:");
	            System.out.println("Proba 1: " + probaNr1.hashCode() + " Proba 2: " + probaNr2.hashCode() + " Proba 3: " + probaNr3.hashCode());
	        } else {
	            System.out.println("Rozne instancje");
	        }
	}

}
