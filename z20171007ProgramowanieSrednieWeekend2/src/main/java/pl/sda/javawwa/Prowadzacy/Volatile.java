package pl.mije.sda.java.watki;

/**
 * Ilustacja dzialania volatile
 * Zmien deklaracje zmiennej wspodzielonej, czy program zachowa sie tak samo? 
 * @author michal.jedryszka
 *
 */
public class Volatile {

	private static volatile int wspoldzielonyInt = 0;

	public static void main(String[] args) {
		Thread sluchacz = new Thread(() -> {
			int lokalnaKopia = wspoldzielonyInt;
			while (lokalnaKopia < 5) {
				if (lokalnaKopia != wspoldzielonyInt) {
					System.out.println(String.format("Zmiana wartosci : %s", wspoldzielonyInt));
					lokalnaKopia = wspoldzielonyInt;
				}
			}
		});
		Thread modyfikator = new Thread(() -> {
			int lokalnaKopia = wspoldzielonyInt;
			while (wspoldzielonyInt < 5) {
				System.out.println(String.format("Inkrementuje do: %s", wspoldzielonyInt + 1));
				wspoldzielonyInt = ++ lokalnaKopia;
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		sluchacz.start();
		modyfikator.start();
	}
}
