package pl.mije.sda.java.watki;

/**
 * Ilustracja wyrzycenia runtime exception w watku
 * 
 * @author michal.jedryszka
 *
 */
public class WyjatekWWatku {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			System.out.println("Watek t");
			throw new RuntimeException("Wyjatek z watku t");
		});
		t.start();
		t.join();
		
		System.out.println("Koniec main");
	}
}
