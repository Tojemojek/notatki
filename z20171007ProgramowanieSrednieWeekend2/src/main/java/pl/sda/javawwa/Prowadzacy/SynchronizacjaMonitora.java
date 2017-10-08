package pl.mije.sda.java.watki;

/**
 * Przyklad wymuszenia kolejnosci dzialan za posrednictem slowa synchronized.
 * Jak zmieni sie wyjscie gdy zakomentujemy blok synchronized.
 * 
 * @author mj
 *
 */
public class SynchronizacjaMonitora {

	private final static String monitor = "";

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			final int j = i;
			new Thread(() -> {
				synchronized (monitor) {
					System.out.println("Startuje watek numer: " + j);
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
