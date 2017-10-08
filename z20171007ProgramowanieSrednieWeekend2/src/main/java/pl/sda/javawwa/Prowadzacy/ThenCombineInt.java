package pl.mije.sda.java.watki;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenCombineInt {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> futureH = new CompletableFuture<>();
		CompletableFuture<Integer> futureI = new CompletableFuture<>();
		
		CompletableFuture<Integer> wynik = futureH.thenCombine(futureI, (h, i) -> {
			return i + h;
		});
		futureH.complete(10);
		futureI.complete(23);
		System.out.println(wynik.get());
	}

}
