package pl.sda.javawwa.Tablice;

import java.util.Scanner;

public class LiczbyPierwszeSitemErastotenesaBool {
    public static void main(String[] args) {

        Integer rozmiarTablicy;
        Integer j;
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


        boolean[] dane = new boolean[rozmiarTablicy + 1];
        for (int i = 0; i < rozmiarTablicy + 1; i++) {
            dane[i] = true;
        }

        for (int i = 2; i < rozmiarTablicy + 1; i++) {
            if (dane[i]) {
                j = 2 * i;
                while (j < rozmiarTablicy + 1) {
                    dane[j] = false;
                    j += i;
                }
            }
        }

        for (int i = 2; i < rozmiarTablicy + 1; i++) {
            if (dane[i])
                System.out.print(i + ", ");
        }

    }
}



