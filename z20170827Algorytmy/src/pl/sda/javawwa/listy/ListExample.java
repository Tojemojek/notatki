package pl.sda.javawwa.listy;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();

        lista.add(5);
        lista.add(300);
        lista.add(10);
        lista.add(100);

        Integer number = 300;
        lista.add(number);

        System.out.println(lista);

        lista.add(0,3);

        System.out.println(lista);

        //metoda remove po indeksie
        lista.remove(0);

        System.out.println(lista);

        //uwaga
        //remove wewnątrz listy korzysta z metody equals
        //do tego usuwa tylko jedno wystąpienie - pierwsze napotkane w iteracji

        lista.remove(new Integer (300));
        System.out.println(lista);


        List <Integer> negativeInteger = new ArrayList<>();
        negativeInteger.add(-3);
        negativeInteger.add(-32);
        negativeInteger.add(-34);

        lista.addAll(negativeInteger);

        System.out.println(lista);






    }

}
