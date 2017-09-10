package pl.sda.javawwa.sort;


import java.util.Arrays;

public class MainSort {

    public static void main(String[] args) {
        int[] doPosortowania = {1, 9, 9, 18489, 5, 4, 16, 55, 8, 156};

        System.out.println("\nPrzed sortowaniem bubble sort");
        for (int iTmp : doPosortowania) {
            System.out.print(iTmp + ", ");
        }

        Sorting.bubblesort(doPosortowania);

        System.out.println("\nPo sortowaniu bubble sort");

        Arrays.stream(doPosortowania).forEach(s -> System.out.print(s + ", "));

        int[] doPosortowania2 = {1, 5, 4, 2, 8, 7};

        System.out.println("\nPrzed sortowaniem insertion sort");
        for (int iTmp : doPosortowania2) {
            System.out.print(iTmp + ", ");
        }

        Sorting.inserionSort(doPosortowania2);

        System.out.println("\nPo sortowaniu insertion sort");

        Arrays.stream(doPosortowania2).forEach(s -> System.out.print(s + ", "));


        int[] doPosortowania3 = {1, 9, 9, 18489, 5, 4, 16, 55, 8, 156};

        System.out.println("\nPrzed sortowaniem quickSort");
        for (int iTmp : doPosortowania3) {
            System.out.print(iTmp + ", ");
        }

        Sorting.quickSort(doPosortowania3);

        System.out.println("\nPo sortowaniu quickSort");

        Arrays.stream(doPosortowania3).forEach(s -> System.out.print(s + ", "));


    }


}
