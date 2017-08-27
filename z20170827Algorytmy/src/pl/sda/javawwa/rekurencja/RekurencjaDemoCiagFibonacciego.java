package pl.sda.javawwa.rekurencja;

import java.util.Scanner;

public class RekurencjaDemoCiagFibonacciego {


    public static void main(String[] args) {

        Integer ktoregoElementuSzukac;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj który wyraz ciągu chcesz sprawdzić:");
        String userChoice = scanner.nextLine();

        try {
            ktoregoElementuSzukac = Integer.parseInt(userChoice);
        } catch (NumberFormatException e) {
            System.out.println("Wprowadzono nieprawidłowe dane");
            System.out.println(String.format("Twój wybór to %s a powinna być liczba całkowita", userChoice));
            return;
        }

        System.out.println(recurrent(ktoregoElementuSzukac));
    }

    private static int recurrent(int elem) {
        if (elem == 1 || elem == 2) {
            return 1;
        }
        return recurrent(elem - 1) + recurrent(elem - 2);
    }


}

