package pl.sda.javawwa.find;

import pl.sda.javawwa.sort.Sorting;

public class BinaryFindMain {

    public static void main(String[] args) {
        int[] doPosortowania = {1, 9, 9, 18489, 5, 4, 16, 55,  8, 156};
        Sorting.bubblesort(doPosortowania);

        System.out.println("Zbiór w którym wyszukujemy");
        for (int intTmp: doPosortowania){
            System.out.print(intTmp + ", ");
        }

        System.out.println("\n\nSzukamy i wyświetlamy index wartości 9");
        int pos9 = BinaryFind.findInSortedArray(doPosortowania, 9);

        System.out.println("9 jest na indeksie " + pos9);

        System.out.println("\nSzukamy i wyświetlamy index wartości 18489");
        int pos18489 = BinaryFind.findInSortedArray(doPosortowania, 18489);

        System.out.println("18489 jest na indeksie " + pos18489);

        System.out.println("\nSzukamy i wyświetlamy index wartości 9999 (powinien być -1)");
        int pos999 = BinaryFind.findInSortedArray(doPosortowania, 999);

        System.out.println("999 jest na indeksie " + pos999);

    }
}