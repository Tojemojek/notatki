package pl.sda.javawwa.set;

import pl.sda.javawwa.model.JobPosition;
import pl.sda.javawwa.model.Person2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {


        //hash set nie pozwala na dodanie duplikatów
        //do stwierdzenia że ten sam obiekt używa metody equals
        //każda klasa ma metodę equals która jest z klasy object
        //i może / powinna być zaimplementowana.
        Set<Person2> peopleHash = new HashSet<>();

        //hash set nie pozwala na dodanie duplikatów
        //do stwierdzenia że ten sam obiekt używa metody compareTo
        Set<Person2> peopleTree = new TreeSet<>();

        


        Person2 osoba1 = createPerson2("Albert", "Albertcik", JobPosition.ANALYST, "Wiejska", 15);
        Person2 osoba2 = createPerson2("XXX", "YYY", JobPosition.MANAGER, "Miejska", 21);
        Person2 osoba3 = createPerson2("NNNN", "NNNN", JobPosition.JUNIOR_DEVELOPER, "Siwa", 13);
        Person2 osoba4 = createPerson2("aaaa", "asdfasfsa", JobPosition.ANALYST, "Wiejska", 14);
        Person2 osoba5 = createPerson2("sadfasf", "asfasfa", JobPosition.DEVELOPER, "Inna", 17);


        peopleHash.add(osoba1);
        peopleHash.add(osoba2);
        peopleHash.add(osoba3);
        peopleHash.add(osoba4);
        peopleHash.add(osoba5);
        peopleHash.add(osoba2);

        System.out.println("\nCzy udało się dodać element do kolekcji przy dodawaniu duplikatów");
        System.out.println(peopleTree.add(osoba1));
        System.out.println(peopleTree.add(osoba1));
        peopleTree.add(osoba3);
        peopleTree.add(osoba4);
        peopleTree.add(osoba2);
        peopleTree.add(osoba5);

        System.out.println("\nWyświetlenie HashSet");
        for (Person2 prsTmp: peopleHash){
            System.out.println(prsTmp);
        }

        System.out.println("\nWyświetlenie TreeSet");
        for (Person2 prsTmp: peopleTree){
            System.out.println(prsTmp);
        }


    }

    private static Person2 createPerson2(String name, String surname, JobPosition jobposition, String ulica, int nrDomu) {
        return new Person2(name, surname, jobposition, ulica, nrDomu);
    }

}
