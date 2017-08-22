package pl.sda.javawwa.GenerycznyStos;

public interface Stack<T> {

    void push(T number);

    T pop();

    T peek();

    boolean isEmpty();

    Integer size();
}
