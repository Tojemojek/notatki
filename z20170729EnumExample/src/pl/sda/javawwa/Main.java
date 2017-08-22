package pl.sda.javawwa;

import pl.sda.javawwa.enumexample.DniTygodnia;
import pl.sda.javawwa.enumexample.Level;
import pl.sda.javawwa.enumexample.MathOperation;
import pl.sda.javawwa.enumexample.UserStatus;

public class Main {

    public static void main(String[] args) {

        double value = MathOperation.MULTIPLICATION.calculate(5, 3);
        System.out.println("To działanie daje wynik: " + value);

        String opis = DniTygodnia.PONIEDZIALEK.returnDayOfWeek();

        System.out.println(opis);

        UserStatus userAccepted = UserStatus.ACCEPTED;
        UserStatus userNew = UserStatus.NEW;

        if (userAccepted.equals(userNew)) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are not the same");
        }

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println(Level.valueOf("HIGH"));
        System.out.println(Level.valueOf("HIGH").getLevelCode());
        System.out.println(Level.valueOf("HIGH").getLevelMessage());

        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println(Level.valueOf("LOW"));
        System.out.println(Level.valueOf("LOW").getLevelCode());
        System.out.println(Level.valueOf("LOW").getLevelMessage());




    }
}