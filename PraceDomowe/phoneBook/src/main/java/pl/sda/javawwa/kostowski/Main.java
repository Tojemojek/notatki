package pl.sda.javawwa.kostowski;

import pl.sda.javawwa.kostowski.Service.ChangeInPhoneBook;
import pl.sda.javawwa.kostowski.Service.FindInPhoneBook;

import java.util.*;

public class Main {


    private static Map<String, Set<String>> phoneBook;


    public static void main(String[] args) {

        initPhoneBook();

        FindInPhoneBook.searchByName(phoneBook,"Imię1");
        FindInPhoneBook.searchByPhoneNumber(phoneBook,"023456789");

        ChangeInPhoneBook.addNewNumber(phoneBook,"Imię1","123");

        System.out.println("Pole testowe");

        ChangeInPhoneBook.replaceTelNumber(phoneBook,"123","456");

        System.out.println("Pole testowe");

        ChangeInPhoneBook.removeNumber(phoneBook,"Imię1","123");


        System.out.println("Pole testowe");


        ChangeInPhoneBook.changeUserName(phoneBook,"Imię1","Imię2358");



        System.out.println("Pole testowe");


    }


    private static void initPhoneBook() {

        phoneBook = new HashMap<>();
        Set<String> tmpPhoneNumbers;
        Random random = new Random();

        int howManyrndNumbers =3;
        int homManyUsers = 5;


        for (int i = 0; i < homManyUsers; i++) {
            tmpPhoneNumbers = new HashSet<>();
            for (int j = 0; j < howManyrndNumbers; j++) {

                //tmpPhoneNumbers.add(String.valueOf(random.nextInt(900000000) + 100000000));
                tmpPhoneNumbers.add(i+ "23456789");
            }
            phoneBook.put("Imię" + i, tmpPhoneNumbers);


        }
    }


}
