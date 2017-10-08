package pl.mije.sda.java.watki;

import java.util.HashSet;
import java.util.Set;

/**
 * Zmodyfikuj tak klase by jej obiekty mozna bylo bezpiecznie dzielic pomiedzy
 * watkami
 * 
 * @author michal.jedryszka
 *
 */
public class Niezmiennik {

	String nazwa;

	Set<CzescNiezmiennika> czesci;
	
	public Niezmiennik(String nazwa, Set<CzescNiezmiennika> czesci){
		this.nazwa = nazwa;
		this.czesci = new HashSet<CzescNiezmiennika>(czesci);
	}
	
	String getNazwa(){
		return nazwa;
	}
	
	Niezmiennik setNazwa(String nazwa){
		return new Niezmiennik(nazwa, this.czesci);
	}
	
	
	Set<CzescNiezmiennika> getCzesci(){
		return czesci;
	}
	
	public static void main(String[] args) {
		Set set = new HashSet<CzescNiezmiennika>();
		Niezmiennik n = new Niezmiennik("a", set);
		set.add(new CzescNiezmiennika("c"));
		n.getCzesci().add(new CzescNiezmiennika("d"));
	}
}

class CzescNiezmiennika {
	String nazwaCzesci;

	CzescNiezmiennika(String nazwa) {
		this.nazwaCzesci = nazwa;
	}
}