package pl.mije.sda.java.watki;

/**
 * Mamy pieciu filozofow, którzy spedzaja czas na mysleniu, 
 * ale czasem musza sie tez posilic. 
 * Wtedy zasiadaj¹ do stolu, aby pozywic siê jedzac spagetti.
 * Problem polega na tym, ze na stole znajduje siê tylko piêc widelcy, 
 * a kazdy z myslicieli potrzebuje dwoch, aby moc spozyc potrawe.
 * 
 * @author mj
 *
 */
public class Filozofowie {
	public static Miejsce[] dostepneMiejsca = {};
	public static Widelec[] dostepneWidelce = {};
	
	public static void main(String[] args) {
		Filozof a = new Filozof("a");
		Filozof b = new Filozof("b");
		Filozof c = new Filozof("c");
		Filozof d = new Filozof("d");
		Filozof e = new Filozof("e");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}

class Miejsce {
	private Filozof filozof;
	
	public void zajmij(Filozof filozof) {
		this.filozof = filozof;
	}
	public void zwolnij() {
		this.filozof = null;
	}


	public boolean jestWolne() {
		return filozof == null;
	}
	public String getNumer() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Widelec {

}

class Filozof extends Thread {
	private String imie;

	Filozof(String imie) {
		this.imie = imie;
	}

	public void run() {
		while(true){
			mysle();
			Miejsce miejsce = this.szukamMiejsca(Filozofowie.dostepneMiejsca);
			if(miejsce.jestWolne()){
				miejsce.zajmij(this);
				jedz(miejsce, Filozofowie.dostepneWidelce);
			}
		}
	}

	private void jedz(Miejsce miejsce, Widelec[] dostepneWidelce) {
		System.out.println("Filozof " + imie + " posila sie na miejscu " + miejsce.getNumer());
		System.out.println("uzywajac widelca " + " posila sie na miejscu " + miejsce.getNumer());
	}

	private Miejsce szukamMiejsca(Miejsce[] dostepneMiejsca) {
		// TODO Auto-generated method stub
		return null;
	}

	private void mysle() {
		System.out.println(imie + ": Mysle");
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}