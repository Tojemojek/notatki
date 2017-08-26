package pl.sda.javawwa.functionalInterfaceCollection;

import pl.sda.javawwa.model.Book;
import pl.sda.javawwa.model.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryMain {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Pan Tadeusz", "Adam", "Mickiewicz", 888, 2002, "415641"));
        books.add(new Book("Lalka", "Bolesław", "Prus", 1111, 1999, "415642"));
        books.add(new Book("Ogniem i Mieczem", "Henryk", "Sienkiewicz", 1311, 1978, "415643"));
        books.add(new Book("Potop", "Henryk", "Sienkiewicz", 2432, 1989, "415644"));
        books.add(new Book("Nad Niemnem", "Eliza", "Orzeszkowa", 777, 1979, "415645"));

        List<Library> libraries = new ArrayList<>();

        libraries.add(new Library("Warszawa",books.subList(0,2)));
        libraries.add(new Library("Kraków",books.subList(2,5)));


        System.out.println("\nTworzy jeden stream książek ");
        libraries.stream()
                .map(lib-> lib.getBooks())
                .flatMap(b->b.stream())
                .forEach(System.out::println);

        System.out.println("\nTworzy stream książek ale tylko z Warszawy");
        libraries.stream()
                .filter(lib->lib.getCity().equals("Warszawa"))
                .map(lib-> lib.getBooks())
                .flatMap(b->b.stream())
                .forEach(System.out::println);




    }
}

