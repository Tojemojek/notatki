package pl.sda.javawwa.Tablice;

public class ZadanieZTablicami {

    public static void main(String[] args) {

        Integer tablica[] = new Integer[10];
        Integer suma = 0;

        System.out.println("wypełnienie liczbami od 1 do 10");
        for (int i = 0; i < 10; i++) {
            tablica[i] = i + 1;
        }
        writeTable(tablica);
        System.out.println("\nCo trzecia liczba dodaje do siebie poprzednika");
        for (int i = 2; i < 10; i += 3) {
            tablica[i] = tablica[i] + tablica[i - 1];
        }
        writeTable(tablica);
        System.out.println("\nParzyste na pół");
        for (int i = 0; i < 10; i++) {
            if (tablica[i] % 2 == 0) {
                tablica[i] = tablica[i] / 2;
            }

        }
        writeTable(tablica);

        System.out.println("\nSuma wszystkiego");
        for (Integer tmp : tablica) {
            suma = suma + tmp;
        }
        System.out.println(String.format("Suma całości to: %d", suma));
    }

    private static void writeTable(Integer[] tablica) {
        for (Integer tmp : tablica) {
            System.out.print(tmp + ", ");
        }
    }


}
