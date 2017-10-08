package pl.mije.sda.java.watki;

/**
 * Metoda wykonuje sie w kontekscie obiektu
 * 
 * @author michal.jedryszka
 *
 */
public class MetodaSynchronizowana {

	private String name;
	
	public MetodaSynchronizowana(String name) {
		this.name = name;
	}

	public synchronized void metoda() {
		System.out.println("Wykonuje siê w kontekscie obiektu o nazwie " + name + " przez watek o id "
				+ Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public void nieSynchronizowana() {
		System.out.println("Niesynchronizowana wykonuje siê w kontekscie obiektu o nazwie " + name
				+ " przez watek o id " + Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {

		MetodaSynchronizowana metodaSynchronizowana = new MetodaSynchronizowana("metodaSynchronizowana");

		for (int i = 0; i < 10; i++) {
			//new Thread(() -> metodaSynchronizowana.metoda()).start();
		}

		for (int i = 0; i < 10; i++) {
			new Thread(() -> metodaSynchronizowana.nieSynchronizowana()).start();
		}

	}
}
