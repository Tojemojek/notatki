package pl.sda.javawwa.map;

import pl.sda.javawwa.model.Person;
import pl.sda.javawwa.model.Person4;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Person4 person0 = new Person4("Kasfasf", "Kowalski", "83040400050");
        Person4 person1 = new Person4("asfdK", "Osfsfsf", "82040560050");
        Person4 person2 = new Person4("Kzsaf", "Nowak", "01040500250");
        Person4 person3 = new Person4("Kzxv", "Osadfdsaf", "99030400050");
        Person4 person4 = new Person4("Kzsdf", "Oasdfas", "92122600150");
        Person4 person5 = new Person4("Ksadf", "Oasfasf", "92122600150");

        Map<String, Person4> osoby = new HashMap<>();

        osoby.put(person0.getPesel(), person0);
        osoby.put(person1.getPesel(), person1);
        osoby.put(person2.getPesel(), person2);
        osoby.put(person3.getPesel(), person3);
        osoby.put(person4.getPesel(), person4);
        osoby.put(person5.getPesel(), person5);

        System.out.println("\nWyświetl wszystko dodane do listy");
        for (Map.Entry<String, Person4> entry : osoby.entrySet()) {
            System.out.println(String.format("Klucz %s, wartość %s",
                    entry.getKey(), entry.getValue()));
        }

        System.out.println("\nWyświetl wszystkie starsze niż 25 lat");

        for (String kluczTmp : osoby.keySet()) {
            Integer tmpMiesiac = Integer.parseInt(kluczTmp.substring(2, 4));

            Integer tmpRok;
            if (tmpMiesiac > 20) {
                tmpRok = 2000 + Integer.parseInt(kluczTmp.substring(0, 2));
            } else tmpRok = 1900 + Integer.parseInt(kluczTmp.substring(0, 2));

            if (2017 - tmpRok > 25) {
                System.out.println(osoby.get(kluczTmp));
            }
        }

        System.out.println("\nWyświetl wszystkie o nazwisku Kowalski lub Nowak");

        String name1 = "Kowalski";
        String name2 = "Nowak";

        for (Person4 personTmp : osoby.values()) {
            if (personTmp.getSurname().equals(name1) || personTmp.getSurname().equals(name2)) {
                System.out.println(personTmp);
            }
        }

        System.out.println("\nPróba ze stream wyświetl wszystkie starsze niż 25 lat");

        osoby.keySet().stream()
                .filter(s -> {
                    int tmpMiesiac = Integer.parseInt(s.substring(2, 4));
                    int tmpRok;
                    if (tmpMiesiac > 20) {
                        tmpRok = 2000 + Integer.parseInt(s.substring(0, 2));
                    } else tmpRok = 1900 + Integer.parseInt(s.substring(0, 2));
                    return 2017 - tmpRok > 25;
                })
                .forEach(s -> System.out.println(osoby.get(s)));

        System.out.println("\nPróba ze stream wyświetl wszystkie o nazwisku Kowalski lub Nowak");

        osoby.values().stream()
                .filter(s -> s.getSurname().equals(name1) || s.getSurname().equals(name2))
                .forEach(System.out::println);
    }
}