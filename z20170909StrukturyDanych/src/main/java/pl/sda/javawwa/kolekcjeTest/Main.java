package pl.sda.javawwa.kolekcjeTest;


import pl.sda.javawwa.kolekcje.MyArrayList;
import pl.sda.javawwa.kolekcje.MyList;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        MyList<String> list = new MyArrayList<>();

        list.add("Ala");
        list.add("ma");
        list.add("kota");
        list.add("który");
        list.add("jest");
        list.add("wredny");


        System.out.println("\nPełna lista po dodaniu wszystkich elementów");
        for (String str : list) {
            System.out.println(str);
        }


        System.out.println("\nLista po usunięciu elementu");
        list.remove(3);
        Iterator<String> it = list.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }


        System.out.println("\nTesty czy zawiera");
        System.out.println(list.contains("Ala"));
        System.out.println(list.contains("safdgjhj"));




    }
}
