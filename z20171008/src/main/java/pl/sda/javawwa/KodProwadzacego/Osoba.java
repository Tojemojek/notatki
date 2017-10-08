package pl.sda.javawwa.KodProwadzacego;

import java.io.IOException;

/**
 * Przykladowa klasa poddawana inspekcji Uzycie anotacji na polu imie
 * 
 * @author mj
 *
 */
@Mnoznik(wartosc = 2)
public class Osoba {

	@Dopisywacz(koncowka = ".po", przedrostek = "przed.")
	private String imie;

	@Dopisywacz(koncowka = ".after", przedrostek = "before.")
	@ToUpperCase
	private String nazwisko;

	private int wiek;
	
	private void metodaPrywatna(String arg){
		System.out.println("Metoda prywatna z prametrem: " + arg);
	}

	public synchronized String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}
	
	public static void main(String[] args) {
		Osoba p = new Osoba();
	}
	
	@Override
	public String toString(){
		return "";
	}
}
