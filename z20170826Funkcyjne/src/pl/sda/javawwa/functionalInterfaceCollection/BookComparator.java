package pl.sda.javawwa.functionalInterfaceCollection;

import pl.sda.javawwa.model.Book;
import pl.sda.javawwa.objectTypeInterface.Computable;

import java.util.Comparator;

public class BookComparator implements Comparator<Book>{

    @Override
    public int compare(Book b1, Book b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }

}
