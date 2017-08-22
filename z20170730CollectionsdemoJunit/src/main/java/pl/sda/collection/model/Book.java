package pl.sda.collection.model;

import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private LocalDate dateOfPublish;

    public Book(String title, String author, LocalDate dateOfPublish) {
        this.title = title;
        this.author = author;
        this.dateOfPublish = dateOfPublish;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDateOfPublish() {
        return dateOfPublish;
    }
}
