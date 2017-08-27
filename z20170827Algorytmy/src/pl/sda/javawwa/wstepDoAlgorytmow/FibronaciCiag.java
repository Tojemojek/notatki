package pl.sda.javawwa.wstepDoAlgorytmow;

import java.util.Scanner;

public class FibronaciCiag {

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


        if (number1 < 3) {
            System.out.println("Po co wyświetlać mniej niż 3 wartości ciągu?");
        } else {
            System.out.println("Wyrazy ciągu Fibbonaciego to:");
            System.out.print("1, 1");
            wynik1 = 1L;
            wynik2 = 1L;

            for (int i = 2; i < number1; i++) {
                System.out.print(", "+wynik1 + wynik2);
                wynik2 = wynik1 + wynik2;
                wynik1 = wynik2 - wynik1;
            }
            System.out.print(".");


        }

    }


}
