package pl.sda.javawwa.model;

import java.util.List;

public class Library {

    private String city;
    private List<Book> books;

    public Library(String city, List<Book> books) {
        this.city = city;
        this.books = books;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
