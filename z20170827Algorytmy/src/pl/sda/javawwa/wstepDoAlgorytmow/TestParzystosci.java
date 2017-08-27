package pl.sda.javawwa.wstepDoAlgorytmow;

import java.util.Scanner;

public class TestParzystosci {

    public static void main(String[] args) {

        Integer number;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wprowadz liczbę: ");
        String userChoice = scanner.nextLine();

        try {
            number = Integer.parseInt(userChoice);
        } catch (NumberFormatException e) {
            System.out.println("Nie wprowadzono liczby, kończę pracę");
            return;
        }

        userChoice = "Tekst wpisny w celach pokazowych";
        if (number % 2 == 0 ){
            System.out.println(String.format("Wprowadzona liczba %d jest parzysta. Wartość podana przez użytkownika %s",number, userChoice));
        } else {
            System.out.println("Wprowadzona liczba nie jest parzysta");
        }




    }


}
