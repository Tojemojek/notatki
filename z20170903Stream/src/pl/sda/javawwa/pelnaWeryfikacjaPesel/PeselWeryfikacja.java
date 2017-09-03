package pl.sda.javawwa.pelnaWeryfikacjaPesel;

import java.time.DateTimeException;
import java.time.LocalDate;

public class PeselWeryfikacja {

    private static final int DLUGOSC_NR_PESEL = 11;
    private String peselTmp = null;
    private Boolean isMale = null;
    private LocalDate dateOfBirth = null;
    private Boolean lenghtOK, isNumber, controlSumOK;
    private Boolean validPesel;

    public void runPeselCheck() {

        this.verificateLenght();

        if (lenghtOK) {
            this.verificateIfNumber();
            if (isNumber) {
                this.checkControlSum();
                if (controlSumOK) {
                    this.calculateBirthDate();
                    this.whatIsSex();
                }
            }
        }
    }


    public Boolean isMale() {
        return isMale;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Boolean getLenghtOK() {
        return lenghtOK;
    }

    public Boolean getIsNumber() {
        return isNumber;
    }

    public Boolean getControlSumOK() {
        return controlSumOK;
    }

    public PeselWeryfikacja(String peselTmp) {
        this.peselTmp = peselTmp;
    }


    private void verificateLenght() {
        lenghtOK = peselTmp.length() == DLUGOSC_NR_PESEL;
    }


    private void verificateIfNumber() {
        long tmpLong;

        try {
            tmpLong = Long.parseLong(peselTmp);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }
    }


    private void checkControlSum() {

        int[] mnozniki = new int[]{9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        int[] intTmp = new int[11];
        int sumaKontrolna = 0;
        char[] charArr = peselTmp.toCharArray();

        for (int i = 0; i < 11; i++) {
            intTmp[i] = charArr[i] - 48;
        }

        for (int i = 0; i < 10; i++) {
            sumaKontrolna += intTmp[i] * mnozniki[i];
        }

        sumaKontrolna = sumaKontrolna % 2;

        if (intTmp[10] == sumaKontrolna) {
            controlSumOK = true;
        } else {
            controlSumOK = false;
        }
    }

    private void calculateBirthDate() {

        int mntTemp = Integer.parseInt(peselTmp.substring(2, 4));
        int yearTemp = Integer.parseInt(peselTmp.substring(0, 2));
        int dayTemp = Integer.parseInt(peselTmp.substring(4, 6));


        if (mntTemp > 0 && mntTemp < 13) {
            yearTemp += 1900;
        } else if (mntTemp > 20 && mntTemp < 33) {
            yearTemp += 2000;
        } else if (mntTemp > 40 && mntTemp < 53) {
            yearTemp += 2100;
        } else if (mntTemp > 60 && mntTemp < 73) {
            yearTemp += 2200;
        } else if (mntTemp > 80 && mntTemp < 93) {
            yearTemp += 1800;
        }

        LocalDate birthDate = null;
        try {
            dateOfBirth = LocalDate.of(yearTemp, mntTemp, dayTemp);
        } catch (DateTimeException e) {
            dateOfBirth = null;
        }
    }

    private void whatIsSex() {
        if (Integer.valueOf(peselTmp.substring(10, 11)) % 2 == 0) {
            isMale = true;
        } else {
            isMale = false;
        }
    }

}
