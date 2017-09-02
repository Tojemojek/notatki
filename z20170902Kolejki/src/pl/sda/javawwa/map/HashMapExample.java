package pl.sda.javawwa.map;

import pl.sda.javawwa.model.JobPosition;
import pl.sda.javawwa.model.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {

        Person osoba1 = new Person("Albert", "Albertcik", JobPosition.ANALYST);
        Person osoba2 = new Person("XXX", "YYY", JobPosition.MANAGER);
        Person osoba3 = new Person("NNNN", "NNNN", JobPosition.JUNIOR_DEVELOPER);
        Person osoba4 = new Person("aaaa", "asdfasfsa", JobPosition.ANALYST);
        Person osoba5 = new Person("sadfasf", "asfasfa", JobPosition.DEVELOPER);
        Person osoba6 = new Person("Albert", "asfasfa", JobPosition.DEVELOPER);

        Map<String, Person> mapaOsob = new HashMap<>();

        mapaOsob.put(osoba1.getName(), osoba1);
        mapaOsob.put(osoba2.getName(), osoba2);
        mapaOsob.put(osoba3.getName(), osoba3);
        mapaOsob.put(osoba4.getName(), osoba4);
        mapaOsob.put(osoba5.getName(), osoba5);
        mapaOsob.put(osoba6.getName(), osoba6);

        System.out.println("\niteracja po parze klucz i wartość ");
        for (Map.Entry<String, Person> entry : mapaOsob.entrySet()) {
            System.out.println(String.format("Klucz %s, wartość %s",
                    entry.getKey(), entry.getValue()));
        }

        System.out.println("\niteracja po kluczach ");
        for (String keyTmp : mapaOsob.keySet()) {
            System.out.println(String.format("Klucz %s, wartość %s",
                    keyTmp, mapaOsob.get(keyTmp)));
        }

        System.out.println("\niteracja po wartościach ");
        for (Person osobaTmp : mapaOsob.values()) {
            System.out.println(String.format("Wartość %s",
                    osobaTmp));
        }

        Map<String, Person> mapaOsob2 = new HashMap<>();
        mapaOsob2.put("1", osoba1);
        mapaOsob2.put("2", osoba2);
        mapaOsob2.put("3", osoba3);
        mapaOsob2.put("4", osoba4);
        mapaOsob2.put("5", osoba5);
        mapaOsob2.put("6", osoba6);

        System.out.println("\niteracja po parze klucz i wartość - wersja 2");
        for (Map.Entry<String, Person> entry2 : mapaOsob2.entrySet()) {
            System.out.println(String.format("Klucz %s, wartość %s",
                    entry2.getKey(), entry2.getValue()));
        }

        System.out.println("\niteracja po kluczach - wersja 2");
        for (String keyTmp2 : mapaOsob2.keySet()) {
            System.out.println(String.format("Klucz %s, wartość %s",
                    keyTmp2, mapaOsob2.get(keyTmp2)));
        }

        System.out.println("\niteracja po wartościach - wersja 2");
        for (Person osobaTmp2 : mapaOsob2.values()) {
            System.out.println(String.format("Wartość %s",
                    osobaTmp2));
        }
    }
}
