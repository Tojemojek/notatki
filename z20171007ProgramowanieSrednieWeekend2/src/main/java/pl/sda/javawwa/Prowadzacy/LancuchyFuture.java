package pl.mije.sda.java.watki;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Then Combine, then compose
 * @author michal.jedryszka
 *
 */
public class LancuchyFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Polaczenie dwoch future, najpierw C potem thenCompose
		CompletableFuture<String> futureC = new CompletableFuture<>();
		CompletableFuture<String> thenCompose = futureC.thenCompose((wartoscC) -> {
			System.out.println("Wewnatrz thenCompose: " + wartoscC);
			return CompletableFuture.supplyAsync(() -> {
				System.out.println("Wewnatrz thenCompose, operacja asynchroniczna");
				return wartoscC.toUpperCase();
			});
		});
		System.out.println("Utworzylem future c, wysylam wynik c");
		futureC.complete("c");
		System.out.println("future C gotowe?: " + futureC.isDone());
		System.out.println("thenCompose gotowe?: " +thenCompose.isDone());
		System.out.println("Wynik thenCompose: " + thenCompose.get());

		// Zrobmy cos jak przyjda po nas...
		CompletableFuture<String> futureF = new CompletableFuture<>();
		CompletableFuture<String> futureG = new CompletableFuture<>();
		CompletableFuture<Void> acceptBoth = futureF.thenAcceptBoth(futureG, (wynikF, wynikG) -> {
			System.out.println("Wynik F: " + wynikF);
			System.out.println("Wynik G: " + wynikG);
		});
		System.out.println("Czy F gotowe? : " + futureF.isDone());
		System.out.println("Czy G gotowe? : " + futureG.isDone());
		futureF.complete("f");
		System.out.println("Czy acceptBoth gotowe? : " + acceptBoth.isDone());		
		futureG.complete("g");
		System.out.println("Czy acceptBoth gotowe? : " + acceptBoth.isDone());

		//Then combine, czy ma znaczenie kolejnosc dostarczenia i h?
		CompletableFuture<String> futureH = new CompletableFuture<>();
		CompletableFuture<String> futureI = new CompletableFuture<>();
		CompletableFuture<String> thenCombine = futureH.thenCombine(futureI, (h, i) ->{
			return h + i;
		});
		System.out.println("Czy H gotowe? : " + futureH.isDone());
		System.out.println("Czy I gotowe? : " + futureI.isDone());
		System.out.println("Czy thenCombine gotowe? : " + thenCombine.isDone());
		futureH.complete("h");
		System.out.println("Czy H gotowe? : " + futureH.isDone());
		System.out.println("Czy I gotowe? : " + futureI.isDone());
		System.out.println("Czy thenCombine gotowe? : " + thenCombine.isDone());
		futureI.complete("i");
		System.out.println("Czy H gotowe? : " + futureH.isDone());
		System.out.println("Czy I gotowe? : " + futureI.isDone());
		System.out.println("Czy thenCombine gotowe? : " + thenCombine.isDone());
		System.out.println("Wynik combine : " + thenCombine.get());
	}
}
