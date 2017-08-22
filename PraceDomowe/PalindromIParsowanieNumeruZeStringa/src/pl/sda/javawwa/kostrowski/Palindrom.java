package pl.sda.javawwa.kostrowski;

public class Palindrom {


    public static Boolean TestPalindrom (String testThis) {

       String odwroc = "";

        for (int i = 0; i < testThis.length(); i++) {
            odwroc += testThis.charAt(testThis.length() - i - 1);
        }

        if (testThis.equals(odwroc)) {
            return true;
        } else {
            return false;
        }


    }

}
