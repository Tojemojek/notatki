package pl.sda.javawwa.kolekcjeZSortowaniem;

import java.util.UUID;

public class MyArrayListPerformanceTest {

    public static void main(String[] args) {

        int maxLenght = 10000;

        MyArrayListWithSort<String> list1 = new MyArrayListWithSort<String>();
        MyArrayListWithSort<String> list2 = new MyArrayListWithSort<String>();
        MyArrayListWithSort<String> list3 = new MyArrayListWithSort<String>();

        for (int i = 0; i < maxLenght; i++) {
            list1.add(UUID.randomUUID().toString());
        }
        for (int i = 0; i < maxLenght; i++) {
            list2.add(UUID.randomUUID().toString());
        }
        for (int i = 0; i < maxLenght; i++) {
            list3.add(UUID.randomUUID().toString());
        }

        long startTimeQS = System.nanoTime();

        list1.quickSort();

        long stopTimeQS = System.nanoTime();

        System.out.println((stopTimeQS - startTimeQS) / 1000000 + " QuickSort time");


        long startTimeIS = System.nanoTime();

        list2.inserionSort();

        long stopTimeIS = System.nanoTime();

        System.out.println((stopTimeIS - startTimeIS) / 1000000 + " Insertion sort");


        long startTimeBS = System.nanoTime();

        list3.bubblesort();

        long stopTimeBS = System.nanoTime();

        System.out.println((stopTimeBS - startTimeBS) / 1000000 + " Bubble sort");

    }
}
