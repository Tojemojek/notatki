package pl.sda.javawwa.KodProwadzacego;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Przyklad uzycia refleksji do listowania pol, metod
 * Wywolanie metody, ustawienie pola
 * @author mj
 *
 */
public class Metadane {

	public static void ustawWartosc(Osoba osoba, String nazwaPola, String wartosc)
			throws IllegalArgumentException, IllegalAccessException {
		for (Field pole : osoba.getClass().getDeclaredFields()) {
			if (pole.getName().equals(nazwaPola)) {
				pole.setAccessible(true);
				pole.set(osoba, wartosc);
				//pole.get(obj);
			}
		}
	}

	public static void wywolajMetode(Osoba osoba, String nazwaMetody, String wartosc)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (Method metoda : osoba.getClass().getDeclaredMethods()) {
			if (metoda.getName().equals(nazwaMetody)) {
				//metoda.setAccessible(true);
				metoda.invoke(osoba, wartosc);
			}
		}
	}

	public static void infoKlasy() {

		Class<Osoba> klasa = Osoba.class;

		for (Field pole : klasa.getDeclaredFields()) {
			System.out.println("Znalazlem pole: " + pole.getName());
			System.out.println("Czy pole jest dostepne: " + pole.isAccessible());
		}

		for (Method metoda : klasa.getDeclaredMethods()) {
			System.out.println("Znalazlem metode: " + metoda.getName());
			System.out.println("Czy metoda jest dostepna: " + metoda.getModifiers());
		}

	}

	public static void infoObiektu(Osoba osoba) {
		System.out.println("Imie: " + osoba.getImie());
		System.out.println("Nazwisko: " + osoba.getNazwisko());
	}

	public static void main(String[] args) throws Exception {
//		infoKlasy();
		Osoba osoba = new Osoba();
		osoba.setImie("Jan");
		osoba.setNazwisko("Kowalski");
//		infoObiektu(osoba);
//		ustawWartosc(osoba, "imie", "Janek");
		//osoba.imie = "Janek";
//		infoObiektu(osoba);
//		ustawWartosc(osoba, "imie", "Janek");
		wywolajMetode(osoba, "setNazwisko", "Kowalsky");
		wywolajMetode(osoba, "metodaPrywatna", "paramter");
		infoObiektu(osoba);
	}
}
