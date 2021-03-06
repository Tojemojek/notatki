package pl.sda.javawwa.functionalInterfaceCollection;

import pl.sda.javawwa.model.Book;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookMain {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Pan Tadeusz", "Adam", "Mickiewicz", 888, 2002, "415641"));
        books.add(new Book("Lalka", "Bolesław", "Prus", 1111, 1999, "415642"));
        books.add(new Book("Ogniem i Mieczem", "Henryk", "Sienkiewicz", 1311, 1978, "415643"));
        books.add(new Book("Potop", "Henryk", "Sienkiewicz", 2432, 1989, "415644"));
        books.add(new Book("Nad Niemnem", "Eliza", "Orzeszkowa", 777, 1979, "415645"));


        System.out.println("\nKsiążki poniżej 1000 stron pętlą for each");
        for (Book b : books) {
            if (b.getPages() < 1000) {
                System.out.println(b);
            }
        }


        System.out.println("\nKsiążki poniżej 1000 stron stream");
        books.stream()
                .filter(b -> b.getPages() < 1000)
                .forEach(System.out::println);


        System.out.println("\nKsiążki poniżej 1000 stron stream z użyciem predykatu");
        Predicate<Book> p = (b) -> b.getPages() < 1000;
        books.stream()
                .filter(p)
                .forEach(System.out::println);


        //System.out.println("Zebranie do listy książek poniżej 1000 stron stream z użyciem predykatu");
        List<Book> zebraneDane = books.stream()
                .filter(b -> b.getPages() < 1000)
                .collect(Collectors.toList());

        System.out.println("\nUżycie komparatora");

        System.out.println("\nPrzed sortowaniem");
        books.forEach(System.out::println);

        System.out.println("\nPo sortowaniu");
        Collections.sort(books, new BookComparator());
        books.forEach(System.out::println);

        System.out.println("\nUżycie komparatora i lambdy (odwrócenie sortowania)");

        Collections.sort(books, (b1, b2) -> b2.getTitle().compareTo(b1.getTitle()));
        books.forEach(System.out::println);

        System.out.println("\nUżycie komparatora i lambdy w stream ");
        books.stream()
                .sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()))
                .forEach(System.out::println);

        System.out.println("\nUżycie komparatora i lambdy przez referencję w stream ");
        books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);


        System.out.println("\nSprawdź czy którakolwiek książka została wydana przed 1900r ");
        boolean czyPrzed1900;
        czyPrzed1900 = books.stream()
                .anyMatch(b->b.getPublishYear()<1900);
        System.out.println("Książka przed 1900 jest: "+ czyPrzed1900);

        System.out.println("\nSprawdź czy każda książka ma więcej niż 100 stron ");
        boolean czyKazdaMaWiecejNiz100stron;
        czyKazdaMaWiecejNiz100stron = books.stream()
                .allMatch(b->b.getPages()>100);
        System.out.println("Wszystkie ksiazki mają wiecej niż: "+ czyKazdaMaWiecejNiz100stron);


        System.out.println("\nWypisanie wszystkich książek których autorem jest kobieta ");
        books.stream()
                .filter(b -> b.getAuthorName().endsWith("a"))
                .forEach(System.out::println);


        System.out.println("\nUżycie mapowania - zmiany jednego typu obiektu na inny ");
        //do domu - uzyskać listę nazwisk które się nie powtarzają tak jak poniżej
        //ale za pomocą zwykłej składni for each.
        List<String> lastNames = books.stream()
                .map(b -> b.getAuthorLastName())
                .distinct()
                .sorted((a, b) -> a.compareTo(b))
                .collect(Collectors.toList());
        System.out.println(lastNames);






    }

}
