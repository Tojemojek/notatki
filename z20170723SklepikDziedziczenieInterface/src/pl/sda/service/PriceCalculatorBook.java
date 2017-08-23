package pl.sda.service;

import pl.sda.objects.Book;
import pl.sda.objects.Product;

public class PriceCalculatorBook extends AbstractProductService{

    public static final Integer BOOK_MARGIN =10;

    @Override
    public Integer calculatePrice(Product product) {

        return product.getBasePrice() + BOOK_MARGIN;
    }

    public Integer calculatePrice(Book book) {
            return calculatePrice(book);
    }

}
