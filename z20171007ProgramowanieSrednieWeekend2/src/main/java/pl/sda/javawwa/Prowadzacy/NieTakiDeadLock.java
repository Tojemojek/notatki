package pl.mije.sda.java.watki;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Uzycie Lock pozwala uniknac deadlocka Obecna implementacja powoduje deadlocka
 * Zamien wywolania zasobA/B.lock() na zasobA/B.tryLock(long timeout, TimeUnit unit) taki tryLockzwraca true
 * jezeli operacja sie powiodla, jezeli po timeoucie nie uzyskamy locka zwraca false
 * 
 * @author michal.jedryszka
 *
 */
public class NieTakiDeadLock {

	public static void main(String[] args) {
		Lock zasobA = new ReentrantLock();
		Lock zasobB = new ReentrantLock();

		Thread watek1 = new Thread(() -> {
			zasobA.lock();
			try {
				System.out.println("Watek 1 blokuje A");
				try {
					Thread.currentThread().sleep(1000);
					zasobB.lock();
					try {
						System.out.println("Watek 1 blokuje B");
						Thread.currentThread().sleep(1000);
					} finally {
						zasobB.unlock();
					}
				} catch (Exception e) {
				}
			} finally {
				zasobA.unlock();
			}
		});

		Thread watek2 = new Thread(() -> {
			zasobB.lock();
			try {
				System.out.println("Watek 2 blokuje B");
				try {
					Thread.currentThread().sleep(1000);
					zasobA.lock();
					try {
						System.out.println("Watek 2 blokuje A");
						Thread.currentThread().sleep(1000);
					} finally {
						zasobA.unlock();
					}
				} catch (Exception e) {
				}
			} finally {
				zasobB.unlock();
			}
		});
		//watek1.start();
		//watek2.start();
		
		Thread watek3 = new Thread(() -> {
			try {
				if (zasobB.tryLock(1, TimeUnit.SECONDS)) {
					System.out.println("Watek 3 blokuje B");
						Thread.currentThread().sleep(1000);
						if (zasobA.tryLock(1, TimeUnit.SECONDS)) {
							System.out.println("Watek 3 blokuje A");
							Thread.currentThread().sleep(1000);
							zasobA.unlock();
						}else{
							System.out.println("Nie udalo sie zablokowac zasobu A w watku 3");
						}
					zasobB.unlock();
				}else{
					System.out.println("Nie udalo sie zablokowac zasobu B w watku 3");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Thread watek4 = new Thread(() -> {
			try {
				if (zasobA.tryLock(1, TimeUnit.SECONDS)) {
					System.out.println("Watek 4 blokuje A");
					Thread.currentThread().sleep(1000);
					if (zasobB.tryLock(1, TimeUnit.SECONDS)) {
						System.out.println("Watek 4 blokuje B");
						Thread.currentThread().sleep(1000);
						zasobB.unlock();
					}else{
						System.out.println("Nie udalo sie zablokowac zasobu B w watku 4");
					}
					zasobA.unlock();
				}else{
					System.out.println("Nie udalo sie zablokowac zasobu A w watku 4");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		watek3.start();
		watek4.start();		
	}
}
