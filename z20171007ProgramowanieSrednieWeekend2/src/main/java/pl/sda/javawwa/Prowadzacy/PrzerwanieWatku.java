package pl.mije.sda.java.watki;

/**
 * Przyklad ilustrujacy przerwanie watku.
 * 
 * @author mj
 *
 */
public class PrzerwanieWatku {

	public static void main(String[] args) throws InterruptedException {
		DoPrzerwania doPrzerwania = new DoPrzerwania();
		doPrzerwania.start();
		Thread.currentThread().sleep(3000);
		doPrzerwania.interrupt();
	}
}

class DoPrzerwania extends Thread {

	boolean przerwany;

	@Override
	public void run() {
		while (!przerwany) {
			System.out.println("Watek do przerwania pracuje w petli nieskonczonej");
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Dziekuje, dobranoc");
		int i = 1;
	}

	@Override
	public void interrupt() {
		System.out.println("Nastapilo przerwanie");
		przerwany = true;
	}
}