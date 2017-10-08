package pl.mije.sda.java.watki;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Przyklad na uruchomienie watku poprzez executor.
 * 
 * @author mj
 *
 */
public class PrzykladowyExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Future<?> rezultat = executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("Wykonuje sie anonimowe runnable");
			}
		});
		rezultat.get();
		System.out.println("Czy gotowe?: " + rezultat.isDone());

		executorService.submit(() -> System.out.println("Wykonuje sie lambda z executora"));
		Thread.sleep(2000);

		for (int i = 0; i < 10; i++) {
			int j = i;
			executorService.submit(() -> {
				System.out.println("Wykonuje sie lambda z executora: " + j + " " +Thread.currentThread().getId());
			});
		}
		executorService.shutdown();
	}
}
