package pl.sda.javawwa.Generic;

import java.util.LinkedList;
import java.util.List;

public class GenericClassTest {

    public static List<Person> lista= new LinkedList<>();

    public static void main(String[] args) {


        Person osoba1 = new Person("Imie1");
        Person osoba2 = new Person("Imie2");
        Person osoba3 = new Person("Imie3");

        lista.add(osoba1);
        lista.add(osoba2);
        lista.add(osoba3);


        GenericClass<Person> tocos = new GenericClass<>(lista);

        System.out.println(tocos.getprintConcatenateNames());


    }
}
