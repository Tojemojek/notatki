package pl.sda.javawwa;

public class Main {

    public static void main(String[] args) {

        String nowyString1 = "ala";

        //startswith
        Boolean startsWith1 = nowyString1.startsWith("To");
        Boolean startsWith2 = nowyString1.startsWith("to");

        System.out.println(startsWith1);
        System.out.println(startsWith2);

        //replacefirst
        String replaceFirst = nowyString1.replaceFirst("To", "Tamto");
        System.out.println(replaceFirst);

        //replaceall
        String replaceAll = nowyString1.replaceAll("a", "ł");
        System.out.println(replaceAll);

        //lastindexof
        Integer lastindexof1 = nowyString1.lastIndexOf("a");
        System.out.println(lastindexof1);

        //lastindexof
        System.out.println("Last index of z nr");
        Integer lastindexof2 = nowyString1.lastIndexOf("a",5);
        System.out.println(lastindexof2);
//
//        //lastindexof
//        Integer lastindexof3 = nowyString1.lastIndexOf(1);
//        System.out.println(lastindexof3);

        //endswith




//endswith
//contains
//concat
//


    }
}
