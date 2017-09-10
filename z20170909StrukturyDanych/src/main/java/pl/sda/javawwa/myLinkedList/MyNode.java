package pl.sda.javawwa.myLinkedList;

public class MyNode<T> {
    private T element;
    private MyNode<T> next;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object t) {
        return this.element.equals(t);
    }

}
