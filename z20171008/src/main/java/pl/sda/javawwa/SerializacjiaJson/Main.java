package pl.sda.javawwa.SerializacjiaJson;


public class Main {

    public static void main(String[] args) throws Exception {

        Osoba osoba1 = new Osoba("Imie1", "Nazwisko1",12);
        Osoba osoba2 = new Osoba("Imie2", "Nazwisko2",22);

        ToString toString = new ToString();


        System.out.println("Zczytanie nazw pól i wartości pól korzystając z refleksji");
        String s1 = toString.toString(osoba1);
        System.out.println(s1);

        String s2 = toString.toString(osoba2);
        System.out.println(s2);

        System.out.println("\nWczytanie do obiektu pól z s1");

        FromString fs = new FromString();
        Osoba osobaTmp1 = (Osoba) fs.fromString(s1,Osoba.class);

        System.out.println(osobaTmp1);

        System.out.println("Wczytanie do obiektu pól z s2");

        Osoba osobaTmp2 = (Osoba) fs.fromString(s2,Osoba.class);
        System.out.println(osobaTmp2);

    }
}
