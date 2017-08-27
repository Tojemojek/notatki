package pl.sda.javawwa.listy;

import java.util.ArrayList;
import java.util.List;

public class ListTraining {

    public static void main(String[] args) {

        Integer rozmTablicy = 10;
        Integer suma = 0;
        Integer min;
        Integer max;
        List<Integer> lista = new ArrayList<>();

        System.out.println("Start:");
        System.out.println(lista);

        for (int i = 0; i < rozmTablicy; i++) {
                    lista.add(i+1);
        }

        System.out.println("Po dodaniu elmentu: ");
        System.out.println(lista);



        for (int i = 2; i < rozmTablicy; i+=3) {
            lista.add(i+1,lista.get(i)+lista.get(i-1));
            lista.remove(i);
        }

        System.out.println("Co trzeci element dodaje poprzedni: ");
        System.out.println(lista);


        for (int i = 0; i < rozmTablicy; i++) {
            if (lista.get(i) % 2 ==0) {
                lista.add(i+1,lista.get(i)/2);
                lista.remove(i);
            }
        }

        System.out.println("Dzieli parzyste na 2 poprzedni: ");
        System.out.println(lista);

        for (Integer tmp:lista) {
            suma += tmp;
        }

        System.out.println(String.format("Suma wszystkich wartości: %d",suma));



        min = lista.get(0);
        max = lista.get(0);

        for (Integer tmp:lista) {
            if (min > tmp){
                min = tmp;
            }
            if (max < tmp){
                max = tmp;
            }
        }

        System.out.println(String.format("Wartość max %d, wartość min %d",max,min));


    }

}
