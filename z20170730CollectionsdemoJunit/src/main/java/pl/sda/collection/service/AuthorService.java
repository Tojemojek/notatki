package pl.sda.collection.service;

import pl.sda.collection.model.Author;

import java.util.HashSet;
import java.util.Set;

public class AuthorService {

    private Set<Author> authors;


    public AuthorService() {
        this.authors = new HashSet<>();
    }

    public void addNewAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(String lastName) {

        for (Author authortmp: this.authors)
            if (authortmp.getSecondName().equals(lastName)){
                this.authors.remove(authortmp);
            }
    }


    public Set<Author> findAllAuthors() {
        return this.authors;
    }

}
