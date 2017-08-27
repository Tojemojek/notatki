package pl.sda.javawwa.rekurencja;

import java.util.Scanner;

public class RekurencjaDemoSilnia {


    public static void main(String[] args) {

        Integer ktoregoElementuSzukac;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chcesz policzyć silnię dla liczby:");
        String userChoice = scanner.nextLine();

        try {
            ktoregoElementuSzukac = Integer.parseInt(userChoice);
        } catch (NumberFormatException e) {
            System.out.println("Wprowadzono nieprawidłowe dane");
            System.out.println(String.format("Twój wybór to %s a powinna być liczba całkowita", userChoice));
            return;
        }

        System.out.println(silnia(ktoregoElementuSzukac));
    }

    private static int silnia(int elem) {
        if (elem < 2) {
            return 1;
        }
        return silnia(elem - 1) * elem;
    }


}

