package pl.sda.javawwa.Tablice;

import java.util.Scanner;

public class LiczbyPierwszeSitemErastotenesa {
    public static void main(String[] args) {

        Integer rozmiarTablicy;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj do jakiej wartości chcesz sporawdzać:");
        String userChoice = scanner.nextLine();

        try {
            rozmiarTablicy = Integer.parseInt(userChoice);
        } catch (NumberFormatException e) {
            System.out.println("Wprowadzono nieprawidłowe dane");
            System.out.println(String.format("Twój wybór to %s a powinna być liczba całkowita", userChoice));
            return;
        }

        Integer[] dane = new Integer[rozmiarTablicy];
        int j;

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



