package pl.sda.javawwa.bookAndBasket;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket {

    private Map<Book, Integer> myBasket = new HashMap<>();

    public void clearBasket() {
        myBasket.clear();
    }

    public boolean addToBasket(Book book) {
        int noOfBooks;

        if (book != null && myBasket.containsKey(book)) {
            noOfBooks = myBasket.get(book);
            noOfBooks++;
            myBasket.replace(book, noOfBooks);
            return true;
        } else if (book != null) {
            myBasket.put(book, 1);
            return true;
        }
        return false;
    }

    public Set<Book> setOfBooksInBasket() {
        return myBasket.keySet();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        double sumaCen = 0d;

        if (myBasket.size() ==0){
            return "Koszyk jest pusty";
        }

        for (Map.Entry<Book, Integer> en : myBasket.entrySet()) {
            sb.append(en.getValue());
            sb.append("\t");
            sb.append(en.getKey());
            sb.append("\n");
            sumaCen += en.getValue() * en.getKey().getPrice();

        }
        sb.append(String.format("Wartość koszyka \t%.2f",sumaCen));

        return sb.toString();
    }
}
