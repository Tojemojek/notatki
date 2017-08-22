package pl.sda.kostrowski.objects;

public abstract class AbstractStudent {
    //uznałem że dzienniczek ma służyć do obsługi uczniów
    //założyłem, że uczniowe róznych klas będą mieli inne przedmioty nauczania
    //klasa o mniejszej ilości cechy wspólnych byłaby moim zdaniem zbędna

    //opis ucznia
    private String name;
    private String lastName;

    //opis wychowacy
    private String teacherName;
    private String teacherLastName;

    //dzienniczek z uwagami
    //na siłę założona wielkość, z listami byłoby lepiej to rozwiązane
    //przy czym użyłbym tu listy która pamięta kolejność,
    //żeby była zachowana "historyczna ciągłość" uwag
    private String[] studentRemarks = new String[50];

    public AbstractStudent(String name, String lastName, String teacherName, String teacherLastName) {
        this.name = name;
        this.lastName = lastName;
        this.teacherName = teacherName;
        this.teacherLastName = teacherLastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public String[] getStudentRemarks() {
        return studentRemarks;
    }

    public void setStudentRemarks(String isStudentNice, Integer position) {
        this.studentRemarks[position] = isStudentNice;
    }
}
