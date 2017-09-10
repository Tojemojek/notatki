package pl.sda.javawwa.sort;

public class Sorting {

    public static void bubblesort(int[] tab) {
        boolean niePosortowana = false;
        int tmp;


        if (tab == null) {
            return;
        }

        do {
            niePosortowana = false;
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                    niePosortowana = true;
                }
            }
        } while (niePosortowana);
    }

    public static void inserionSort(int[] tab) {

        int minIndex;
        int minTmp;

        if (tab == null) {
            return;
        }

        for (int j = 0; j < tab.length; j++) {
            minIndex = j;
            minTmp = tab[j];
            for (int i = j; i < tab.length; i++) {
                if (minTmp > tab[i]) {
                    minTmp = tab[i];
                    minIndex = i;
                }

            }
            tab[minIndex] = tab[j];
            tab[j] = minTmp;

        }
    }

    public static void quickSort(int[] tab) {
        quickSortInternal(tab, 0, tab.length - 1);
    }

    private static void quickSortInternal(int tab[], int start, int end) {
        int i, j, pivot, temp;

        i = start;
        j = end;
        pivot = tab[(start + end) / 2];

        do {
            while (tab[i] < pivot)
                i++;

            while (pivot < tab[j])
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

}

