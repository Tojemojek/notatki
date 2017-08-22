package pl.sda.collection.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.collection.model.Author;


public class AuthorServiceTest {

    private AuthorService authorService;

    @Before
    public void initAuthorTest() {
        this.authorService = new AuthorService();
    }

    @Test
    public void verifyIfAuthorAdded() {
        Author author = new Author("Imię1", "Nazwisko");

        this.authorService.addNewAuthor(author);
        this.authorService.addNewAuthor(author);

        Assert.assertTrue(this.authorService.findAllAuthors().size()==1);

    }


    @Test
    public void verifyIfAuthorIsRemoved() {

        Author author = new Author("Imię1", "Nazwisko");

        this.authorService.addNewAuthor(author);

        Assert.assertEquals(1,this.authorService.findAllAuthors().size());

        this.authorService.removeAuthor("Nazwisko");

        Assert.assertEquals(0,this.authorService.findAllAuthors().size());

    }




}
