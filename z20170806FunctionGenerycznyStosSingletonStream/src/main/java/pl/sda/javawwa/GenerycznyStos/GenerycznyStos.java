package pl.sda.javawwa.GenerycznyStos;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class GenerycznyStos<T> implements Stack<T> {

    private LinkedList<T> myList;

    public GenerycznyStos() {
        myList = new LinkedList<>();
    }

    @Override
    public void push(T number) {
        this.myList.addLast(number);
    }

    @Override
    public T pop() {
        if (myList.isEmpty()){
            throw new EmptyStackException();
        }
        return this.myList.pollLast();

    }

    @Override
    public T peek() {
        if (myList.isEmpty()){
            throw new EmptyStackException();
        }
        return this.myList.peekLast();
    }

    @Override
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    @Override
    public Integer size() {
        return this.myList.size();
    }
}
