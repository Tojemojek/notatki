package pl.sda.javawwa.KodProwadzacego;

import java.lang.reflect.Field;

public class CzytamPola {

	public String czytaj(Object obiekt) {
		Field[] pola = obiekt.getClass().getDeclaredFields();
		String wynik = "";
		for(Field pole: pola){
			wynik += pole.getName();
			pole.setAccessible(true);
			try {
				wynik = wynik + ":" + pole.get(obiekt) + ",";
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		}
		return wynik.substring(0, wynik.length()-1);		
	}
}
