package pl.sda.kostrowski.service;

import pl.sda.kostrowski.objects.StudentJunior;

public class GradesJuniorImpl implements Grades {


    private StudentJunior localStudentJunior;
    private Integer[] tmpGradeList;
    private Integer indexOfEmptyGradePosition;

    //import studenta któremu dopisujemy oceny
    public GradesJuniorImpl(StudentJunior studentJunior) {
        this.localStudentJunior = studentJunior;
    }


    @Override
    public void addGrade(Integer newGrade, String courseName) {
        if (isGradeCorrect(newGrade) && testIfCourseNameIsCorrect(courseName)
                && isItPossibleToAddNewGrade()) {
            setCorrectCourseGrades(newGrade, courseName);
        }

    }

    //wyszukiwanie czy nazwa kursu jest poprawna
    //jeśli tak przypisanie referencji do lokalnej kopii tablicy ocen
    private Boolean testIfCourseNameIsCorrect(String courseName) {
        Boolean testOfCourseName = false;
        for (String tmpCourseName : localStudentJunior.getAllLecturesTypesNames()) {
            if (tmpCourseName.equals(courseName)) {
                testOfCourseName = true;
                makeTmpGrades(courseName);
            }

        }
        return testOfCourseName;

    }

    //wyszukiwanie tablicy ocen właściwej do nazwy kurstu
    //i zaimportowanie jej do lokalnej tablicy
    //to jest mi potrzebne
    //by mieć tylko jedną funkcję szukającą numeru wolnego miejsca na ocenę
    private void makeTmpGrades(String courseName) {
        switch (courseName) {
            case "Math":
                tmpGradeList = localStudentJunior.getMathGrades();
                break;
            case "Science":
                tmpGradeList = localStudentJunior.getScienceGrades();
                break;
            case "Biology":
                tmpGradeList = localStudentJunior.getBiologyGrades();
                break;
        }

    }


    //po wszystkich testach
    private void setCorrectCourseGrades(Integer grade, String courseName) {
        if (testIfCourseNameIsCorrect(courseName)) {
            switch (courseName) {
                case "Math":
                    localStudentJunior.setMathGrades(grade, indexOfEmptyGradePosition);
                    break;
                case "Science":
                    localStudentJunior.setScienceGrades(grade, indexOfEmptyGradePosition);
                    break;
                case "Biology":
                    localStudentJunior.setBiologyGrades(grade, indexOfEmptyGradePosition);
                    break;
            }
        }
    }


    //dzięki temu że mam tylko jedną tablicę z ocenami,
    //nie muszę tu używać switch w tym przypadku
    //żeby znaleźć właściwą nazwę przedmiotu
    private Integer getIndexOfEmptyPlaceForNewGrade() {
        Integer index = 0;
        for (Integer tmpGrade : tmpGradeList) {
            if (tmpGrade == null) {
                return index;
            }
            index++;
        }
        return index;
    }

    private Boolean isItPossibleToAddNewGrade(){
        indexOfEmptyGradePosition = getIndexOfEmptyPlaceForNewGrade();
        return indexOfEmptyGradePosition!=null
                && indexOfEmptyGradePosition < tmpGradeList.length;
    }

    private Boolean isGradeCorrect(Integer grade){
        return grade >0 && grade <7;
    }





}
