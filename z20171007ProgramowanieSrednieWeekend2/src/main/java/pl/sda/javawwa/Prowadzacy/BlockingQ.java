package pl.mije.sda.java.watki;
/**
 * Problem producent - consumer zrealizowany na BlockingQueue
 */
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQ {

	public static void main(String[] args) {
		KanalSprzedazyBQ produkt = new KanalSprzedazyBQ();
		(new Thread(new ProducentBQ(produkt))).start();
		(new Thread(new KonsumentBQ(produkt))).start();
	}
}

class ProducentBQ implements Runnable {

	private KanalSprzedazyBQ kanal;

	ProducentBQ(KanalSprzedazyBQ kanal) {
		this.kanal = kanal;
	}

	@Override
	public void run() {
		String produkty[] = { "Kredki", "Piorniki", "Dlugopisy", "Flamastry" };
		Random random = new Random();

		for (int i = 0; i < produkty.length; i++) {
			System.out.format("Wystawiam produkt: %s%n", produkty[i]);
			kanal.wystaw(produkty[i]);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
		kanal.wystaw("KONIEC");
	}
}

class KonsumentBQ implements Runnable {

	private KanalSprzedazyBQ kanal;

	KonsumentBQ(KanalSprzedazyBQ kanal) {
		this.kanal = kanal;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (String nazwa = kanal.kup(); !nazwa.equals("KONIEC"); nazwa = kanal.kup()) {
			System.out.format("Kupiono produkt: %s%n", nazwa);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}
}

class KanalSprzedazyBQ {

	private BlockingQueue<String> produkty = new ArrayBlockingQueue<String>(1);

	public void wystaw(String nazwa) {
		produkty.add(nazwa);
	}

	public String kup() {
		try {
			return produkty.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}