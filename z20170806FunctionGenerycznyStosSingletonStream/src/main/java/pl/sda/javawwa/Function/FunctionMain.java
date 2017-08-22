package pl.sda.javawwa.Function;

import java.util.function.Function;

public class FunctionMain {


    public static void main(String[] args) {

        //+10
        //*2
        //to string w postaci "Wunik to " +

        Function<Integer, Integer> addTen = i -> i + 10;
        Function<Integer, Integer> multiplyByTwo = i -> i * 2;
        Function <Integer, String> reprezentacjaBinarna = i -> Integer.toBinaryString(i);

        Function<Integer, String> zrobStringa = i -> "Wynik to " + i;
        Function <String, String> zrobStringaZBinarki = i -> "Wynik (binarnie) to " + i;


        String coWyszlo = addTen.andThen(multiplyByTwo).andThen(zrobStringa).apply(5);

        System.out.println(coWyszlo);

        String coWyszlo2 = addTen.andThen(multiplyByTwo).andThen(reprezentacjaBinarna).andThen(zrobStringaZBinarki).apply(5);

        System.out.println(coWyszlo2);






    }
}

