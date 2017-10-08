package pl.mije.sda.java.watki;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * Tworzenie obiektow completable future
 * 
 * @author michal.jedryszka
 *
 */
public class TworzenieFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> cFuture = new CompletableFuture<>();
		
		System.out.println("Czy completable ukonczone?: " + cFuture.isDone());
		cFuture.complete("42");
		System.out.println("Czy completable ukonczone?: " + cFuture.isDone());
		System.out.println("Jaka jest odpowiedz na najzwazniejsze pytanie we wszechswiecie?: " + cFuture.get());

		System.out.println("Id watku glownego: " + Thread.currentThread().getId());
		CompletableFuture<String> zSupplieremAnonimowym = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				return "jakis string";
			}});
		
		CompletableFuture<String> zSupplierem = CompletableFuture.supplyAsync(() -> {
			System.out.println("Wywolanie suppliera");
			System.out.println("Id watku suppliera: " + Thread.currentThread().getId());
			return "Wartosc z suppliera";
		}); //Wersja z exekutorem
		
		CompletableFuture<Void> zRunnable = CompletableFuture.runAsync(() -> {
			System.out.println("Lece z runnable");	
			System.out.println("Id watku runnable: " + Thread.currentThread().getId());
		}); //Wersja z exekutorem
		
		//Poczekajmy na wyniki
		System.out.println("zSupplierem.get(): " + zSupplierem.get());
		System.out.println("zRunnable.get(): " + zRunnable.get());
	}
}
