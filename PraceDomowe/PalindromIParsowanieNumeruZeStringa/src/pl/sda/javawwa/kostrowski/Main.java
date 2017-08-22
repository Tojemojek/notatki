package pl.sda.javawwa.kostrowski;

public class Main {

    private static final String TEST_THIS_PALINDROM = "ikararaki";
    private static final String TEST_THIS_NUMBER = "1234,5";


    public static void main(String[] args) {

        System.out.println("This is palindrom: " + Palindrom.TestPalindrom(TEST_THIS_PALINDROM));

        System.out.println("To jest numer: " + NumberTest.TestIfIsANumberStoredAsString(TEST_THIS_NUMBER));

        System.out.println(NumberTest.WhatIsANumberStoredAsString(TEST_THIS_NUMBER));

    }
}
