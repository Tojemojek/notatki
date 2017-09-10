package pl.sda.javawwa.kolekcjeTest;

import pl.sda.javawwa.kolekcje.MyStack;

public class MainStact {


    public static void main(String[] args) {

        MyStack<String> stactTest = new MyStack<>();

        stactTest.push("Ala");
        stactTest.push("ma");
        stactTest.push("kota");
        stactTest.push("który");
        stactTest.push("jest");
        stactTest.push("wredny");

        System.out.println("\nTest traverse");
        stactTest.traverse();


        System.out.println("\nTest peek");
        stactTest.peek();
        stactTest.traverse();

        System.out.println("\nTest pop");
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();
        stactTest.pop();



    }
}
