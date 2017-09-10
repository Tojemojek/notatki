package pl.sda.javawwa.kolekcje;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public abstract class MyAbstractDynamicArray<T>{

    protected T array[];
    protected int index = 0;
    protected int maxIndex;


    public MyAbstractDynamicArray() {
        array = (T[]) new Object[2];
        maxIndex = 1;
    }

    public MyAbstractDynamicArray(int initialSize) {
        array = (T[]) new Object[initialSize];
        maxIndex = initialSize - 1;
    }

    protected void ensureCapacity() {
        if (index > maxIndex) {

            array = Arrays.copyOf(array,(maxIndex + 1) * 2);
            maxIndex = array.length - 1;
            System.out.println("Zmieniono długość tablicy na " + array.length);
        }
    }

}
