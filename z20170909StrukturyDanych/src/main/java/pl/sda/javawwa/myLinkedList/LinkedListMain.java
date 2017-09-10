package pl.sda.javawwa.myLinkedList;

public class LinkedListMain {

    public static void main(String[] args) {

        MyLinkedList<String> mllString = new MyLinkedList<>();

        mllString.add("5");
        mllString.add("10");
        mllString.add("20");
        mllString.add("30");

        System.out.println("\nTest czy działa add i traverse");
        mllString.traverse();


        System.out.println("\nTest czy działa for each");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nTest czy działa dodanie po elemencie");

        mllString.addAfter("10","15");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nTest czy dodatnie bez znalezionego elementu");

        mllString.addAfter("99","99");

        for (String s : mllString) {
            System.out.println(s);
        }



    }

}
