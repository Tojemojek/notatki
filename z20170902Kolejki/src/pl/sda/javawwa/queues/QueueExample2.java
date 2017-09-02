package pl.sda.javawwa.queues;

import pl.sda.javawwa.model.JobPosition;
import pl.sda.javawwa.model.Person;
import pl.sda.javawwa.model.Person2;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample2 {

    public static void main(String[] args) {


        Queue<Person2> kolejka = new PriorityQueue<>();

        Person2 osoba1 = createPerson2("Albert","Albertcik",JobPosition.ANALYST,"Wiejska",15);
        Person2 osoba2 = createPerson2("XXX","YYY",JobPosition.MANAGER,"Miejska", 21);
        Person2 osoba3 = createPerson2("NNNN","NNNN",JobPosition.JUNIOR_DEVELOPER,"Siwa",13);
        Person2 osoba4 = createPerson2("aaaa","asdfasfsa",JobPosition.ANALYST,"Wiejska",14);
        Person2 osoba5 = createPerson2("sadfasf","asfasfa",JobPosition.DEVELOPER,"Inna", 17);

        kolejka.offer(osoba1);
        kolejka.offer(osoba2);
        kolejka.offer(osoba3);
        kolejka.offer(osoba4);
        kolejka.offer(osoba5);

        System.out.println("\nWyświelenie kolejki po prostu - bez posortowania");
        kolejka.forEach(System.out::println);


        System.out.println("\nPosortowane");
        System.out.println(kolejka.poll());
        System.out.println(kolejka.poll());
        System.out.println(kolejka.poll());
        System.out.println(kolejka.poll());
        System.out.println(kolejka.poll());


    }

    private static Person2 createPerson2(String name, String surname, JobPosition jobposition, String ulica, int nrDomu){
        return new Person2(name,surname,jobposition,ulica,nrDomu);
    }

}
