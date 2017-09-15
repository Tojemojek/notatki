package pl.sda.javawwa.kolekcjePracaDomowa;

public class MyNodePD<T> {
    private T element;
    private MyNodePD<T> next;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public MyNodePD<T> getNext() {
        return next;
    }

    public void setNext(MyNodePD<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object t) {
        return this.element.equals(t);
    }

}
