package pl.sda.javawwa.KodProwadzacego;

/**
 * Klasa z polem modyfikowanym przez anotacje
 * @author mj
 *
 */
public class DowolnaKlasa {

	@Dopisywacz(koncowka = "|nowa_koncowka", przedrostek = "nowy_przedrostek|")
	private String dowolnePole = "jakas wartosc";

	private int wartosc = 100;
}
