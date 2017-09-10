package pl.sda.javawwa.find;

public class BinaryFind {

    public static int findInSortedArray(int[] tab, int findThis) {

        boolean notFound = true;

        int indexDiv;
        int indexStart = 0;
        int indexEnd = tab.length - 1;


        do {

            indexDiv = (indexStart + indexEnd) / 2 + 1;

            if (findThis == tab[indexDiv]) {
                return indexDiv;
            }
            if (indexEnd == indexStart) {
                return -1;
            }
            if (findThis > tab[indexDiv]) {
                indexStart = indexDiv;
            } else {
                indexEnd = indexDiv - 1;
            }

        } while (notFound);

        return -1;
    }
}
