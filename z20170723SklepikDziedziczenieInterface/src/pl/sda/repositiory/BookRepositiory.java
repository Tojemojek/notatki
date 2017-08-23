package pl.sda.repositiory;

import pl.sda.objects.Book;


//interface - wymusza żeby wszystkie klasy go implementujące miały
//wymienione w nim metody - nie ma mowy jak mają te metody wyglądać
public interface BookRepositiory {

    void save(Book book);
    Book update(Book book);
    Book findBookById(Integer id);


}
