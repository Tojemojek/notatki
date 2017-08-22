package pl.sda.kostrowski.readonly;

import pl.sda.kostrowski.objects.StudentJunior;

public class InDangerJuniorImpl implements InDanger {

    private StudentJunior localStudentJunior;

    private Integer[] mathGrades;
    private Integer[] scienceGrades;
    private Integer[] biologyGrades;
    private static final Integer MINIMUM_SCORE_TO_PASS = 3;
    private static final Integer VERY_BAD_SCORE = 1;

    //konstruktorek
    public InDangerJuniorImpl(StudentJunior studentJunior) {
        this.localStudentJunior = studentJunior;
        biologyGrades = studentJunior.getBiologyGrades();
        scienceGrades = studentJunior.getScienceGrades();
        mathGrades = studentJunior.getMathGrades();
    }

    //zakładam że do zdania potrzebna jest minimalna średnia
    //ze wszystkich przedmiotów - oblanie dowolnego to oblanie
    @Override
    public Boolean willPass() {
        if (avrgBiologyGrade() >MINIMUM_SCORE_TO_PASS
                && avrgMathGrade() >MINIMUM_SCORE_TO_PASS
                && avrgScienceGrade() >MINIMUM_SCORE_TO_PASS) {
            return true;
        }
        return false;
    }


    //student jest grzeczny tylko jeśli nie ma uwag
    //niejawne założenie że uwagi dodawane są od początku tablicy
    //i tablica nie ma żadnych miejsce pustych
    @Override
    public Boolean isNice() {
        if (localStudentJunior.getStudentRemarks()[0] == null) {
            return true;
        }
        return false;

    }


    private Double avrgScienceGrade() {
        Double sumGrades = 0D;
        Integer numberOfGrades = 0;

        for (Integer grade: scienceGrades){
            if (grade == null){
                break;
            }
            sumGrades += grade;
            numberOfGrades ++;
        }

        if (numberOfGrades > 0) {
            System.out.println("Srednia z fizy to: " + sumGrades/numberOfGrades);
            return sumGrades/numberOfGrades;
        }
        return 0D;
    }

    private Double avrgMathGrade() {
        Double sumGrades = 0D;
        Integer numberOfGrades = 0;

        for (Integer grade: mathGrades){
            if (grade == null){
                break;
            }
            sumGrades += grade;
            numberOfGrades ++;
        }

        if (numberOfGrades > 0) {
            System.out.println("Srednia z matmy to: " + sumGrades/numberOfGrades);
            return sumGrades/numberOfGrades;

        }
        return 0D;
    }

    private Double avrgBiologyGrade() {
        Double sumGrades = 0D;
        Integer numberOfGrades = 0;

        for (Integer grade: biologyGrades){
            if (grade == null){
                break;
            }
            sumGrades += grade;
            numberOfGrades ++;
        }

        if (numberOfGrades > 0) {
            System.out.println("Srednia z biologi to: " + sumGrades/numberOfGrades);
            return sumGrades/numberOfGrades;
        }
        return 0D;
    }




    public Integer howManyVeryBadScoresBiology() {

        Integer numberOfBadGrades = 0;

        for (Integer grade: biologyGrades){
            if (grade == null){
                break;
            }
            if (grade.equals(VERY_BAD_SCORE)){
                numberOfBadGrades ++;
            }

        }
        return numberOfBadGrades;
    }


    public Integer howManyVeryBadScoresMaths() {

        Integer numberOfBadGrades = 0;

        for (Integer grade: mathGrades){
            if (grade == null){
                break;
            }
            if (grade.equals(VERY_BAD_SCORE)){
                numberOfBadGrades ++;
            }

        }
        return numberOfBadGrades;
    }


    public Integer howManyVeryBadScoresScience() {

        Integer numberOfBadGrades = 0;

        for (Integer grade: scienceGrades){
            if (grade == null){
                break;
            }
            if (grade.equals(VERY_BAD_SCORE)){
                numberOfBadGrades ++;
            }

        }
        return numberOfBadGrades;
    }


}
