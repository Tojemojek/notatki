package pl.mije.sda.java.watki;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Ilustracja dzialania scheduled executor
 * 
 * @author michal.jedryszka
 *
 */
public class ScheduledExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		System.out.println("Zlecam wykonanie callable, za dwie sekundy...");
		ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(new Callable<String>() {
			public String call() throws Exception {
				System.out.println("Wykonuje callable");
				return "Called!";
			}
		}, 2, TimeUnit.SECONDS);

		System.out.println("Czy future zakonczone? :" + scheduledFuture.isDone());
		System.out.println("Zwrocona wartosc to: " + scheduledFuture.get());

		System.out.println("Zlecam wykonanie runnable, za dwie sekundy...");
		scheduledExecutorService.schedule(() -> {
			System.out.println("Wykonuje runnable");
		}, 2, TimeUnit.SECONDS);

		System.out.println("Zlecam cykliczne wykonanie runnable, za dwie sekundy...");
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			System.out.println("Wykonuje runnable cykliczne");
		}, 2, 1, TimeUnit.SECONDS);

		Thread.sleep(5000);
		System.out.println("Koniec w main");
		scheduledExecutorService.shutdown();
	}
}
