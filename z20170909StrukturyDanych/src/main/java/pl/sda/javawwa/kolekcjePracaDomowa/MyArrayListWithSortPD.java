package pl.sda.javawwa.kolekcjePracaDomowa;

import pl.sda.javawwa.kolekcje.MyAbstractDynamicArray;
import pl.sda.javawwa.kolekcje.MyList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class MyArrayListWithSortPD<T extends Comparable<T>> extends MyAbstractDynamicArray<T> implements MyList<T> {

    public MyArrayListWithSortPD() {
        super();
    }

    public MyArrayListWithSortPD(int initialSize) {
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
        if (contains(t)) {
            int myIndex = giveIndex(t);
            for (int i = myIndex; i < index; i++) {
                array[i] = array[i + 1];
            }
            index--;
            return true;

        }
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
        ensureRange(index);
        ensureCapacity();

        for (int i = this.index; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = t;


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
            throw new IndexOutOfBoundsException("Wyjście poza zakres tablicy  - podany index " + rangeIndex);
        }
    }


    public void bubblesort() {
        boolean niePosortowana = false;
        T tmp;

        if (index == 0) {
            return;
        }

        do {
            niePosortowana = false;
            for (int i = 0; i < index - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    niePosortowana = true;
                }
            }
        } while (niePosortowana);
    }


    public void inserionSort() {

        int minIndex;
        T minTmp;

        if (index == 0) {
            return;
        }

        for (int j = 0; j < index; j++) {
            minIndex = j;
            minTmp = array[j];
            for (int i = j; i < index; i++) {
                if (minTmp.compareTo(array[i]) > 0) {
                    minTmp = array[i];
                    minIndex = i;
                }

            }
            array[minIndex] = array[j];
            array[j] = minTmp;
        }
    }

    public int findInSortedArray(T findThis) {

        boolean notFound = true;

        int indexDiv;
        int indexStart = 0;
        int indexEnd = index - 1;

        do {

            indexDiv = (indexStart + indexEnd) / 2 + 1;

            if (findThis.equals(array[indexDiv])) {
                return indexDiv;
            }
            if (indexEnd == indexStart) {
                return -1;
            }
            if (findThis.compareTo(array[indexDiv]) > 0) {
                indexStart = indexDiv;
            } else {
                indexEnd = indexDiv - 1;
            }

        } while (notFound);

        return -1;
    }


    public void quickSort() {
        quickSortInternal(array, 0, index - 1);
    }

    private void quickSortInternal(T tab[], int start, int end) {
        int i, j;
        T pivot, temp;

        i = start;
        j = end;
        pivot = tab[(start + end) / 2];

        do {
            while (tab[i].compareTo(pivot) < 0)
                i++;

            while (pivot.compareTo(tab[j]) < 0)
                j--;

            if (i <= j) {
                temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (start < j)
            quickSortInternal(tab, start, j);
        if (i < end)
            quickSortInternal(tab, i, end);
    }


    private int giveIndex(T t) {
        for (int i = 0; i < index; i++) {
            if (array[i].equals(t))
                return i;
        }
        return -1;

    }
}
