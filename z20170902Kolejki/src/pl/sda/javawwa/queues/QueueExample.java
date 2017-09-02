package pl.sda.javawwa.queues;

import pl.sda.javawwa.model.JobPosition;
import pl.sda.javawwa.model.Person;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        //obsługa kolejki w kolejności posortowanej
        //compareTo działa i to wydajnie
        Queue<Person> kolejka = new PriorityQueue<>();

        Person osoba1 = createPerson("Albert","Albertcik",JobPosition.ANALYST);
        Person osoba2 = createPerson("XXX","YYY",JobPosition.MANAGER);
        Person osoba3 = createPerson("NNNN","NNNN",JobPosition.JUNIOR_DEVELOPER);
        Person osoba4 = createPerson("aaaa","asdfasfsa",JobPosition.ANALYST);
        Person osoba5 = createPerson("sadfasf","asfasfa",JobPosition.DEVELOPER);

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

    private static Person createPerson(String name, String surname, JobPosition jobposition){
        return new Person(name,surname,jobposition);
    }

}
