package pl.cdacademy.javawwa4weekend.Calculations;

import pl.cdacademy.javawwa4weekend.Klient.Klient;
import java.util.LinkedList;



public class Additional {


    public static Double[] averageInMonths (LinkedList<Klient> listaKlientow){

        Double[] averageValuesInMonths = new Double[12];

        for (int i = 0; i<12; i++){
            averageValuesInMonths[i] = 0.0;

            for (Klient klientTmp : listaKlientow) {

                averageValuesInMonths[i] +=klientTmp.getExpenseInMonth(i);


            }

            averageValuesInMonths[i] = averageValuesInMonths[i]/listaKlientow.size();


        }

        return averageValuesInMonths;

    }

}
