package pl.sda.javawwa.pelnaWeryfikacjaPesel;

import java.time.LocalDate;
import java.time.Period;

public class Main {


    public static void main(String[] args) {

        System.out.println("Podaj testowany pesel");

        String pesel = Utils.getLineFromTerminal();

        PeselWeryfikacja peselWeryfikacja = new PeselWeryfikacja(pesel);
        peselWeryfikacja.runPeselCheck();


        if (pesel == null) {
            System.out.println("Nie wprowadziłeś danych");
        } else if (!peselWeryfikacja.getLenghtOK()) {
            System.out.println("Podana długość jest nieprawidłowa");
        } else if (!peselWeryfikacja.getIsNumber()) {
            System.out.println("W podanym ciągu dozwolone są tylko cyfry! W twoim masz inne znaki");
        } else if (!peselWeryfikacja.getControlSumOK()) {
            System.out.println("Suma kontrolna jest nieprawidłowa");
        } else if (peselWeryfikacja.getDateOfBirth() == null) {
            System.out.println("Data urodzin jest nieprawidłowa!");
        } else {
            System.out.println(String.format("Data urodzenia %s", peselWeryfikacja.getDateOfBirth()));

            //dodatkowa zabawa z czasem
            LocalDate doPorownania = LocalDate.of(2017, 04, 05);
            Integer wiek = Period.between(peselWeryfikacja.getDateOfBirth(), doPorownania).getYears();

            System.out.println(String.format("Wiek to %d lat", wiek));
            System.out.println("Płeć to " + ((peselWeryfikacja.isMale()) ? "mężczyzna" : "kobieta"));
        }


    }


}
