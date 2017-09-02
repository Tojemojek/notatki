package pl.sda.javawwa.set;

import pl.sda.javawwa.model.JobPosition;
import pl.sda.javawwa.model.Person2;
import pl.sda.javawwa.model.Person3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample2 {

    public static void main(String[] args) {


        Set<Person3> peopleHash = new HashSet<>();

        Person3 osoba1 = createPerson3("Albert", "Albertcik", JobPosition.ANALYST, "Wiejska", 15);
        Person3 osoba2 = createPerson3("XXX", "YYY", JobPosition.MANAGER, "Miejska", 21);
        Person3 osoba3 = createPerson3("NNNN", "NNNN", JobPosition.JUNIOR_DEVELOPER, "Siwa", 13);
        Person3 osoba4 = createPerson3("aaaa", "asdfasfsa", JobPosition.ANALYST, "Wiejska", 14);
        Person3 osoba5 = createPerson3("asdsafsaf", "asfasfaf", JobPosition.ANALYST, "Wiejska", 14);
        Person3 osoba6 = createPerson3("sadfasf", "asfasfa", JobPosition.DEVELOPER, "Inna", 17);


        System.out.println("\nWyświetlenie dodawania do listy");
        System.out.print(osoba1);
        System.out.println(" została dodana " + peopleHash.add(osoba1));
        System.out.print(osoba2);
        System.out.println(" została dodana " + peopleHash.add(osoba2));
        System.out.print(osoba3);
        System.out.println(" została dodana " + peopleHash.add(osoba3));
        System.out.print(osoba4);
        System.out.println(" została dodana " + peopleHash.add(osoba4));
        System.out.print(osoba5);
        System.out.println(" została dodana " + peopleHash.add(osoba5));
        System.out.print(osoba6);
        System.out.println(" została dodana " + peopleHash.add(osoba6));

        System.out.println("\nWyświetlenie HashSet");
        for (Person3 prsTmp : peopleHash) {
            System.out.println(prsTmp);
        }

    }

    private static Person3 createPerson3(String name, String surname, JobPosition jobposition, String ulica, int nrDomu) {
        return new Person3(name, surname, jobposition, ulica, nrDomu);
    }

}
