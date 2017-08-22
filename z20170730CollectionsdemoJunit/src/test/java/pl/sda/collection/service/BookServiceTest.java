package pl.sda.collection.service;

import org.junit.Before;
import org.junit.Test;
import pl.sda.collection.Calculator;
import pl.sda.collection.model.Book;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookServiceTest {


    private BookService bookService;

    @Before
    public void initBookService() {
        this.bookService = new BookService();
    }

    @Test
    public void verifyAddNewBook() {

        Book book1 = new Book("Tytuł1", "Author1",
                LocalDate.of(2016, 01, 01));

        this.bookService.addNewBook(book1);

        List<Book> result = this.bookService.getAllBooks();

        assertEquals("Nie dodało się ", 1, result.size());
    }

    @Test
    public void verifyIfBookExist() {

        Book book1 = new Book("Tytuł1", "Author1",
                LocalDate.of(2016, 01, 01));

        this.bookService.addNewBook(book1);

        Book result1 = this.bookService.findBookByTitleAndAuthor("Tytuł1", "Author1");

        assertNotNull(result1);
        assertEquals("Nie znalazł książki ",
                result1.getAuthor().equals("Author1"), result1.getTitle().equals("Tytuł1"));
    }

    @Test
    public void verifyIsBookRemoved() {

        Book book1 = new Book("Tytuł1", "Author1",
                LocalDate.of(2016, 01, 01));

        this.bookService.addNewBook(book1);

        Boolean result = this.bookService.removeBook(book1);

        List<Book> result2 = this.bookService.getAllBooks();

        assertNotNull(result2);

        assertTrue(result);
        assertEquals("Kolecja nie jest pusta ", 0, result2.size());
    }

    @Test
    public void verifyIsBookRemovedByTitle() {

        Book book1 = new Book("Tytuł1", "Author1",
                LocalDate.of(2016, 01, 01));

        this.bookService.addNewBook(book1);
        this.bookService.removeBookByTitle("Tytuł1");

        List<Book> result2 = this.bookService.getAllBooks();


        assertEquals("Kolecja nie jest pusta ", 0, result2.size());
    }



}