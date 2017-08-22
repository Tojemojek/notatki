package pl.sda.kostrowski.objects;

public class StudentSenior extends AbstractStudent {


    //ot druga klasa kolejnego rodzaju studenta,
    //bez znaczenia
    //oceny
    private Integer[] advancedMathGrades = new Integer[20];
    private Integer[] advancedScienceGrades = new Integer[20];
    private Integer[] advancedBiologyGrades = new Integer[20];
    private String[] allLecturesTypesNames = {"Advanced Math","Advanced Science","Advanced Biology"};

    public StudentSenior(String name, String lastName, String teacherName, String teacherLastName) {
        super(name, lastName, teacherName, teacherLastName);
    }

    @Override
    public String toString() {
        return "Uczeń nazywa się " + super.getName() + " " + super.getLastName()
                + " a jego wychowawcą jest "
                + super.getTeacherName() + " " + super.getTeacherLastName();
    }

    public Integer[] getAdvancedMathGrades() {
        return advancedMathGrades;
    }

    public void setAdvancedMathGrades(Integer advancedMathGrade, Integer position) {
        this.advancedMathGrades[position] = advancedMathGrade;
    }

    public Integer[] getAdvancedScienceGrades() {
        return advancedScienceGrades;
    }

    public void setAdvancedScienceGrades(Integer advancedScienceGrade,Integer position ) {
        this.advancedScienceGrades[position] = advancedScienceGrade;
    }

    public Integer[] getAdvancedBiologyGrades() {
        return advancedBiologyGrades;
    }

    public void setAdvancedBiologyGrades(Integer advancedBiologyGrade,Integer position) {
        this.advancedBiologyGrades[position] = advancedBiologyGrade;
    }

    public String[] getAllLecturesTypesNames() {
        return allLecturesTypesNames;
    }
}
