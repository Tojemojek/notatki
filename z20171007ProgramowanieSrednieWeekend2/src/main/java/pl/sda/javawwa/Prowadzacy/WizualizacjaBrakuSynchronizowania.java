package pl.mije.sda.java.watki;

/**
 * Zaobserwuj rozniece w dzialaniu gdy nie blok synchronized zostanie wylaczno/zakomentowany
 * @author michal.jedryszka
 *
 */
public class WizualizacjaBrakuSynchronizowania {

	private static int wartoscAkcji = 0;
	
	private static Object monitor = "";

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				//synchronized (monitor) {
					long id = Thread.currentThread().getId();
					System.out.println(id + " Czytam wartosc: " + wartoscAkcji);
					System.out.println(id + " Uaktualniam wartosc o wyniki notowan z internetu");
					// symulujemy wywolanie do serwisu zewnetrzengo
					try {
						Thread.sleep(new java.util.Random().nextInt(1000));
					} catch (Exception e) {
						e.printStackTrace();
					}
					int akutalizacja = new java.util.Random().nextInt(100);
					System.out.println(id + " Pobrana aktualizacja: " + akutalizacja);
					wartoscAkcji += akutalizacja;
					System.out.println(id + " Nowa wartosc: " + wartoscAkcji);
				//}
			}).start();
		}
	}
}
