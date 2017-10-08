package pl.sda.javawwa.Serializacja;

import java.io.Serializable;

public class Serializacja extends Bazowa implements Serializable {

    Integer poleBazoweInt = 20;

    public Serializacja() {
        System.out.println("To jest konstruktor klasy pochodnej");
    }

    @Override
    public String toString() {
        return "Serializacja{" +
                "poleBazoweInt=" + poleBazoweInt +
                ", poleKlasyBazowejInt=" + poleKlasyBazowejInt +
                ", liczba2=" + liczba2 +
                '}';
    }

}
