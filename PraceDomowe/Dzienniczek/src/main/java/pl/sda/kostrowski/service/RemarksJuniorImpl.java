package pl.sda.kostrowski.service;

import pl.sda.kostrowski.objects.StudentJunior;

public class RemarksJuniorImpl implements Remarks {


    private StudentJunior localStudentJunior;
    private String[] tmpRemarksList;
    private Integer indexOfEmptyRemarkPosition;

    //dużo prostrza wersji z dodawaniem ocen.
    //import studenta któremu dopisujemy oceny
    public RemarksJuniorImpl(StudentJunior studentJunior) {
        this.localStudentJunior = studentJunior;
    }


    @Override
    public void addRemark(String newRemark) {
        if (isItPossibleToAddNewRemark()) {
            localStudentJunior.setStudentRemarks(newRemark,indexOfEmptyRemarkPosition);
        }
    }

    private void makeTmpRemarksList () {
                tmpRemarksList = localStudentJunior.getStudentRemarks();
        }

    private Integer getIndexOfEmptyPlaceForNewRemark() {
        Integer index = 0;
        makeTmpRemarksList();
        for (String tmpRemark : tmpRemarksList) {
            if (tmpRemark == null) {
                return index;
            }
            index++;
        }
        return index;
    }

    private Boolean isItPossibleToAddNewRemark(){
        indexOfEmptyRemarkPosition = getIndexOfEmptyPlaceForNewRemark();
        return indexOfEmptyRemarkPosition !=null && indexOfEmptyRemarkPosition < tmpRemarksList.length;
    }

}
