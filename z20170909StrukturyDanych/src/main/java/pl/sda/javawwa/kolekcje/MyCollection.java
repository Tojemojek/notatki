package pl.sda.javawwa.kolekcje;

import java.util.Iterator;
import java.util.stream.Stream;

public interface MyCollection<T> {

    void add(T t);

    boolean remove(T t);

    boolean contains(T t);

    int size();

    Stream<T> stream();

    Iterator<T> iterator();

    boolean isEmpty();


}
