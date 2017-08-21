package pl.sda.javawwa.myError;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Main {


    public static void main(String[] args) {

        String daneTestowe = "dupa";
        Integer wynikTestowy;

        NumberChecker tester = new NumberChecker();

        try {
            wynikTestowy = tester.isANumber(daneTestowe);
            System.out.println(wynikTestowy + " to liczba");
        } catch (MojWyjatek e) {
            System.err.println(e.getMessage());
            System.err.println("Przyczyna " + e.getCause());
            System.err.println(daneTestowe + " nie są liczbą");
        }


    }


}
