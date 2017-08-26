package pl.sda.javawwa.objectTypeInterface;

public class Main {
    public static void main(String[] args) {

        Computable adder = new Adder();
        Computable multiplier = new Multiplier();

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println(adder.compute(13, 14));
        System.out.println(multiplier.compute(3, 5));

        System.out.println("+++++++++++++++++++++++++++++++++");
        //zalety polimorfizmu i definiowania jako klasy "nadrzędne"
        Computable tab[] = new Computable[2];
        tab[0] = adder;
        tab[1] = multiplier;

        for (Computable tmp : tab) {
            System.out.println(tmp.compute(4, 5));
        }
    }
}