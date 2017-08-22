package pl.sda.collection.service;

import pl.sda.collection.model.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BookService {

    private List<Book> collections;

    public BookService() {
        this.collections = new ArrayList<>();
    }

    public void addNewBook(Book book) {
        this.collections.add(book);
    }

    public List<Book> getAllBooks() {
        return this.collections;
    }

    public Book findBookByTitleAndAuthor(String title, String author) {

        for (Book book : this.collections) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public Boolean removeBook(Book book) {
        return this.collections.remove(book);
    }

//to nie ma prawa zadziałać na liście
//    public void removeBookByTitle(String title) {
//        this.collections.listIterator()
//        for (Book booktmp: this.collections)
//            if (title.equals(booktmp.getTitle())){
//                this.collections.remove(booktmp);
//            }
//    }


    public void removeBookByTitle(String title) {

        Iterator<Book> iteratorTmp = this.collections.iterator();

        while (iteratorTmp.hasNext()) {
            if (iteratorTmp.next().getTitle().equals(title)) {
                iteratorTmp.remove();
            }
        }

    }


}

