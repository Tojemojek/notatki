package pl.sda.javawwa.kostrowski.service;

import org.junit.Before;
import org.junit.Test;
import pl.sda.kostrowski.objects.StudentJunior;
import pl.sda.kostrowski.service.GradesJuniorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GradesJuniorImplTest {

    private static StudentJunior[] studentJuniors = new StudentJunior[10];

    @Before
    public void initDangerJuniorImplTest() {
        studentJuniors[0] = new StudentJunior("Imię1", "Nazwisko1", "Nimie", "NNazwisko");
        studentJuniors[1] = new StudentJunior("Imię2", "Nazwisko2", "Nimie", "NNazwisko");

        studentJuniors[0].setMathGrades(4,0);
        studentJuniors[0].setMathGrades(5,1);
        studentJuniors[0].setMathGrades(4,2);

        studentJuniors[0].setScienceGrades(4,0);
        studentJuniors[0].setBiologyGrades(4,0);

        studentJuniors[0].setStudentRemarks("nie jest miły",0);

        studentJuniors[1].setMathGrades(1,0);
        studentJuniors[1].setMathGrades(1,1);
        studentJuniors[1].setMathGrades(2,2);

        studentJuniors[1].setScienceGrades(4,0);
        studentJuniors[1].setBiologyGrades(4,0);


    }

    @Test
    public void addJuniorGrades() {

        GradesJuniorImpl tmpStudent = new GradesJuniorImpl(studentJuniors[0]);
        Integer[] tmpOceny;
        Integer tmpocena;

        //import przed dodaniem oceny
        tmpOceny = studentJuniors[0].getBiologyGrades();
        assertNull(tmpOceny[1]);

        tmpStudent.addGrade(3,"Biology");

        //sprawdzenie czy dodało się do dobrej tablicy
        tmpocena=tmpOceny[1];
        assertEquals("Spodziewam się oceny 3", (long)tmpocena,(long)3);

    }


}
