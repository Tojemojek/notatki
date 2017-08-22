package pl.sda.javawwa.kostowski.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChangeInPhoneBook {

    private Set<String> phoneNumbers = new HashSet<>();


    //dodaj nowy numer / numery dla użytkownika o znanym nazwisku
    public static void addNewNumber(Map<String, Set<String>> phoneBook, String name, String... number) {
        if (FindInPhoneBook.searchByName(phoneBook, name) != null) {
            Set<String> tmpSet;
            tmpSet = phoneBook.get(name);
            for (String numbertmp : number) {
                tmpSet.add(numbertmp);
            }
        }
    }

    //usuń numer z użytkownika o nazwisku
    public static void removeNumber(Map<String, Set<String>> phoneBook, String name, String number) {
        if (FindInPhoneBook.searchByName(phoneBook, name) != null) {
            Set<String> tmpSet;
            tmpSet = phoneBook.get(name);
            tmpSet.remove(number);
        }
    }

    //zmień nazwisko użytkownika
    public static void changeUserName(Map<String, Set<String>> phoneBook, String oldName, String newName) {
        if (FindInPhoneBook.searchByName(phoneBook, oldName) != null) {
            Set<String> tmpSet;
            tmpSet = phoneBook.get(oldName);
            phoneBook.put(newName, tmpSet);
            phoneBook.remove(oldName);
        }

    }

    //zmień numer telefonu na inny numer telefonu
    public static void replaceTelNumber(Map<String, Set<String>> phoneBook, String oldTelNumber, String newTelNumber) {
        if (FindInPhoneBook.searchByPhoneNumber(phoneBook,oldTelNumber) != null) {
            String tmpKey =  FindInPhoneBook.searchByPhoneNumber(phoneBook,oldTelNumber);
            Set<String> tmpSet = phoneBook.get(tmpKey);
            tmpSet.remove(oldTelNumber);
            tmpSet.add(newTelNumber);

        }

    }

}
