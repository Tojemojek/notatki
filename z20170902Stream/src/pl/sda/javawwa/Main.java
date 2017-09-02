package pl.sda.javawwa;

import pl.sda.javawwa.model.Person;
import pl.sda.javawwa.service.ReadSerializedPeoplesList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        ReadSerializedPeoplesList.readFile(people);
        LocalDate dzis = LocalDate.now();


        System.out.println("\nWyświetlenie pierwszego Janka");
        Optional<Person> pierwszyJanek = people.stream()
                .filter(s -> s.getName().equals("Janek"))
                .findFirst();

        //jeśli nie będzie to optional wywali błąd
        //Exception in thread "main" java.util.NoSuchElementException: No value present
        System.out.println(pierwszyJanek.get());

        System.out.println("\nWyświetlenie wszystkich Janków");
        people.stream()
                .filter(s -> s.getName().equals("Janek"))
                .forEach(System.out::println);

        System.out.println("\nStworzenie listy i wyświetlenie wszystkich Janków");
        List<Person> listaJankow = people.stream()
                .filter(s -> s.getName().equals("Janek"))
                .collect(Collectors.toList());

        listaJankow.forEach(System.out::println);

        System.out.println("\nStworzenie listy unikalnych nazwisk");
        Set<String> collectNames = people.stream()
                .map(s -> s.getSurname())
                .collect(Collectors.toSet());

        collectNames.forEach(System.out::println);


        System.out.println("\nStworzenie listy nazwisk osób o wadze > 100 kg i wieku > 60 lat");
        List<Person> collectCiezkieiMlode = people.stream()
                .filter(s -> s.getWeightInKg() > 110 && (dzis.getYear() - s.getBirthDate().getYear() > 60))
                .collect(Collectors.toList());
        //.map(s -> s.getSurname())
        collectCiezkieiMlode.forEach(System.out::println);


        System.out.println("\nZnalezienie najstarszej osoby");
        Person osobaNajstarsza = people.stream()
                .max((o1, o2) -> o1.getBirthDate().compareTo(o2.getBirthDate()))
                .get();
        System.out.println(osobaNajstarsza);


        System.out.println("\nZnalezienie średniej wagi");
        Double sredniaWaga = people.stream()
                .mapToDouble(s -> s.getWeightInKg())
                .average()
                .getAsDouble();
        System.out.println(sredniaWaga);

    }

}
