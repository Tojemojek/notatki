package pl.sda.javawwa.bookAndBasket;

public class Book {

    private String author;
    private String title;
    private Double price;

    public Book(String author, String title, Double price) {

        if (author == null || author.isEmpty() || author.length() <3){
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (title == null || title.isEmpty() || title.length() <3){
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (price <= 0 ){
            throw new IllegalArgumentException("Price can't be negative");
        }

        this.author = author.trim();
        this.title = title.trim();
        this.price = price;
    }


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return price != null ? price.equals(book.price) : book.price == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Autor \t%s, tytuł \t%s, \tcena %.2f",author,title,price);
    }
}
