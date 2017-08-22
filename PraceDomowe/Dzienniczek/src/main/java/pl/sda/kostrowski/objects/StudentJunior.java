package pl.sda.kostrowski.objects;

public class StudentJunior extends AbstractStudent {

    //oceny
    private Integer[] mathGrades = new Integer[20];
    private Integer[] scienceGrades = new Integer[20];
    private Integer[] biologyGrades = new Integer[20];
    private String[] allLecturesTypesNames = {"Math","Science","Biology"};

    public StudentJunior(String name, String lastName, String teacherName, String teacherLastName) {
        super(name, lastName, teacherName, teacherLastName);
    }

    @Override
    public String toString() {
        return "Uczeń nazywa się " + super.getName() + " " + super.getLastName()
                + " a jego wychowawcą jest "
                + super.getTeacherName() + " " + super.getTeacherLastName();
    }

    public Integer[] getMathGrades() {
        return mathGrades;
    }



    //wiem że gettety i settery mają różną postać
    //założyłem że oceny zawsze są dodawane pojedyńczo a wyciągane od razu wszystki
    //bo tak mi się to wydawało logiczniejsze.


    public void setMathGrades(Integer mathGrade, Integer position) {
        this.mathGrades[position] = mathGrade;
    }


    public Integer[] getScienceGrades() {
        return scienceGrades;
    }

    public void setScienceGrades(Integer scienceGrade, Integer position) {
        this.scienceGrades[position] = scienceGrade;
    }

    public Integer[] getBiologyGrades() {
        return biologyGrades;
    }

    public void setBiologyGrades(Integer biologyGrade, Integer position) {
        this.biologyGrades[position] = biologyGrade;
    }

    public String[] getAllLecturesTypesNames() {
        return allLecturesTypesNames;
    }

}
