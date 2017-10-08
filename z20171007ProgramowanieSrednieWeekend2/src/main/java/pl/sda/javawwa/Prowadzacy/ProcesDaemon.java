package pl.mije.sda.java.watki;

/**
 * W zaleznosci od flagi metody setDaemon sprawdz jak zachowuje sie program.
 * @author mj
 *
 */
public class ProcesDaemon {

	public static void main(String[] args) {

		Thread nonDaemon = new Thread(() -> {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Watek pracuje");
		});
		nonDaemon.setDaemon(false);
		nonDaemon.start();
		System.out.println("Koniec watku main");
	}
}
