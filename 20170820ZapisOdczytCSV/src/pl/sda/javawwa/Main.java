package pl.sda.javawwa;

import pl.sda.javawwa.Object.Person;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<Person> lista = new LinkedList<>();
    private static List<Person> listaWczytana = new LinkedList<>();

    public static void main(String[] args) {


        Person osoba1 = new Person("Imie1", "Nazwisko1", "Praca1");
        Person osoba2 = new Person("Imie2", "Nazwisko2", "Praca2");
        Person osoba3 = new Person("Imie3", "Nazwisko3", "Praca3");

        lista.add(osoba1);
        lista.add(osoba2);
        lista.add(osoba3);

        WriterOsob(lista);
        ReaderOsob(listaWczytana);


        for (Person osobaTmp : listaWczytana) {
            System.out.println(osobaTmp);
        }


    }


    public static void WriterOsob (List<Person> lista) {

        try (FileWriter doZapisu = new FileWriter("c:/temp/testcsv.txt")) {

            for (Person osobaTmp : lista) {
                doZapisu.write(osobaTmp.toString() + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void ReaderOsob (List<Person> listaWczytana){

        try (BufferedReader doOdczytu = new BufferedReader(new FileReader("c:/temp/testcsv.txt"))) {

            String temp = null ;
            String[] temp2;
            while (doOdczytu.readLine() != null){
                if (temp.length()>0) {
                    temp2 = temp.split("\t");
                    listaWczytana.add(new Person(temp2[0], temp2[1], temp2[2]));
                }
                temp = doOdczytu.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
