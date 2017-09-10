package pl.sda.javawwa.kolekcje;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class MyArrayList<T> extends MyAbstractDynamicArray<T> implements MyList<T> {

    public MyArrayList() {
        super();
    }

    public MyArrayList(int initialSize) {
        super(initialSize);
    }

    @Override
    public void add(T t) {
        ensureCapacity();

        array[index] = t; //this.array[index++] = t;
        index++;
    }

    @Override
    public boolean remove(T t) {
        return false;
    }

    @Override
    public boolean contains(T t) {
        return stream().anyMatch(p -> p.equals(t));
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public Stream<T> stream() {
        return Arrays.stream(array, 0, index);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int internalIndex = 0;

            @Override
            public boolean hasNext() {
                return internalIndex < index;
            }

            @Override
            public T next() {
                return array[internalIndex++];
            }
        };
    }


    @Override
    public void add(int index, T t) {
    }

    @Override
    public boolean remove(int localRemove) {
        ensureRange(localRemove);

        for (int i = localRemove; i < index - 1; i++) {
            array[i] = array[i + 1];
        }
        index--;
        return false;
    }



    @Override
    public T get(int index) {
        ensureRange(index);

        return array[index];
    }

    private void ensureRange(int rangeIndex) {
        if (rangeIndex < 0 || rangeIndex >= this.index) {
            throw new IndexOutOfBoundsException("Wyjście poza zakres tablicy" + rangeIndex);
        }
    }

}
