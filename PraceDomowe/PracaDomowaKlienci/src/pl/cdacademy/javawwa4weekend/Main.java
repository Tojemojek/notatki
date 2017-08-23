package pl.cdacademy.javawwa4weekend;

import pl.cdacademy.javawwa4weekend.Calculations.Additional;
import pl.cdacademy.javawwa4weekend.Calculations.Compute;
import pl.cdacademy.javawwa4weekend.Klient.Klient;

import java.util.LinkedList;



//- klienta (imię, nazwisko, wiek, łączna kwota zakupów),
//        który wydał najwięcej pieniędzy na zakupy
//        - klienta (imię, nazwisko, wiek, łączna kwota zakupów),
//        który wydał najmniej pieniędzy na zakupy
//        - dla klienta, który miał największe zakupy, wskazać miesiąc,
//        w którym wydał najmniejszą kwotę
//        - dla klienta, który mial najmniejsze zakupy, wskazać miesiąc,
//        w którym wydał największą sumę.

public class Main {

    private static final String[] NAZWY_MIESIECY = {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec",
            "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};

    public static void main(String[] args) {

        Klient bestCustomer;
        Klient worstCustomer;
        int bestMonth;
        int worstMonth;
        Double[] averageValuesInMonths;


        Klient klient1 = new Klient("Jan", "Nowak", 19);
        Klient klient2 = new Klient("Janek", "Nowaczek", 23);
        Klient klient3 = new Klient("Janeczek", "Nowakowski", 45);
        Klient klient4 = new Klient("Janeczuniek", "Nowaczyk", 72);
        Klient klient5 = new Klient("Inny", "Świat", 58);

        for (Klient klientTmp: Klient.getListaKlientow()) {
            Compute.generateRandomExpences(klientTmp);
            Compute.totalSpendMoney(klientTmp);
        }

        System.out.println("++++++++++++Do sprawdzenia poprawności++++++++++++++++++");

        for (Klient klientTmp: Klient.getListaKlientow()) {
            klientTmp.printExpenses();
        }

        System.out.println("++++++++++++Koniec sprawdzania poprawności++++++++++");



        bestCustomer = Compute.findBestCustomer(Klient.getListaKlientow());
        worstCustomer = Compute.findWorstCustomer(Klient.getListaKlientow());

        bestMonth = Compute.findBestMonth(worstCustomer);
        worstMonth = Compute.findWorstMonth(bestCustomer);



        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("Najlepszym klientem jest: " + bestCustomer);
        System.out.println("A jego najgorszym miesiącem jest: " + NAZWY_MIESIECY[worstMonth]);
        System.out.println("W którym zrobił obrót: " + bestCustomer.getExpenseInMonth(worstMonth));
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("Najgorszym klientem jest: " + worstCustomer);
        System.out.println("A jego najlepszym miesiącem jest: " + NAZWY_MIESIECY[bestMonth]);
        System.out.println("W którym zrobił obrót: " + worstCustomer.getExpenseInMonth(bestMonth));



        System.out.println();
        System.out.println();
        System.out.println();


        averageValuesInMonths = Additional.averageInMonths(Klient.getListaKlientow());

        for (int i = 0; i<12;i++){
            System.out.println("Średni obrót w miesiącu " + NAZWY_MIESIECY[i]);
            System.out.println(averageValuesInMonths[i]);
        }





// ten fragment tylko po to żeby każdemu klientowi przypisać określone zakupy
//        Double[] expences1 = {0.36, 465.46, 356.46, 624.8, 911.82, 650.75, 188.88, 5.41, 82.11, 962.0, 573.67, 11.89};
//        Double[] expences2 = {269.61, 114.34, 329.9, 221.14, 276.54, 580.09, 409.02, 415.64, 447.25, 331.24, 840.76, 210.31};
//        Double[] expences3 = {736.29, 537.85, 412.92, 486.81, 226.32, 993.84, 884.91, 366.72, 472.4, 365.84, 327.62, 600.49};
//        Double[] expences4 = {153.5, 336.47, 902.11, 972.57, 382.43, 392.75, 954.35, 512.88, 572.54, 337.87, 749.19, 382.94};
//
//        for (int i = 0; i < 12; i++) {
//            klient1.setExpenseInMonth(i, expences1[i]);
//            klient2.setExpenseInMonth(i, expences2[i]);
//            klient3.setExpenseInMonth(i, expences3[i]);
//            klient4.setExpenseInMonth(i, expences4[i]);
//        }
//        // do tego miejsca

//        Compute.generateRandomExpences(klient1);
//        Compute.generateRandomExpences(klient2);
//        Compute.generateRandomExpences(klient3);
//        Compute.generateRandomExpences(klient4);
//
//        Compute.totalSpendMoney(klient1);
//        Compute.totalSpendMoney(klient2);
//        Compute.totalSpendMoney(klient3);
//        Compute.totalSpendMoney(klient4);








    }
}
