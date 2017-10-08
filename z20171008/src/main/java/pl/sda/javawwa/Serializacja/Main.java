package pl.sda.javawwa.Serializacja;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("\nPrzed serializacją");
        Serializacja s1 = new Serializacja();
        s1.poleKlasyBazowejInt = 30;
        s1.poleBazoweInt = 45;
        s1.liczba2 = 5;
        System.out.println(s1);
        zapisz(s1);


        System.out.println("\nPo serializacji");
        Serializacja s2;
        s2 = odczyt();
        System.out.println(s2);


    }

    private static void zapisz(Serializacja s) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("plik.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(s);
        out.close();
        fileOut.close();
    }

    private static Serializacja odczyt() throws Exception {
        FileInputStream fileIn = new FileInputStream("plik.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Serializacja o = (Serializacja) in.readObject();
        in.close();
        fileIn.close();
        return o;
    }
}
