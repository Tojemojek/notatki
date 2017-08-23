package pl.cdacademy.javawwa4weekend.Calculations;

import pl.cdacademy.javawwa4weekend.Klient.Klient;

import java.util.LinkedList;
import java.util.Random;


public class Compute {

    private static final Double MIN_EXPENCES = 1000.00;
    private static final Double MAX_EXPENCES = 10000.00;


    public static void totalSpendMoney(Klient klient) {

        klient.setTotalSpend(0.0);
        for (int i = 0; i < 12; i++) {
            klient.setTotalSpend(klient.getTotalSpend() + klient.getExpenseInMonth(i));
        }
    }

    public static void generateRandomExpences(Klient klient) {
        for (int i = 0; i < 12; i++) {
            Double randomExpense;
            randomExpense = MIN_EXPENCES + (MAX_EXPENCES - MIN_EXPENCES) * Math.random();
            klient.setExpenseInMonth(i, randomExpense);
        }

    }

    public static Klient findBestCustomer(LinkedList<Klient> listaKlientow) {

        Klient tempBestKlient;
        tempBestKlient = listaKlientow.getFirst();

        for (Klient klientTmp : listaKlientow) {
            if (klientTmp.getTotalSpend() > tempBestKlient.getTotalSpend()) {
                tempBestKlient = klientTmp;
            } else {
                tempBestKlient = tempBestKlient;
            }
        }

        return tempBestKlient;

    }


    public static Klient findWorstCustomer(LinkedList<Klient> listaKlientow) {

        Klient findWorstCustomer;
        findWorstCustomer = listaKlientow.getFirst();

        for (Klient klientTmp : listaKlientow) {
            if (klientTmp.getTotalSpend() < findWorstCustomer.getTotalSpend()) {
                findWorstCustomer = klientTmp;
            }
        }

        return findWorstCustomer;

    }

    public static int findBestMonth(Klient klient) {

        int tmpBestMonth = 0;

        for (int i = 0; i < 12; i++) {

            if (klient.getExpenseInMonth(i) > klient.getExpenseInMonth(tmpBestMonth)) {
                tmpBestMonth = i;
            }

        }
        return tmpBestMonth;

    }

    public static int findWorstMonth(Klient klient) {

        int tmpWorstMonth = 0;

        for (int i = 0; i < 12; i++) {

            if (klient.getExpenseInMonth(i) < klient.getExpenseInMonth(tmpWorstMonth)) {
                tmpWorstMonth = i;
            }

        }
        return tmpWorstMonth;

    }


}
