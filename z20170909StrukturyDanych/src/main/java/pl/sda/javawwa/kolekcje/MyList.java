package pl.sda.javawwa.kolekcje;

public interface MyList<T> extends MyCollection<T>, Iterable<T> {

    void add(int index, T t);

    boolean remove(int index);

    T get (int index);
}
