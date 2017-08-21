package pl.sda.javawwa.unchecked;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) {


        try {
            doSomething();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        }


//        try {
//            throwsUchecked();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        } finally{
//            System.out.println("W bloku finally");
//        }


    }


//    public static void throwsUchecked() {
//
//        if (true) {
//            throw new ArithmeticException("A test exception");
//        }
//
//        Integer i = null;
//        i.toString();
//
//
//    }

    public static void doSomething() throws FileNotFoundException, EOFException {

        throwChecked();
        if (true) {
            throw new EOFException();
        }
    }

    public static void throwChecked() throws FileNotFoundException {

        throw new FileNotFoundException();

    }


}
