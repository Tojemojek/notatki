package pl.sda.javawwa.listy;

import java.util.ArrayList;
import java.util.List;

public class BookListExample {

    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        bookInit();
        System.out.println(books);
        Book bookZMain = new Book("Tytul1","aasdas",110,"Autor2");

        System.out.println(books.contains(bookZMain));





    }

    private static void bookInit() {

        Book book1 = new Book("Tytul1", "aaa1", 100, "Autor1");
        Book book2 = new Book("Tytul2", "aaa2", 120, "Autor2");
        Book book3 = new Book("Tytul3", "aaa3", 150, "Autor3");

        books.add(book1);
        books.add(book2);
        books.add(book3);


    }

}
