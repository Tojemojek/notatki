package pl.mije.sda.java.watki;

/**
 * Przyklad na uzycie metody sleep
 * @author mj
 *
 */
public class UspienieWatku {
	
	public static void main(String[] args) throws InterruptedException {
		Thread nowyWatek = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Jestem nowym watkiem");	
		});
		
		nowyWatek.start();
		Thread.sleep(1000);
		
		System.out.println("Jestem w watku main, usypiam na sekunde");
		
		Thread.currentThread().sleep(1000);

		System.out.println("... jeszcze sekunde ...");

		Thread.sleep(1000);
		
		System.out.println("Jestem w watku main, budze sie");
	}
}
