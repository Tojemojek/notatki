package pl.sda.javawwa.Tablice;

public class LiczbyPierwszeSitemErastotenesa {
    public static void main(String[] args) {

        Integer rozmiarTablicy = 500;
        Integer[] dane = new Integer[rozmiarTablicy];
        int j;
        int tmp;

        System.out.println("Przypisanie danych do tablicy");
        for (int i = 0; i < rozmiarTablicy; i++) {
            dane[i] = i + 1;
        }
        for (Integer tmp1 : dane) {
            System.out.print(tmp1 + ", ");
        }
        System.out.println("\nEfekt sita");
        for (int i = 1; i < rozmiarTablicy; i++) {
            if (!dane[i].equals(0)) {
                j = 2 * dane[i] - 1;
                while (j < rozmiarTablicy) {
                    dane[j] = 0;
                    j += dane[i];
                }
            }
        }
        for (Integer tmp1 : dane) {
            if (!tmp1.equals(0)) {
                System.out.print(tmp1 + ", ");
            }
        }
    }
}



