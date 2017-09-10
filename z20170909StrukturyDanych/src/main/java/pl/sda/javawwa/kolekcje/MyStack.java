package pl.sda.javawwa.kolekcje;

import java.util.Arrays;

public class MyStack<T> extends MyAbstractDynamicArray<T> {

    public MyStack() {
        super();
    }

    public MyStack(int initialSize) {
        super(initialSize);
    }

    public void push(T t) {
        ensureCapacity();
        array[index] = t;
        index++;
    }


    public T pop() {
        return array[--index];
    }

    public T peek() {
        return array[index - 1];
    }

    public void traverse() {
        Arrays.stream(array, 0, index).forEach(System.out::println);
    }


}
