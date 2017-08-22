package pl.sda.kostrowski;

import pl.sda.kostrowski.objects.StudentJunior;

import java.util.Random;

public class Main {
    private static StudentJunior[] studentJuniors = new StudentJunior[10];

    public static void main(String[] args) {
        initializeApp();


    }


    private static void initializeApp() {
        initializeStudents();

    }

    private static void initializeStudents() {

        Random randomn = new Random();
        Integer howManyGrades = randomn.nextInt(10) + 1;


        for (int i = 0; i < 5; i++) {
            studentJuniors[i] = new StudentJunior("Imię" + i, "Nazwisko" + i,
                    "NaImię" + i, "NaNazwisko" + i);

            Random randomn2 = new Random();
            Integer randGrade = randomn2.nextInt(6) + 1;

            for (int j = 0; j < howManyGrades; j++) {
                studentJuniors[i].setBiologyGrades(randGrade, j);
                studentJuniors[i].setMathGrades(randGrade, j);
                studentJuniors[i].setScienceGrades(randGrade, j);
            }
        }



    }
}


