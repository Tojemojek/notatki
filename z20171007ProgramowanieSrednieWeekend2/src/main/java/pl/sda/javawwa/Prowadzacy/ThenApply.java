package pl.mije.sda.java.watki;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Then apply, then accept
 * Konczy sie glowne future, na wyniku wykonajmy jakas operacje
 * @author michal.jedryszka
 *
 */
public class ThenApply {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Obrobka wyniku koncowego
		// Ostatni element w lancuchu
		CompletableFuture<String> futureB = new CompletableFuture<>();
		CompletableFuture<Void> konoweFuture = futureB.thenAccept((wynikB) -> {
			System.out.println("Zakonczone futureB z wynikiem: " + wynikB);
		});
		System.out.println("Czy gotowe? : " + konoweFuture.isDone());
		futureB.complete("Wysy³am wynik B");
		System.out.println("Czy gotowe? : " + konoweFuture.isDone());

	}
}
