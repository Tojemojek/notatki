package pl.mije.sda.java.watki;

import java.util.ArrayList;
import java.util.List;

public class Generyki {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		C c = new C();
		
		List<String> listaStringow = new ArrayList<>();
		listaStringow.add("String");
		
		//listaStringow.add(a);

		// Lista typow A
		List<A> listaA = new ArrayList<>();
		listaA.add(a);
		listaA.add(b);
		listaA.add(c);
		
		A aa = listaA.get(0);
		//B ba = listaA.get(0);
		//C ca = listaA.get(0);

		// Lista typow B
		List<B> listaB = new ArrayList<>();
		//listaB.add(a);
		listaB.add(b);
		listaB.add(c);
		
		A ab = listaB.get(0);
		B bb = listaB.get(0);
		//C cb = listaB.get(0);
		

		// Lista typow C
		List<C> listaC = new ArrayList<>();
		//listaC.add(a);
		//listaC.add(b);
		listaC.add(c);
		
		A ac = listaC.get(0);
		B bc = listaC.get(0);
		C cc = listaC.get(0);
		

		List<? super Object> listInitO = new ArrayList<>();
		listInitO.add(new Object());
		listInitO.add(a);
		listInitO.add(b);
		listInitO.add(c);
		
		Object azo = listInitO.get(0);
		
		List<A> listInitA = new ArrayList<>();
		listInitA.add(a);
		List<B> listInitB = new ArrayList<>();
		listInitB.add(b);
		List<C> listInitC = new ArrayList<>();
		listInitC.add(c);

		// Lista typow ktore dziedzicza po A
		List<? extends A> listaExtA;
		listaExtA = new ArrayList<>(listInitB);
		listaExtA = new ArrayList<>(listInitC);
		listaExtA = new ArrayList<>(listInitA); 
		A aExtA = listaExtA.get(0);
		//B bExtA = listaExtA.get(0);
		//C cExtA = listaExtA.get(0);
		//Najbardziej szczego³owy interfejs ktory jest wspolny dla elemntow tej listy stanowi typ A

		
		// Lista typow ktore dziedzicza po B
		List<? extends B> listaExtB;
		//listaExtB = new ArrayList<>(listInitA);
		listaExtB = new ArrayList<>(listInitC);
		listaExtB = new ArrayList<>(listInitB);  
		//Z tej listy mozemy POBRAC obietky ktore dzidzicza po B
		A aExtB = listaExtB.get(0);
		B bExtB = listaExtB.get(0);
		//C cExtB = listaExtB.get(0);
		//Najbardziej szczego³owy interfejs ktory jest wspolny dla elemntow tej listy stanowi typ B
		
		// Lista typow ktore dziedzicza po C
		List<? extends C> listaExtC;
		//listaExtC = new ArrayList<>(listInitA);
		//listaExtC = new ArrayList<>(listInitB);
		listaExtC = new ArrayList<>(listInitC); //W konstruktorze wymiennie z listInitC 
		//Z tej listy mozemy POBRAC obietky ktore dzidzicza po C
		A aExtC = listaExtC.get(0);
		B bExtC = listaExtC.get(0);
		C cExtC = listaExtC.get(0);
		//Najbardziej szczego³owy interfejs ktory jest wspolny dla elemntow tej listy stanowi typ C
		
		//listaExtC.add(a);
		//listaExtC.add(b);
		//listaExtC.add(c);

		// Lista typow ktorych nadtypem jest typ C
		//Mozemy wlozyc elementy ktore sa bardziej szczegolowe niz C
		List<? super C> listaSupC;
		listaSupC = new ArrayList<>(listInitA);
		listaSupC = new ArrayList<>(listInitB);
		listaSupC = new ArrayList<>(listInitC);
		//listaSupC.add(a);
		//listaSupC.add(b);
		listaSupC.add(c);

		//A aSupC = listaSupC.get(0);
		//B bSupC = listaSupC.get(0);
		//C cSupC = listaSupC.get(0);
		
		// Lista typow ktorych nadtypem jest typ B
		//Mozemy wlozyc elementy ktore sa bardziej szczegolowe niz B
		List<? super B> listaSupB;
		listaSupB = new ArrayList<>(listInitA);
		listaSupB = new ArrayList<>(listInitB);
		listaSupB = new ArrayList<>(listInitC);
		//listaSupB.add(a);
		listaSupB.add(b);
		listaSupB.add(c);
		
		// Lista typow ktorych nadtypem jest typ A
		//Mozemy wlozyc elementy ktore sa bardziej szczegolowe niz A
		List<? super A> listaSupA;
		listaSupA = new ArrayList<>(listInitA);
		listaSupA = new ArrayList<>(listInitB);
		listaSupA = new ArrayList<>(listInitC);
		
		//listaSupA.add(new Object());		
		listaSupA.add(a);
		listaSupA.add(b);
		listaSupA.add(c);

		Object oSupA = listaSupC.get(0);
		
		listaSupA = new ArrayList<>(listInitO);
		listaSupB = new ArrayList<>(listInitO);
		listaSupC = new ArrayList<>(listInitO);
		
		//listaExtA = new ArrayList<>(listInitO);
		//listaExtB = new ArrayList<>(listInitO);
		//listaExtC = new ArrayList<>(listInitO);
		
		listaSupA = listaA; 
		listaSupB = listaA; 
		listaSupC = listaA;
		
		//listaSupA = listaB; 
		listaSupB = listaB; 
		listaSupC = listaB;
		
		
		//listaSupA = listaC; 
		//listaSupB = listaC; 
		listaSupC = listaC; 
		
		
		listaExtA = listaA; 
		//listaExtB = listaA; 
		//listaExtC = listaA;
		
		listaExtA = listaB; 
		listaExtB = listaB; 
		//listaExtC = listaB;

		listaExtA = listaC; 
		listaExtB = listaC; 
		listaExtC = listaC;
	}
}

class A {

}

class B extends A {

}

class C extends B {

}