package pl.sda.javawwa.Serializacja;

public class Bazowa{

    transient Integer poleKlasyBazowejInt = 10;
    transient Integer liczba2;

    public Bazowa() {
        System.out.println("Konstruktor klasy bazowej");
    }


}
