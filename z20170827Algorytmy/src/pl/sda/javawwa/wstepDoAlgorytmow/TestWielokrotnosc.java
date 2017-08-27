package pl.sda.javawwa.wstepDoAlgorytmow;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class TestWielokrotnosc {

    public static void main(String[] args) {

        Integer number1;
        Integer number2;
        String userChoice1;
        String userChoice2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Program mnoży liczby ");
        System.out.println("Wprowadz pierwszą liczbę: ");
        userChoice1 = scanner.nextLine();
        System.out.println("Wprowadz drugą liczbę: ");
        userChoice2 = scanner.nextLine();

        try {
            number1 = Integer.parseInt(userChoice1);
            number2 = Integer.parseInt(userChoice2);
        } catch (NumberFormatException e) {
            System.out.println("Wprowadzone dane są nieprawidłowe.");
            System.out.printf("Wprowadzono %s, i %s", userChoice1, userChoice2);
            return;
        }
        System.out.printf("Wynik mnożenia %d i %d to %d\n", number1, number2, number1 * number2);
        //Równoważnikiem jest ale printf jest mniej polecany, bo działa tylko z sys.out
        System.out.println(String.format("Wynik mnożenia %d i %d to %d", number1, number2, number1 * number2));

    }
}
