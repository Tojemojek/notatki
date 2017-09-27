package pl.sda.javawwa.bookAndBasket;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateBook() throws Exception {

        String tytuł = "TestowyTytuł";
        String autor = "TestowyAutor";
        Double cena = 25.22;

        Book testBook = new Book(autor, tytuł, cena);

        Assert.assertNotNull(testBook);

        Assert.assertEquals(testBook.getAuthor(), autor);
        Assert.assertEquals(testBook.getTitle(), tytuł);
        Assert.assertEquals(testBook.getPrice(), cena);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBookWithIllegalTitle() throws IllegalArgumentException {

        String tytuł = null;
        String autor = "TestowyAutor";
        Double cena = 25.22;

        Book testBook = new Book(autor, tytuł, cena);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBookWithIllegalAuthor() throws IllegalArgumentException {

        String tytuł = "TestowyTytuł";
        String autor = "TestowyAutor";
        Double cena = -5d;

        Book testBook = new Book(autor, tytuł, cena);

    }


    @Test
    public void testGetPrice() throws Exception {

        String tytuł = "TestowyTytuł";
        String autor = "TestowyAutor";
        Double cena = 25.22;

        Book testBook = new Book(autor, tytuł, cena);

        Assert.assertEquals(cena, testBook.getPrice());

    }


    @After
    public void tearDown() throws Exception {
    }

}