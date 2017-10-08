package pl.mije.sda.java.watki;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * W czytelni mamy w do czynienia z dwoma grupami uzytkownikow: czytelnikami,
 * ktorych kilku moze przebywac jednoczesnie w czytelni odczytuj¹c dane oraz
 * pisarzami, ktorzy zapisuja dane, ale musza przebywac w tym celu pojedynczo w
 * czytelni. Zaproponuj rozwiazanie ktore dla losowego ciagu osob
 * (pisarzy/czytelnikow) zapewni jak najbardziej efektywne uzycie czytelni.
 * 
 * @author mj
 *
 */
public class Czytelnia {

	private List<UzytkownikCzytelni> kolejka = new ArrayList<UzytkownikCzytelni>();

	private Set<UzytkownikCzytelni> sala = new HashSet<>();

	private int rozmiarSali = 5;

	public void oblsuz(List<UzytkownikCzytelni> uzytkownicy) {
		kolejka.addAll(uzytkownicy);

		boolean czyWszyscySkonczyli = false;
		while (!czyWszyscySkonczyli) {
			if (!kolejka.isEmpty()) {
				UzytkownikCzytelni pierwszy = kolejka.get(0);
				HashSet<UzytkownikCzytelni> kopiaSali = null;
				synchronized (sala) {
					kopiaSali = new HashSet<UzytkownikCzytelni>(sala);
				}
				if (pierwszy.czyMozeszWejsc(kopiaSali, rozmiarSali)) {
					sala.add(pierwszy);
					new Thread(pierwszy).start();
					kolejka.remove(0);
				}

			}
			Iterator<UzytkownikCzytelni> iterator = sala.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().czySkonczylem())
					iterator.remove();
			}
			if (sala.isEmpty() && kolejka.isEmpty()) {
				czyWszyscySkonczyli = true;
			}
		}
	}
}

interface UzytkownikCzytelni extends Runnable {
	public boolean czySkonczylem();

	public boolean czyMozeszWejsc(Set<UzytkownikCzytelni> sala, int rozmiarSali);
}

class Pisarz implements UzytkownikCzytelni {

	private String nazwa;

	private int czasPisania;

	private boolean skonczylem;

	Pisarz(String nazwa) {
		this.nazwa = nazwa;
		czasPisania = (1 + new Random().nextInt(10)) * 1000;
	}

	@Override
	public void run() {
		System.out.println("Zaczynam pisac " + nazwa);
		try {
			Thread.sleep(czasPisania);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Skonczylem pisac " + nazwa);
		skonczylem = true;
	}

	public boolean czySkonczylem() {
		return skonczylem;
	}

	@Override
	public synchronized boolean czyMozeszWejsc(Set<UzytkownikCzytelni> sala, int rozmiarSali) {
		return sala.isEmpty() || (sala.size() == 1 && sala.contains(this));
	}
}

class Czytelnik implements UzytkownikCzytelni {

	private String nazwa;

	private int czasCzytania;

	private boolean skonczylem;

	Czytelnik(String nazwa) {
		this.nazwa = nazwa;
		czasCzytania = (1 + new Random().nextInt(10)) * 1000;
	}

	@Override
	public void run() {
		System.out.println("Zaczynam czytac " + nazwa);
		try {
			Thread.sleep(czasCzytania);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Skonczylem czytac " + nazwa);
		skonczylem = true;
	}

	public boolean czySkonczylem() {
		return skonczylem;
	}

	@Override
	public boolean czyMozeszWejsc(Set<UzytkownikCzytelni> sala, int rozmiarSali) {
		if (sala.stream().anyMatch(u -> u instanceof Pisarz)) {
			return false;
		}
		return rozmiarSali > sala.size();
	}
}
