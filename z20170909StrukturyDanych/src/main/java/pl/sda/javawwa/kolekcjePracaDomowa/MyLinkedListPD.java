package pl.sda.javawwa.kolekcjePracaDomowa;

import java.util.Iterator;
import java.util.stream.Stream;

public class MyLinkedListPD<T> implements Iterable<T> {

    private MyNodePD<T> head;
    private MyNodePD<T> tail;

    public void add(T t) {
        MyNodePD<T> node = new MyNodePD<>();
        node.setElement(t);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public boolean addAfter(T after, T t) {
        MyNodePD<T> tmpNode = head;

        while (true) {
            if (tmpNode == null) {
                System.out.println("Nie znaleziono takiego elementu");
                return false;
            }
            if (tmpNode.equals(after)) {
                if (after.equals(tail.getElement())) {
                    add(t);
                    return true;
                } else {
                    MyNodePD<T> tmpNewNode = new MyNodePD<T>();
                    tmpNewNode.setElement(t);

                    tmpNewNode.setNext(tmpNode.getNext());
                    tmpNode.setNext(tmpNewNode);
                    return true;
                }
            }

            tmpNode = tmpNode.getNext();
        }


    }


    public void removeHead() {

        if (head == null) {
            tail = null;
            System.out.println("Brak elementów do usunięcia");
        } else if (head.getElement().equals(tail.getElement())) {
            tail = null;
            head = null;

        } else {
            head = head.getNext();
        }
    }

    public void removeTail() {

        MyNodePD<T> tmp = head;
        MyNodePD<T> tmp2 = head;

        if (tail == null) {
            head = null;
            System.out.println("Brak elementów do usunięcia");
        } else if (head.getElement().equals(tail.getElement())) {
            tail = null;
            head = null;

        } else {
            while (true) {
                tmp2 = tmp;
                tmp = tmp.getNext();
                if (tmp == tail) {
                    tail = tmp2;
                    tmp2.setNext(null);
                    return;
                }
            }
        }
    }

    public boolean removeAfter(T t) {
        MyNodePD<T> tmp = head;
        MyNodePD<T> tmp2 = head;

        if (contains(t)) {
            if (tmp == tail) {
                return false;
            }

            while (tmp != null) {
                if (tmp.getElement().equals(t)) {
                    tmp2 = tmp.getNext();
                    if (tmp2 == tail) {
                        tail = tmp;
                        tmp.setNext(null);
                        return true;
                    }
                    tmp.setNext(tmp2.getNext());
                    return true;
                }
                tmp = tmp.getNext();
            }

        }

        return false;
    }

    public void traverse() {

        MyNodePD<T> tmp = head;

        while (true) {
            if (tmp == null) {
                return;
            }
            System.out.println(tmp.getElement());
            tmp = tmp.getNext();
        }
    }

    public int size() {
        MyNodePD<T> tmp = head;
        int elementsCount;
        elementsCount = 0;

        while (true) {
            if (tmp == null) {
                break;
            }
            elementsCount++;
            tmp = tmp.getNext();
        }
        return elementsCount;
    }

    public boolean contains(T t) {
        return stream().anyMatch(p -> p.equals(t));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNodePD<T> internalNode = head;

            @Override
            public boolean hasNext() {
                return internalNode != null;
            }

            @Override
            public T next() {
                T tmp = internalNode.getElement();
                internalNode = internalNode.getNext();
                return tmp;
            }
        };
    }

    Stream<T> stream() {

        Stream.Builder<T> builder = Stream.builder();
        MyNodePD<T> tmp = head;

        while (true) {
            if (tmp == null) {
                break;
            }
            builder.add(tmp.getElement());
            tmp = tmp.getNext();
        }

        return builder.build();
    }


}
