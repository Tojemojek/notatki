package pl.mije.sda.java.watki;

/**
 * Przyklady na tworzenie watkow.
 * @author mj
 *
 */
public class PrzykladowyWatek {
	
	public static void main(String[] args) {
		
		Thread poWatku = new PoWatku();
		poWatku.start();
		
		Thread zRunnable = new Thread(new ZRunnable());
		zRunnable.start();
		
		Thread anonimowy = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Jestem watkiem z anonimowym runnalbe");
			}});
		anonimowy.start();
		
		Thread zLambda = new Thread(()-> System.out.println("Jestem watkiem z lambdy"));
		zLambda.start();
	}
}

class PoWatku extends Thread{
	public void run(){
		System.out.println("Jestem watkiem dziedziczacym po klasie Thread");
	}
}

class ZRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("Jestem watkiem implementujacym Runnable");
	}
}