package pl.sda.javawwa.Prowadzacy;

import java.util.Random;

/**
 * Ilustracja uzycia funkcji wait i notify Zakladamy ze w kanale moze byc
 * umieszczony tylko jeden produkt
 * 
 * @author mj
 *
 */
public class Sprzedaz {

	public static void main(String[] args) {
		KanalSprzedazy kanal = new KanalSprzedazy();
		String[] produkty1 = { "Kredki", "Piorniki", "Dlugopisy", "Flamastry" };
		String[] produkty2 = { "Jablka", "Gruszki", "Ziemniaki", "Kalarepa" };
		(new Thread(new Producent(kanal, produkty1))).start();
		(new Thread(new Producent(kanal, produkty2))).start();
		(new Thread(new Konsument(kanal))).start();
	}
}

class Producent implements Runnable {

	private KanalSprzedazy kanal;
	private String produkty[];
	Producent(KanalSprzedazy kanal, String produkty[]) {
		this.kanal = kanal;
		this.produkty = produkty;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (int i = 0; i < produkty.length; i++) {
			kanal.wystaw(produkty[i]);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
		kanal.wystaw("KONIEC");
	}
}

class Konsument implements Runnable {

	private volatile KanalSprzedazy kanal;

	Konsument(KanalSprzedazy kanal) {
		this.kanal = kanal;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (String nazwa = kanal.kup(); !nazwa.equals("KONIEC"); nazwa = kanal.kup()) {
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}
}

class KanalSprzedazy {

	private String produkt;

	public synchronized void wystaw(String nazwa) {
		while (produkt != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		produkt = nazwa;
		System.out.format("Wystawiam produkt: %s%n", nazwa);
		notifyAll();
	}

	public synchronized String kup() {
//		synchronized (this) {
			while (produkt == null) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String doSprzedania = produkt;
			produkt = null;
			System.out.format("Kupiono produkt: %s%n", doSprzedania);
			notifyAll();
			return doSprzedania;
//		}
	}
}