package pl.sda.javawwa.pelnaWeryfikacjaPesel;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner;

    public static String getLineFromTerminal() {

        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner.nextLine();

    }


}
