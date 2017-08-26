package pl.sda.javawwa.model;

public class Book {

    private String title;
    private String authorName;
    private String authorLastName;

    private int pages;
    private int publishYear;
    private String isbn;

    public Book(String title, String authorName, String authorLastName, int pages, int publishYear, String isbn) {
        this.title = title;
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.pages = pages;
        this.publishYear = publishYear;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", pages=" + pages +
                ", publishYear=" + publishYear +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pages != book.pages) return false;
        if (publishYear != book.publishYear) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authorName != null ? !authorName.equals(book.authorName) : book.authorName != null) return false;
        if (authorLastName != null ? !authorLastName.equals(book.authorLastName) : book.authorLastName != null)
            return false;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        result = 31 * result + pages;
        result = 31 * result + publishYear;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }
}