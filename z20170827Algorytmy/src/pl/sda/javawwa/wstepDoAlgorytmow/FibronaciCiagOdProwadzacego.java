package pl.sda.javawwa.wstepDoAlgorytmow;

import java.util.Scanner;

public class FibronaciCiagOdProwadzacego {

    public static void main(String[] args) {

        Long number1;
        Long wynik1;
        Long wynik2;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ile elementow ciagu chcesz wyswietlic: ");
        String userChoice = scanner.nextLine();

        try {
            number1 = Long.parseLong(userChoice);
        } catch (NumberFormatException e) {
            System.out.println("Wprowadzono nieprawidłowe dane");
            System.out.println(String.format("Twój wybór to %s a powinna być liczba całkowita", userChoice));
            return;
        }

        wynik1 = 1L;
        wynik2 = 1L;

        for (int i = 0; i < number1; i++) {

            if (i < 2) {
                System.out.print(String.format("%d -ity numer ciągu ma wartość %d\n", i+1, 1L));
                continue;
            }


            wynik2 = wynik1 + wynik2;
            wynik1 = wynik2 - wynik1;
            System.out.print(String.format("%d -ity numer ciągu ma wartość %d\n", i+1, wynik2));


        }

    }


}
