package pl.sda.javawwa.kostrowski.readonly;

import org.junit.Before;
import org.junit.Test;
import pl.sda.kostrowski.objects.StudentJunior;
import pl.sda.kostrowski.readonly.InDanger;
import pl.sda.kostrowski.readonly.InDangerJuniorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InDangerJuniorImplTest {

    private static StudentJunior[] studentJuniors = new StudentJunior[10];

    @Before
    public void initInDangerJuniorImplTest() {
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
    public void willPassTest() {
        Boolean test1,test2;


        InDanger tmpStudent1= new InDangerJuniorImpl(studentJuniors[0]);
        InDanger tmpStudent2= new InDangerJuniorImpl(studentJuniors[1]);

        test1 = tmpStudent1.willPass();
        test2 = tmpStudent2.willPass();

        assertTrue(test1);
        assertFalse(test2);

    }


    @Test
    public void isNiceTest() {

        InDanger tmpStudent1= new InDangerJuniorImpl(studentJuniors[0]);
        InDanger tmpStudent2= new InDangerJuniorImpl(studentJuniors[1]);

        assertFalse(tmpStudent1.isNice());
        assertTrue(tmpStudent2.isNice());


    }
}

