package pl.sda.javawwa.Prowadzacy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Przykladowe uzycie fork/join pool
 * @author michal.jedryszka
 *
 */
public class ForkJoin {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		forkJoinPool.invoke(new Akcja());
		Integer rezultat = forkJoinPool.invoke(new Zadanie(10));
		System.out.println("Zwrocono rezultat: " + rezultat);
		forkJoinPool.shutdown();
	}

}

class Akcja extends RecursiveAction {
	@Override
	protected void compute() {
		System.out.println("Wykonuje akcje glowna");

		List<RecursiveAction> dzieciaki = new ArrayList<RecursiveAction>();

		dzieciaki.add(new RecursiveAction() {
			@Override
			protected void compute() {
				System.out.println("Wykonuje sie pod-akcja 1");
			}
		});
		dzieciaki.add(new RecursiveAction() {
			@Override
			protected void compute() {
				System.out.println("Wykonuje sie pod-akcja 2");
			}
		});

		for (RecursiveAction dziecko : dzieciaki) {
			dziecko.fork();
		}
	}
}

class Zadanie extends RecursiveTask<Integer> {
	
	private Integer wartosc;
	
	public Zadanie(Integer wartosc){
		this.wartosc = wartosc;
	}
			
	@Override
	protected Integer compute() {
		System.out.println("Wykonuje zadanie glowne");

		List<RecursiveTask<Integer>> dzieciaki = new ArrayList<RecursiveTask<Integer>>();

		dzieciaki.add(new RecursiveTask<Integer>() {
			@Override
			protected Integer compute() {
				System.out.println("Wykonuje sie pod-zadanie 1");
				return wartosc;
			}
		});
		dzieciaki.add(new RecursiveTask<Integer>() {
			@Override
			protected Integer compute() {
				System.out.println("Wykonuje sie pod-zadanie 2");
				return wartosc;
			}
		});

		Integer wynikKoncowy = 0;
		for (RecursiveTask<Integer> dziecko : dzieciaki) {
			ForkJoinTask<Integer> wynikDziecka = dziecko.fork();
			wynikKoncowy += wynikDziecka.join();
		}
		return wynikKoncowy;
	}
}