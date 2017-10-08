package pl.sda.javawwa.KodProwadzacego;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Przyklad w jaki sposob mozna uzyc anotacji do modyfikowania warotsci pol
 *
 * @author mj
 */
public class ZAnotacja {

    private static void uzyjAnotacji(Object obiekt) throws IllegalArgumentException, IllegalAccessException {
        for (Field pole : obiekt.getClass().getDeclaredFields()) {
            for (Annotation anotacja : pole.getAnnotations()) {
                if (anotacja.annotationType().equals(Dopisywacz.class)) {
                    pole.setAccessible(true);
                    Dopisywacz dopiswacz = (Dopisywacz) anotacja;
                    String nowaWartosc = dopiswacz.przedrostek()
                            + (String) pole.get(obiekt)
                            + dopiswacz.koncowka();
                    pole.set(obiekt, nowaWartosc);
                }
                if (anotacja.annotationType().equals(ToUpperCase.class)) {
                    pole.setAccessible(true);
                    pole.set(obiekt, ((String) pole.get(obiekt)).toUpperCase());
                }
            }
        }


        Mnoznik anotacjaTypu = obiekt.getClass().getAnnotation(Mnoznik.class);
        if (anotacjaTypu != null) {
            for (Field pole : obiekt.getClass().getDeclaredFields()) {
                pole.setAccessible(true);
                try {
                    int wartosc = pole.getInt(obiekt);
                    //pole.getType()
                    pole.setInt(obiekt, wartosc * anotacjaTypu.wartosc());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void infoKazdegoObiektu(Object obiekt) throws IllegalArgumentException, IllegalAccessException {
        for (Field pole : obiekt.getClass().getDeclaredFields()) {
            pole.setAccessible(true);
            System.out.println(pole.getName() + ": " + pole.get(obiekt));
        }
    }

    public static void main(String[] args) throws Exception {
        Osoba osoba = new Osoba();
        osoba.setImie("Jan");
        osoba.setNazwisko("Kowalski");
        osoba.setWiek(67);

        infoKazdegoObiektu(osoba);
        uzyjAnotacji(osoba);
        infoKazdegoObiektu(osoba);
    }
}
