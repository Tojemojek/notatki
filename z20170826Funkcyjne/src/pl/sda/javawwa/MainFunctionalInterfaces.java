package pl.sda.javawwa;

import pl.sda.javawwa.model.Book;
import pl.sda.javawwa.model.Library;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.*;
import java.util.stream.Collectors;

public class MainFunctionalInterfaces {

    public static void main(String[] args) {

        //interface dostarczone przez jave Function

        System.out.println("===========================");
        Function<String, Integer> returnStringLenght = (s) -> s.length();
        System.out.println("Sprawdzenie czy działa " + returnStringLenght.apply("165416515"));

        System.out.println("===========================");
        Function<Library, List<Book>> returnSienkiewiczBooks =
                (lib) -> {
                    return lib.getBooks().stream()
                            .filter(b -> b.getAuthorLastName().equals("Sienkiewicz"))
                            .collect(Collectors.toList());
                };
        System.out.println("Sprawdzenie działania funkcji książki sienkiewicza");
        returnSienkiewiczBooks.apply(new Library("Warszawa",
                Arrays.asList(new Book("O", "Henryk",
                        "Sienkiewicz",
                        135,
                        1930,
                        "105465")))).forEach(System.out::println);

        //interface dostarczone przez jave Predicate

        System.out.println("===========================");
        System.out.println("Działanie predykatu");
        Predicate<String> isStringLenghtOdd =
                (s) -> (s.length() % 2 == 0) ? true : false;

        System.out.println(isStringLenghtOdd.test("asfdgfjhasdfgj"));


        //interface dostarczone przez jave Consumer

        System.out.println("===========================");
        System.out.println("Consumer zmieniający isbn");

        Book book = new Book("O",
                "Henryk",
                "Sienkiewicz",
                135,
                1930,
                "105465");

        Consumer<Book> bookConsumer = (b) -> b.setIsbn("12316541531536");
        bookConsumer.accept(book);

        System.out.println(book);

        //interface dostarczone przez jave Supplier

        System.out.println("===========================");
        System.out.println("Supplier tworzy losowy UUID");

        Supplier<String> idRandomGenerator =
                () -> UUID.randomUUID().toString().replaceAll("-","");

        System.out.println(idRandomGenerator.get());
        System.out.println(idRandomGenerator.get());
        System.out.println(idRandomGenerator.get());

        System.out.println("===========================");
        System.out.println("Bifunction - bierze 2 argumenty różnych typów");

        BiFunction<Integer,String, String> multiHejt =
                (a,b) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < a; i++){
                        sb.append(b);
                    }
                 return sb.toString();
                };
        System.out.println(multiHejt.apply(3,"Hejt "));

        System.out.println("===========================");
        System.out.println("BinaryOperator - bierze 2 argumenty jednego typu i zwraca ten sam typ");

        BinaryOperator<Integer> sum = (a,b) -> a+b;
        System.out.println("Przykład sumy bioperatorem: " + sum.apply(15,30));

        BinaryOperator<String> binaryExample = (a,b) -> a.concat(b);
        System.out.println("Przykład binaryExample: " + binaryExample.apply("Ala m","a kota"));


    }
}