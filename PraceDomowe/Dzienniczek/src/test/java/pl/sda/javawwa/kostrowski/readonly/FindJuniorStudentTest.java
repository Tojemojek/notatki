package pl.sda.javawwa.kostrowski.readonly;

import org.junit.Before;
import org.junit.Test;
import pl.sda.kostrowski.objects.StudentJunior;
import pl.sda.kostrowski.readonly.FindJuniorStudent;


import static org.junit.Assert.assertEquals;


public class FindJuniorStudentTest {

    private static StudentJunior[] studentJuniors = new StudentJunior[10];

    @Before
    public void initFindJuniorTest() {
        studentJuniors[0] = new StudentJunior("Imię1", "Nazwisko1", "Nimie", "NNazwisko");
        studentJuniors[1] = new StudentJunior("Imię2", "Nazwisko2", "Nimie", "NNazwisko");

    }

    @Test
    public void FindJuniorStudentByNameTest() {


        int foundStudentPos1;
        int foundStudentPos2;

        FindJuniorStudent studentTestInDanger = new FindJuniorStudent(studentJuniors);

        foundStudentPos1 = studentTestInDanger.findStudentPos("Imię1", "Nazwisko1");
        foundStudentPos2 = studentTestInDanger.findStudentPos("asdasd", "asdsad");

        assertEquals(foundStudentPos1, 0);
        assertEquals(foundStudentPos2, -1);

    }


}
