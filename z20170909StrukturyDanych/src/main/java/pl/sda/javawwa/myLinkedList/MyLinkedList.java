package pl.sda.javawwa.myLinkedList;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private MyNode<T> head;
    private MyNode<T> tail;

    public void add(T t) {
        MyNode<T> node = new MyNode<>();
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
        MyNode<T> tmpNode = head;

        while (true) {
            if (tmpNode == null) {
                System.out.println("Nie znaleziono takiego elementu");
                return false;
            }
            if (tmpNode.equals(after)) {

                MyNode<T> tmpNewNode = new MyNode<T>();
                tmpNewNode.setElement(t);

                tmpNewNode.setNext(tmpNode.getNext());
                tmpNode.setNext(tmpNewNode);
                return true;
            }

            tmpNode = tmpNode.getNext();
        }


    }


    public void traverse() {

        MyNode<T> tmp = head;

        while (true) {
            if (tmp == null) {
                return;
            }
            System.out.println(tmp.getElement());
            tmp = tmp.getNext();
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode<T> internalNode = head;

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
}

//stream do zaimplementowania
//Stream <T> stream(){
// return
//}
