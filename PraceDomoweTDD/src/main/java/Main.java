import pl.sda.javawwa.bookAndBasket.Basket;
import pl.sda.javawwa.bookAndBasket.Book;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Basket mb = new Basket();

        Book testBook1 = new Book("Autor1", "Tytuł1", 10.2);
        Book testBook2 = new Book("Autor2", "Tytuł2", 5.6);
        Book testBook3 = new Book("Autor3", "Tytuł2", 8.0);

        mb.addToBasket(testBook1);
        mb.addToBasket(testBook2);
        mb.addToBasket(testBook3);
        mb.addToBasket(testBook3);

        System.out.println(mb);

        Set<Book> books = mb.getSetOfBooksInBasket();

        for (Book book : books) {
            System.out.println(book);
        }

        mb.clearBasket();
        System.out.println(mb);


    }
}
