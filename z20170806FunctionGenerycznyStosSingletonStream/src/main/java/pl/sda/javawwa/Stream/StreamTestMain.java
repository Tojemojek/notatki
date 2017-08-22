package pl.sda.javawwa.Stream;

import pl.sda.javawwa.Stream.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTestMain {

    public static void main(String[] args) {


        List<Integer> lista1 = new ArrayList<Integer>();

        lista1.add(1);
        lista1.add(2);
        lista1.add(3);
        lista1.add(4);

        Student student1 = new Student("Imię1", "Nazwisko1", 19, lista1);
        Student student2 = new Student("Imię2", "Nazwisko2", 15, lista1);
        Student student3 = new Student("Imię3", "Nazwisko3", 19, lista1);
        Student student4 = new Student("Imię4", "Nazwisko4", 16, lista1);
        Student student5 = new Student("Imię5", "Nazwisko5", 19, lista1);

        Student student6 = Student.of("Imię5", "Nazwisko5", 19, lista1);

        List<Student> studenci = new ArrayList<>();

        studenci = Arrays.asList(student1, student2, student3, student4, student5);

        Map<Integer, List<Student>> pogrupowaniStudenci;

        pogrupowaniStudenci = studenci
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));


        Map<String, List<Integer>> ocenyDoNazwisk;

        ocenyDoNazwisk = studenci
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getLastName(),
                        p -> p.getScores()));

//tu jest zastosowanie optional - inna klasa typu generycznego
//        Optional<Integer> suma;
//
//        suma = Arrays.asList(1, 2, 3, 4, 5, 6)
//                .stream()
//                .reduce((i, b) -> i + b);

        Integer suma;

        suma = Arrays.asList(2, 3, 4, 5, 6)
                .stream()
                .reduce((i, b) -> i + b)
                .orElse(null);


        Integer roznica;

        roznica = Arrays.asList(200, 2, 3, 4, 5, 6)
                .stream()
                .reduce((i, b) -> i -b)
                .orElse(null);


        System.out.println(suma);
        System.out.println(roznica);

        System.out.println();







    }
}

