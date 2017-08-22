package pl.sda.javawwa.kostrowski.service;

import org.junit.Before;
import org.junit.Test;
import pl.sda.kostrowski.objects.StudentJunior;
import pl.sda.kostrowski.service.RemarksJuniorImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class RemarksJuniorImplTest {

    private static StudentJunior[] studentJuniors = new StudentJunior[10];

    @Before
    public void initRemarksAddTest() {
        studentJuniors[0] = new StudentJunior("Imię1", "Nazwisko1", "Nimie", "NNazwisko");

        studentJuniors[0].setStudentRemarks("nie jest miły", 0);


    }

    @Test
    public void addJuniorGradesTest() {

        String tmpRemark1, tmpRemark2;

        RemarksJuniorImpl tmpStudent = new RemarksJuniorImpl(studentJuniors[0]);

        //przed dodaniem
        tmpRemark1 = studentJuniors[0].getStudentRemarks()[0];
        tmpRemark2 = studentJuniors[0].getStudentRemarks()[1];


        assertNotNull(tmpRemark1);
        assertNull(tmpRemark2);

        tmpStudent.addRemark("Jest jeszcze gorzej");

        //po dodaniu
        tmpRemark1 = studentJuniors[0].getStudentRemarks()[0];
        tmpRemark2 = studentJuniors[0].getStudentRemarks()[1];

        assertNotNull(tmpRemark1);
        assertNotNull(tmpRemark2);

        assertEquals("Jest jeszcze gorzej",tmpRemark2);


    }
}
