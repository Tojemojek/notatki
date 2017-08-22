package pl.sda.javawwa.kostrowski;

import static java.lang.Math.pow;

public class NumberTest {


    public static Boolean TestIfIsANumberStoredAsString(String testThis) {
        Boolean isNumber = false;

        for (int i = 0; i < testThis.length(); i++) {
            int tmpCharCode = testThis.codePointAt(i);
            if (hasCodeOfNumber(tmpCharCode) || hasCodeOfDotOrColon(tmpCharCode)) {
                isNumber = true;
            } else {
                return false;
            }

        }
        return isNumber;

    }

    private static Boolean hasCodeOfNumber(Integer tmpCharCode) {
        return (tmpCharCode > 47 && tmpCharCode < 58);
    }

    private static Boolean hasCodeOfDotOrColon(Integer tmpCharCode) {
        return (tmpCharCode.equals(44) || tmpCharCode.equals(46));
    }

    public static Double WhatIsANumberStoredAsString(String testThis) {
        Double tmpNumber;
        Character tmpChar;
        Double tmpMagnitude;
        tmpNumber = 0D;

        if (!TestIfIsANumberStoredAsString(testThis)) {
            return null;
        } else if (getSeparatorPos(testThis).equals(-1)) {
            for (int i = 0; i < testThis.length(); i++) {
                tmpChar = testThis.charAt(i);
                tmpMagnitude = pow(10, testThis.length() - i - 1);
                tmpNumber += (tmpChar - 48) * tmpMagnitude;
            }
        } else {
            //tmpSeparatorPos celowo małe int bo nie mam problemu z równością
            int tmpSeparatorPos = getSeparatorPos(testThis);
            for (int i = 0; i < tmpSeparatorPos; i++) {
                tmpChar = testThis.charAt(i);
                tmpMagnitude = pow(10, tmpSeparatorPos -  i - 1);
                tmpNumber += (tmpChar - 48) * tmpMagnitude;
            }
            for (int i = tmpSeparatorPos + 1; i < testThis.length(); i++) {
                tmpChar = testThis.charAt(i);
                tmpMagnitude = pow(10, tmpSeparatorPos - i);
                tmpNumber += (tmpChar - 48) * tmpMagnitude;
            }

        }

        return tmpNumber;


    }


    private static Integer magnitudeOfTen(String testThis) {
        return 0;
    }


    private static Integer getSeparatorPos(String testThis) {
        if (testThis.contains(".")) {
            return testThis.indexOf(".");
        } else if (testThis.contains(",")) {
            return testThis.indexOf(",");
        } else return -1;
    }

}
