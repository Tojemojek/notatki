package pl.sda.kostrowski.readonly;

import pl.sda.kostrowski.objects.StudentJunior;

public class FindJuniorStudent implements FindStudent {

    private StudentJunior[] studentJunior;

    //konstruktor
    public FindJuniorStudent(StudentJunior[] studentJunior) {
        this.studentJunior = studentJunior;
    }


    //teraz chyba bym zwrócił obiekt a nie jego numer w tablicy.
    //choć zwrócenie numeru w tablicy bardziej do mnie przemawia.
    @Override
    public Integer findStudentPos(String name, String lastName) {
        Integer studentPosNr = 0;

        for (StudentJunior tmpStudentJunior : studentJunior) {
            if (studentExists(tmpStudentJunior, name, lastName)) {
                return studentPosNr;
            }
            studentPosNr++;
        }
        //żeby nie zwracać null a jednocześnie żeby nie była to pozycja z tablicy
        return -1;
    }

    // naprostsze znalezeienie studenta + zabezpieczenie przed null w pętli
    private Boolean studentExists(StudentJunior studentJunior, String name, String lastName) {
        return studentJunior != null
                && studentJunior.getName().equals(name)
                && studentJunior.getLastName().equals(lastName);

    }

}